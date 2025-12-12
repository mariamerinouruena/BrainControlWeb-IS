package com.is.braincontrolweb.war.controller;

import com.is.braincontrolweb.war.domain.EventoAccion;
import com.is.braincontrolweb.war.service.EventoAccionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventos-accion")
public class EventoAccionController {

    private final EventoAccionService eventoAccionService;

    public EventoAccionController(EventoAccionService eventoAccionService) {
        this.eventoAccionService = eventoAccionService;
    }

    @PostMapping
    public ResponseEntity<EventoAccion> createEventoAccion(@RequestBody EventoAccion eventoAccion) {
        EventoAccion savedEventoAccion = eventoAccionService.saveEventoAccion(eventoAccion);
        return ResponseEntity.created(URI.create("/api/evento-accion/" + savedEventoAccion.getIdEvento()))
                .body(savedEventoAccion);
    }

    @GetMapping
    public List<EventoAccion> getAllEventoAcciones() {
        return eventoAccionService.getAllEventoAcciones();
    }

    @GetMapping("/{idEvento}")
    public ResponseEntity<EventoAccion> getEventoAccionById(@PathVariable String idEvento) {
        Optional<EventoAccion> eventoAccion = eventoAccionService.getEventoAccionById(idEvento);
        if(eventoAccion.isPresent()) {
            return ResponseEntity.ok(eventoAccion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idEvento}")
    public ResponseEntity<Void> deleteEventoAccion(@PathVariable String idEvento) {
        eventoAccionService.deleteEventoAccionById(idEvento);
        return ResponseEntity.noContent().build();
    }
}
