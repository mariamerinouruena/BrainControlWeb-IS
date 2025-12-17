package com.is.braincontrolweb.war.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;;

public class EventoAccionTest {
    private EventoAccion eventoAccion;

    @BeforeEach
    public void setUp() {
        eventoAccion = new EventoAccion();
    }

    @Test
    @DisplayName("omprueba que el ID del evento se asigna y obtiene correctamente")
    public void testGetSetIdEventoAccion() {
        //arrange
        String id = "EVT12345";
        String tipo = "TipoPrueba";
        LocalDateTime fechaHora = LocalDateTime.now();
        String posicion = "PosicionPrueba";
        String resultado = "ResultadoPrueba";
        int tiempoReaccion = 150;
        //act
        EventoAccion eventoAccion = new EventoAccion(id, tipo, fechaHora, posicion, resultado, tiempoReaccion);
        //assert
        assertEquals(id, eventoAccion.getIdEvento());
        assertEquals(tipo, eventoAccion.getTipo());
        assertEquals(fechaHora, eventoAccion.getDate());
        assertEquals(posicion, eventoAccion.getPosicion());
        assertEquals(resultado, eventoAccion.getResultado());
        assertEquals(tiempoReaccion, eventoAccion.getTiempoReaccion());
    }

    @Test
    @DisplayName("Comprueba que el ID del evento se gestiona correctamente")
    public void idEvento_setGet_Correcto() {
        //Arrange
        String id = "TEST001";
        //Act
        eventoAccion.setIdEvento(id);
        //Assert
        assertEquals(id, eventoAccion.getIdEvento());
    }

    @Test
    @DisplayName("Comprueba que el tipo de acción se gestiona correctamente")
    public void tipo_setGet_Correcto() {
        //Arrange
        String tipo = "AccionPrueba";
        //Act
        eventoAccion.setTipo(tipo);
        //Assert
        assertEquals(tipo, eventoAccion.getTipo());
        
    }

    @Test
    @DisplayName("Comprueba que la fecha se gestiona correctamente")
    public void date_setGet_Correcto() {
        //Arrange
        LocalDateTime fechaHora = LocalDateTime.of(2024, 6, 15, 10, 30);
        //Act
        eventoAccion.setDate(fechaHora);
        //Assert
        assertEquals(fechaHora, eventoAccion.getDate());
    }

    @Test
    @DisplayName("Comprueba que la posición se gestiona correctamente") 
    public void posicion_setGet_Correcto() {
        //Arrange
        String posicion = "PosicionPrueba";
        //Act
        eventoAccion.setPosicion(posicion);
        //Assert
        assertEquals(posicion, eventoAccion.getPosicion());
    }

    @Test
    @DisplayName("Comprueba que el resultado se gestiona correctamente")
    public void resultado_setGet_Correcto() {
        //Arrange
        String resultado = "ResultadoPrueba";
        //Act
        eventoAccion.setResultado(resultado);
        //Assert
        assertEquals(resultado, eventoAccion.getResultado());
    }
    @Test
    @DisplayName("Comprueba que el tiempo de reacción se gestiona correctamente")
    public void tiempoReaccion_setGet_Correcto() {
        //Arrange
        int tiempoReaccion = 200;
        //Act
        eventoAccion.setTiempoReaccion(tiempoReaccion);
        //Assert
        assertEquals(tiempoReaccion, eventoAccion.getTiempoReaccion());
    }

}
