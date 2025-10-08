package com.utp.myapp.model.entities;

import java.sql.Timestamp;

public class Calificacion {
    private int calificacionId;
    private int profesionalId;
    private int clienteId;
    private int solicitudId; // Puede ser de SolicitudDirecta o SolicitudPublica
    private int puntuacion;
    private String comentario;
    private Timestamp fechaCalificacion;

    private Calificacion() {}

    
    public static class Builder {
        private final Calificacion calificacion;
        
        public Builder() { this.calificacion = new Calificacion(); }
        
        public Builder calificacionId(int id) { this.calificacion.calificacionId = id; return this; }
        public Builder profesionalId(int id) { this.calificacion.profesionalId = id; return this; }
        public Builder clienteId(int id) { this.calificacion.clienteId = id; return this; }
        public Builder solicitudId(int id) { this.calificacion.solicitudId = id; return this; }
        public Builder puntuacion(int puntos) {
            if (puntos < 1 || puntos > 5) {
                throw new IllegalArgumentException("La puntuación debe estar entre 1 y 5.");
            }
            this.calificacion.puntuacion = puntos;
            return this;
        }
        public Builder comentario(String comentario) { this.calificacion.comentario = comentario; return this; }
        public Builder fechaCalificacion(Timestamp fecha) { this.calificacion.fechaCalificacion = fecha; return this; }
        
        public Calificacion build() { return this.calificacion; }
    }

    public int getCalificacionId() {
        return calificacionId;
    }

    public void setCalificacionId(int calificacionId) {
        this.calificacionId = calificacionId;
    }

    public int getProfesionalId() {
        return profesionalId;
    }

    public void setProfesionalId(int profesionalId) {
        this.profesionalId = profesionalId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(int solicitudId) {
        this.solicitudId = solicitudId;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Timestamp getFechaCalificacion() {
        return fechaCalificacion;
    }

    public void setFechaCalificacion(Timestamp fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }
    
    
    
}
