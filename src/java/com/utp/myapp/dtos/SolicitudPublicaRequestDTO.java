package com.utp.myapp.dtos;

import java.math.BigDecimal;

public class SolicitudPublicaRequestDTO {
    
    private int clienteId;
    private int categoriaId;
    private String titulo;
    private String descripcion;
    private BigDecimal presupuestoMin;
    private BigDecimal presupuestoMax;
    private String urgencia;
    private String plazoEntrega;

    public SolicitudPublicaRequestDTO() {}

    public SolicitudPublicaRequestDTO(int clienteId, int categoriaId, String titulo, String descripcion, BigDecimal presupuestoMin, BigDecimal presupuestoMax, String urgencia, String plazoEntrega) {
        this.clienteId = clienteId;
        this.categoriaId = categoriaId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.presupuestoMin = presupuestoMin;
        this.presupuestoMax = presupuestoMax;
        this.urgencia = urgencia;
        this.plazoEntrega = plazoEntrega;
    }

    // Getters y Setters
    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPresupuestoMin() {
        return presupuestoMin;
    }

    public void setPresupuestoMin(BigDecimal presupuestoMin) {
        this.presupuestoMin = presupuestoMin;
    }

    public BigDecimal getPresupuestoMax() {
        return presupuestoMax;
    }

    public void setPresupuestoMax(BigDecimal presupuestoMax) {
        this.presupuestoMax = presupuestoMax;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getPlazoEntrega() {
        return plazoEntrega;
    }

    public void setPlazoEntrega(String plazoEntrega) {
        this.plazoEntrega = plazoEntrega;
    }
}