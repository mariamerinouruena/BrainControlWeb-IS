package com.is.braincontrolweb.war.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class EventoAccion {
    
    //Clave primaria
    @Id
    @Column(name = "id_evento", length = 50, nullable = false)
    private String idEvento;

    @Column(name = "tipo", length = 100)
    private String tipo;

    @Column(name = "fecha_hora")
    private LocalDateTime date;

    @Column(name = "posicion")
    private String posicion;

    @Column(name = "resultado", length = 255)
    private String resultado;

    @Column(name = "tiempo_reaccion")
    private int tiempoReaccion;

    public EventoAccion() {
    }

    public EventoAccion(String idEvento, String tipo, LocalDateTime date, String posicion, String resultado, int tiempoReaccion) {
        this.idEvento = idEvento;
        this.tipo = tipo;
        this.date = date;
        this.posicion = posicion;
        this.resultado = resultado;
        this.tiempoReaccion = tiempoReaccion;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }   

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getTiempoReaccion() {
        return tiempoReaccion;
    }

    public void setTiempoReaccion(int tiempoReaccion) {
        this.tiempoReaccion = tiempoReaccion;
    }

    
}
