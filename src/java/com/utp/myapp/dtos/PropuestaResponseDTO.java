package com.utp.myapp.dtos;

import java.math.BigDecimal;

public class PropuestaResponseDTO {

    private Integer propuestaId;
    private String mensajePropuesta;
    private BigDecimal montoOfertado;
    private String tiempoEstimado;
    private String fechaEnvio; // Formateada como String para la vista

    // Datos del profesional que envía la propuesta
    private Integer profesionalId;
    private String nombreProfesional;
    private String fotoProfesionalUrl;
    private BigDecimal calificacionProfesional;

    public PropuestaResponseDTO() {}

    public PropuestaResponseDTO(Integer propuestaId, String mensajePropuesta, BigDecimal montoOfertado, String tiempoEstimado, String fechaEnvio, Integer profesionalId, String nombreProfesional, String fotoProfesionalUrl, BigDecimal calificacionProfesional) {
        this.propuestaId = propuestaId;
        this.mensajePropuesta = mensajePropuesta;
        this.montoOfertado = montoOfertado;
        this.tiempoEstimado = tiempoEstimado;
        this.fechaEnvio = fechaEnvio;
        this.profesionalId = profesionalId;
        this.nombreProfesional = nombreProfesional;
        this.fotoProfesionalUrl = fotoProfesionalUrl;
        this.calificacionProfesional = calificacionProfesional;
    }

    // Getters y Setters
    public Integer getPropuestaId() { return propuestaId; }
    public void setPropuestaId(Integer propuestaId) { this.propuestaId = propuestaId; }
    public String getMensajePropuesta() { return mensajePropuesta; }
    public void setMensajePropuesta(String mensajePropuesta) { this.mensajePropuesta = mensajePropuesta; }
    public BigDecimal getMontoOfertado() { return montoOfertado; }
    public void setMontoOfertado(BigDecimal montoOfertado) { this.montoOfertado = montoOfertado; }
    public String getTiempoEstimado() { return tiempoEstimado; }
    public void setTiempoEstimado(String tiempoEstimado) { this.tiempoEstimado = tiempoEstimado; }
    public String getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(String fechaEnvio) { this.fechaEnvio = fechaEnvio; }
    public Integer getProfesionalId() { return profesionalId; }
    public void setProfesionalId(Integer profesionalId) { this.profesionalId = profesionalId; }
    public String getNombreProfesional() { return nombreProfesional; }
    public void setNombreProfesional(String nombreProfesional) { this.nombreProfesional = nombreProfesional; }
    public String getFotoProfesionalUrl() { return fotoProfesionalUrl; }
    public void setFotoProfesionalUrl(String fotoProfesionalUrl) { this.fotoProfesionalUrl = fotoProfesionalUrl; }
    public BigDecimal getCalificacionProfesional() { return calificacionProfesional; }
    public void setCalificacionProfesional(BigDecimal calificacionProfesional) { this.calificacionProfesional = calificacionProfesional; }
}