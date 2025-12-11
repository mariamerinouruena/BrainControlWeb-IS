package com.is.braincontrolweb.war.service;

import com.is.braincontrolweb.war.domain.EventoAccion;
import com.is.braincontrolweb.war.repository.EventoAccionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EventoAccionService {
    private final EventoAccionRepository eventoAccionRepository;

    public EventoAccionService(EventoAccionRepository eventoAccionRepository) {
        this.eventoAccionRepository = eventoAccionRepository;
    }

    @Transactional
    public EventoAccion saveEventoAccion(EventoAccion eventoAccion) {
        return eventoAccionRepository.save(eventoAccion);
    }

    @Transactional(readOnly = true)
    public List<EventoAccion> getAllEventoAcciones() {
        return eventoAccionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<EventoAccion> getEventoAccionById(String idEvento) {
        return eventoAccionRepository.findById(idEvento);
    }
}
