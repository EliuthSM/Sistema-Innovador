package com.utp.myapp.dtos;

import java.math.BigDecimal;

public class SolicitudPublicaResponseDTO {

    private Integer solicitudId;
    private String titulo;
    private String categoriaNombre;
    private String presupuestoRango;
    private String fechaPublicacion;
    private String urgencia;
    private String ubicacion;
    private String plazoEntrega;
    private String clienteNombre;
    private BigDecimal clienteCalificacion;
    private Integer clienteTotalProyectos;
    private Integer totalPropuestas;

    public SolicitudPublicaResponseDTO() {}

    public SolicitudPublicaResponseDTO(Integer solicitudId, String titulo, String categoriaNombre, String presupuestoRango, String fechaPublicacion, String urgencia, String ubicacion, String plazoEntrega, String clienteNombre, BigDecimal clienteCalificacion, Integer clienteTotalProyectos, Integer totalPropuestas) {
        this.solicitudId = solicitudId;
        this.titulo = titulo;
        this.categoriaNombre = categoriaNombre;
        this.presupuestoRango = presupuestoRango;
        this.fechaPublicacion = fechaPublicacion;
        this.urgencia = urgencia;
        this.ubicacion = ubicacion;
        this.plazoEntrega = plazoEntrega;
        this.clienteNombre = clienteNombre;
        this.clienteCalificacion = clienteCalificacion;
        this.clienteTotalProyectos = clienteTotalProyectos;
        this.totalPropuestas = totalPropuestas;
    }

    // Getters y Setters
    public Integer getSolicitudId() { return solicitudId; }
    public void setSolicitudId(Integer solicitudId) { this.solicitudId = solicitudId; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getCategoriaNombre() { return categoriaNombre; }
    public void setCategoriaNombre(String categoriaNombre) { this.categoriaNombre = categoriaNombre; }
    public String getPresupuestoRango() { return presupuestoRango; }
    public void setPresupuestoRango(String presupuestoRango) { this.presupuestoRango = presupuestoRango; }
    public String getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(String fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }
    public String getUrgencia() { return urgencia; }
    public void setUrgencia(String urgencia) { this.urgencia = urgencia; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public String getPlazoEntrega() { return plazoEntrega; }
    public void setPlazoEntrega(String plazoEntrega) { this.plazoEntrega = plazoEntrega; }
    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }
    public BigDecimal getClienteCalificacion() { return clienteCalificacion; }
    public void setClienteCalificacion(BigDecimal clienteCalificacion) { this.clienteCalificacion = clienteCalificacion; }
    public Integer getClienteTotalProyectos() { return clienteTotalProyectos; }
    public void setClienteTotalProyectos(Integer clienteTotalProyectos) { this.clienteTotalProyectos = clienteTotalProyectos; }
    public Integer getTotalPropuestas() { return totalPropuestas; }
    public void setTotalPropuestas(Integer totalPropuestas) { this.totalPropuestas = totalPropuestas; }
}