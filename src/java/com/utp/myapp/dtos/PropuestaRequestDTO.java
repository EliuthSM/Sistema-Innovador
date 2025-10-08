package com.utp.myapp.dtos;

import java.math.BigDecimal;

public class PropuestaRequestDTO {
    private int solicitudPublicaId;
    private int profesionalId;
    private String mensaje;
    private String mensajePropuesta;
    private BigDecimal montoOfertado;
    private String tiempoEstimado;

    public PropuestaRequestDTO() {}

    // Constructor completo y Getters/Setters...
    public PropuestaRequestDTO(int solicitudPublicaId, int profesionalId, String mensaje, BigDecimal montoOfertado, String tiempoEstimado) {
        this.solicitudPublicaId = solicitudPublicaId;
        this.profesionalId = profesionalId;
        this.mensaje = mensaje;
        this.montoOfertado = montoOfertado;
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getSolicitudPublicaId() {
        return solicitudPublicaId;
    }

    public void setSolicitudPublicaId(int solicitudPublicaId) {
        this.solicitudPublicaId = solicitudPublicaId;
    }

    public int getProfesionalId() {
        return profesionalId;
    }

    public void setProfesionalId(int profesionalId) {
        this.profesionalId = profesionalId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public BigDecimal getMontoOfertado() {
        return montoOfertado;
    }

    public void setMontoOfertado(BigDecimal montoOfertado) {
        this.montoOfertado = montoOfertado;
    }

    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
    
    public String getMensajePropuesta() {
        return mensajePropuesta;
    }
    public void setMensajePropuesta(String mensajePropuesta) {
        this.mensajePropuesta = mensajePropuesta;
    }
    
}