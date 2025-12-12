package com.is.braincontrolweb.war.controller;
import com.is.braincontrolweb.war.domain.EventoAccion; // Importa la Entidad
import com.is.braincontrolweb.war.service.EventoAccionService; // Importa el Servicio
import java.util.List;
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/eventos-accion")

public class EventoAccionWebController {
    
    @Autowired
    private EventoAccionService eventoAccionService;


    @GetMapping
    public String listarEventosAccion(Model model) {
        List<EventoAccion> eventos = eventoAccionService.getAllEventoAcciones();

        model.addAttribute("listaEventos", eventos);
        return "lista-eventos";
        }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("eventoAccion", new EventoAccion());
        return "formulario-eventos";
        }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable String id, Model model) {     
        Optional<EventoAccion> eventoAccion = eventoAccionService.getEventoAccionById(id);
       
        if (eventoAccion.isPresent()) {
        model.addAttribute("eventoAccion", eventoAccion.get());    
        return "formulario-eventos";
        } else {
            return "redirect:/eventos-accion";
        }
    }

    @PostMapping("/guardar")
    public String guardarEventoAccion(@ModelAttribute EventoAccion eventoAccion, RedirectAttributes redirectAttributes) {
    
        eventoAccionService.saveEventoAccion(eventoAccion);
        redirectAttributes.addFlashAttribute("mensaje", "Evento de Acción guardado correctamente.");
            return "redirect:/eventos-accion";
    }

    @PostMapping("/borrar/{id}")
    public String borrarEventoAccion(@PathVariable String id, RedirectAttributes redirectAttributes) {

        eventoAccionService.deleteEventoAccionById(id);
        redirectAttributes.addFlashAttribute("mensaje", "Evento de Acción eliminado.");
        return "redirect:/eventos-accion";
        // aqui hay que añadir en el controller qu ehico marioa el metodo delete 
    }

}
