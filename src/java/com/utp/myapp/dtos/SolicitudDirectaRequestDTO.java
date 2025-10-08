package com.utp.myapp.dtos;

import java.math.BigDecimal;

public class SolicitudDirectaRequestDTO {

    private Integer clienteId;
    private Integer profesionalId;
    private String titulo;
    private String descripcionProblema;
    private BigDecimal presupuestoMin;
    private BigDecimal presupuestoMax;
    private String urgencia;

    public SolicitudDirectaRequestDTO() {}

    public SolicitudDirectaRequestDTO(Integer clienteId, Integer profesionalId, String titulo, String descripcionProblema, BigDecimal presupuestoMin, BigDecimal presupuestoMax, String urgencia) {
        this.clienteId = clienteId;
        this.profesionalId = profesionalId;
        this.titulo = titulo;
        this.descripcionProblema = descripcionProblema;
        this.presupuestoMin = presupuestoMin;
        this.presupuestoMax = presupuestoMax;
        this.urgencia = urgencia;
    }

    // Getters y Setters
    public Integer getClienteId() { return clienteId; }
    public void setClienteId(Integer clienteId) { this.clienteId = clienteId; }
    public Integer getProfesionalId() { return profesionalId; }
    public void setProfesionalId(Integer profesionalId) { this.profesionalId = profesionalId; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcionProblema() { return descripcionProblema; }
    public void setDescripcionProblema(String descripcionProblema) { this.descripcionProblema = descripcionProblema; }
    public BigDecimal getPresupuestoMin() { return presupuestoMin; }
    public void setPresupuestoMin(BigDecimal presupuestoMin) { this.presupuestoMin = presupuestoMin; }
    public BigDecimal getPresupuestoMax() { return presupuestoMax; }
    public void setPresupuestoMax(BigDecimal presupuestoMax) { this.presupuestoMax = presupuestoMax; }
    public String getUrgencia() { return urgencia; }
    public void setUrgencia(String urgencia) { this.urgencia = urgencia; }
}