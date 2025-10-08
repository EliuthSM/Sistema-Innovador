package com.utp.myapp.model.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SolicitudDirecta {
    private int solicitudId;
    private int clienteId;
    private int profesionalId;
    private String titulo;
    private String descripcionProblema;
    private BigDecimal presupuestoMin;
    private BigDecimal presupuestoMax;
    private String urgencia;
    private String estado;
    private Timestamp fechaCreacion;
    private Timestamp fechaActualizacion;

    // Constructor privado para forzar el uso del Builder
    private SolicitudDirecta() {}

   
    // Clase Builder interna
    public static class Builder {
        private final SolicitudDirecta solicitud;

        public Builder() {
            this.solicitud = new SolicitudDirecta();
        }

        public Builder solicitudId(int id) {
            this.solicitud.solicitudId = id;
            return this;
        }

        public Builder clienteId(int id) {
            this.solicitud.clienteId = id;
            return this;
        }

        public Builder profesionalId(int id) {
            this.solicitud.profesionalId = id;
            return this;
        }

        public Builder titulo(String titulo) {
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new IllegalArgumentException("El título no puede ser vacío.");
            }
            this.solicitud.titulo = titulo;
            return this;
        }

        public Builder descripcionProblema(String descripcion) {
            this.solicitud.descripcionProblema = descripcion;
            return this;
        }

        public Builder presupuestoMin(BigDecimal min) {
            this.solicitud.presupuestoMin = min;
            return this;
        }

        public Builder presupuestoMax(BigDecimal max) {
            this.solicitud.presupuestoMax = max;
            return this;
        }

        public Builder urgencia(String urgencia) {
            this.solicitud.urgencia = urgencia;
            return this;
        }

        public Builder estado(String estado) {
            this.solicitud.estado = estado;
            return this;
        }

        public Builder fechaCreacion(Timestamp fecha) {
            this.solicitud.fechaCreacion = fecha;
            return this;
        }

        public Builder fechaActualizacion(Timestamp fecha) {
            this.solicitud.fechaActualizacion = fecha;
            return this;
        }
        
        public SolicitudDirecta build() {
            return this.solicitud;
        }
    }

    public int getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(int solicitudId) {
        this.solicitudId = solicitudId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getProfesionalId() {
        return profesionalId;
    }

    public void setProfesionalId(int profesionalId) {
        this.profesionalId = profesionalId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Timestamp fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    
    
}