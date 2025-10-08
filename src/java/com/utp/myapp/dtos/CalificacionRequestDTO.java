package com.utp.myapp.dtos;

public class CalificacionRequestDTO {
    private int profesionalId;
    private int clienteId;
    private int solicitudId;
    private int puntuacion;
    private String comentario;

    public CalificacionRequestDTO() {}

    // Constructor completo y Getters/Setters...
    public CalificacionRequestDTO(int profesionalId, int clienteId, int solicitudId, int puntuacion, String comentario) {
        this.profesionalId = profesionalId;
        this.clienteId = clienteId;
        this.solicitudId = solicitudId;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }
    
    public int getProfesionalId() { return profesionalId; }
    public void setProfesionalId(int profesionalId) { this.profesionalId = profesionalId; }
    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }
    public int getSolicitudId() { return solicitudId; }
    public void setSolicitudId(int solicitudId) { this.solicitudId = solicitudId; }
    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}