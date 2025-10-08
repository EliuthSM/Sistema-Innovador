package com.utp.myapp.dtos;

import java.math.BigDecimal;

public class SolicitudDirectaResponseDTO {
    private int solicitudId;
    private String titulo;
    private String fechaCreacion; // Ej: "Hace 2 horas"
    private String presupuestoRango; // Ej: "$3000 - $5000"
    private String urgencia;
    private String estado;
    private String clienteNombre;
    private BigDecimal clienteCalificacion;
    private int clienteTotalTrabajos;

    public SolicitudDirectaResponseDTO() {}
    
    // Constructor completo y Getters/Setters...
    public SolicitudDirectaResponseDTO(int solicitudId, String titulo, String fechaCreacion, String presupuestoRango, String urgencia, String estado, String clienteNombre, BigDecimal clienteCalificacion, int clienteTotalTrabajos) {
        this.solicitudId = solicitudId;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.presupuestoRango = presupuestoRango;
        this.urgencia = urgencia;
        this.estado = estado;
        this.clienteNombre = clienteNombre;
        this.clienteCalificacion = clienteCalificacion;
        this.clienteTotalTrabajos = clienteTotalTrabajos;
    }

    public int getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(int solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getPresupuestoRango() {
        return presupuestoRango;
    }

    public void setPresupuestoRango(String presupuestoRango) {
        this.presupuestoRango = presupuestoRango;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public BigDecimal getClienteCalificacion() {
        return clienteCalificacion;
    }

    public void setClienteCalificacion(BigDecimal clienteCalificacion) {
        this.clienteCalificacion = clienteCalificacion;
    }

    public int getClienteTotalTrabajos() {
        return clienteTotalTrabajos;
    }

    public void setClienteTotalTrabajos(int clienteTotalTrabajos) {
        this.clienteTotalTrabajos = clienteTotalTrabajos;
    }
    
    
}