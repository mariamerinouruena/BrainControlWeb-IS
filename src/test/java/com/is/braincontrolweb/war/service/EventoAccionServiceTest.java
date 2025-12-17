package com.is.braincontrolweb.war.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.is.braincontrolweb.war.domain.EventoAccion;
import com.is.braincontrolweb.war.repository.EventoAccionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EventoAccionServiceTest {
    @Mock
    private EventoAccionRepository eventoAccionRepository;

    @InjectMocks
    private EventoAccionService eventoAccionService;

    @Test
    @DisplayName("Comprueba que se guarda un evento de acción correctamente")
    public void saveEventoAccion_Correcto() {
        //Arrange
        EventoAccion evento = new EventoAccion();
        evento.setIdEvento("EVT001");
        when(eventoAccionRepository.save(any(EventoAccion.class))).thenReturn(evento);
        //Act
        EventoAccion resultado = eventoAccionService.saveEventoAccion(evento);
        //Assert
        assertNotNull(resultado);
        assertEquals("EVT001", resultado.getIdEvento());
        verify(eventoAccionRepository, times(1)).save(evento);
    }

    @Test
    @DisplayName("Comprueba que se obtienen todos los eventos de acción")
    public void getAllEventoAcciones_Correcto() {
        //Arrange
        EventoAccion evento1 = new EventoAccion();
        EventoAccion evento2 = new EventoAccion();
        List<EventoAccion> eventos = Arrays.asList(evento1, evento2);
        when(eventoAccionRepository.findAll()).thenReturn(eventos);
        //Act
        List<EventoAccion> resultado = eventoAccionService.getAllEventoAcciones();
        //Assert
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(eventoAccionRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Comprueba que se obtiene un evento de acción por ID")
    public void getEventoAccionById_Correcto() {
        //Arrange
        String id = "EVT001";
        EventoAccion evento = new EventoAccion(id, "Tipo1", null, "Pos1", "Resultado1", 100);
        when(eventoAccionRepository.findById(id)).thenReturn(Optional.of(evento));
        //Act
        Optional<EventoAccion> resultado = eventoAccionService.getEventoAccionById(id);
        //Assert
        assertTrue(resultado.isPresent());
        assertEquals(id, resultado.get().getIdEvento());
        verify(eventoAccionRepository, times(1)).findById(id);
    }

    @Test
    @DisplayName("Comprueba que se elimina un evento de acción por ID")
    public void deleteEventoAccionById_Correcto() {
        //Arrange
        String id = "EVT001";
        doNothing().when(eventoAccionRepository).deleteById(id);
        //Act
        eventoAccionService.deleteEventoAccionById(id);
        //Assert
        verify(eventoAccionRepository, times(1)).deleteById(id);
    }

}
