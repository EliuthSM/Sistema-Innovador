package com.utp.myapp.model.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SolicitudPublica {
    private int solicitudPublicaId;
    private int clienteId;
    private int categoriaId;
    private String titulo;
    private String descripcion;
    private BigDecimal presupuestoMin;
    private BigDecimal presupuestoMax;
    private String urgencia;
    private String ubicacion;
    private String plazoEntrega;
    private String estado;
    private Timestamp fechaPublicacion;

    private SolicitudPublica() {}
    
    public static class Builder {
        private final SolicitudPublica solicitud;
        
        public Builder() { this.solicitud = new SolicitudPublica(); }
        
        public Builder solicitudPublicaId(int id) { this.solicitud.solicitudPublicaId = id; return this; }
        public Builder clienteId(int id) { this.solicitud.clienteId = id; return this; }
        public Builder categoriaId(int id) { this.solicitud.categoriaId = id; return this; }
        public Builder titulo(String titulo) { this.solicitud.titulo = titulo; return this; }
        public Builder descripcion(String descripcion) { this.solicitud.descripcion = descripcion; return this; }
        public Builder presupuestoMin(BigDecimal min) { this.solicitud.presupuestoMin = min; return this; }
        public Builder presupuestoMax(BigDecimal max) { this.solicitud.presupuestoMax = max; return this; }
        public Builder urgencia(String urgencia) { this.solicitud.urgencia = urgencia; return this; }
        public Builder ubicacion(String ubicacion) { this.solicitud.ubicacion = ubicacion; return this; }
        public Builder plazoEntrega(String plazo) { this.solicitud.plazoEntrega = plazo; return this; }
        public Builder estado(String estado) { this.solicitud.estado = estado; return this; }
        public Builder fechaPublicacion(Timestamp fecha) { this.solicitud.fechaPublicacion = fecha; return this; }  
        
        public SolicitudPublica build() { return this.solicitud; }
    }

    public int getSolicitudPublicaId() {
        return solicitudPublicaId;
    }

    public void setSolicitudPublicaId(int solicitudPublicaId) {
        this.solicitudPublicaId = solicitudPublicaId;
    }

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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPlazoEntrega() {
        return plazoEntrega;
    }

    public void setPlazoEntrega(String plazoEntrega) {
        this.plazoEntrega = plazoEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Timestamp fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    
    
    
}