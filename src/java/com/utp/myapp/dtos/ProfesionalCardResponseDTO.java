package com.utp.myapp.dtos;

import java.math.BigDecimal;
import java.util.List;

public class ProfesionalCardResponseDTO {
    private int usuarioId;
    private String nombreCompleto;
    private String titulo;
    private String fotoPerfilUrl;
    private BigDecimal promedioCalificacion;
    private int totalCalificaciones;
    private String tarifaDesde; // Ej: "Desde $50/hr"
    private List<String> habilidadesPrincipales;

    public ProfesionalCardResponseDTO() {}

    // Constructor completo...
    public ProfesionalCardResponseDTO(int usuarioId, String nombreCompleto, String titulo, String fotoPerfilUrl, BigDecimal promedioCalificacion, int totalCalificaciones, String tarifaDesde, List<String> habilidadesPrincipales) {
        this.usuarioId = usuarioId;
        this.nombreCompleto = nombreCompleto;
        this.titulo = titulo;
        this.fotoPerfilUrl = fotoPerfilUrl;
        this.promedioCalificacion = promedioCalificacion;
        this.totalCalificaciones = totalCalificaciones;
        this.tarifaDesde = tarifaDesde;
        this.habilidadesPrincipales = habilidadesPrincipales;
    }

    // Getters y Setters para todos los campos...

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFotoPerfilUrl() {
        return fotoPerfilUrl;
    }

    public void setFotoPerfilUrl(String fotoPerfilUrl) {
        this.fotoPerfilUrl = fotoPerfilUrl;
    }

    public BigDecimal getPromedioCalificacion() {
        return promedioCalificacion;
    }

    public void setPromedioCalificacion(BigDecimal promedioCalificacion) {
        this.promedioCalificacion = promedioCalificacion;
    }

    public int getTotalCalificaciones() {
        return totalCalificaciones;
    }

    public void setTotalCalificaciones(int totalCalificaciones) {
        this.totalCalificaciones = totalCalificaciones;
    }

    public String getTarifaDesde() {
        return tarifaDesde;
    }

    public void setTarifaDesde(String tarifaDesde) {
        this.tarifaDesde = tarifaDesde;
    }

    public List<String> getHabilidadesPrincipales() {
        return habilidadesPrincipales;
    }

    public void setHabilidadesPrincipales(List<String> habilidadesPrincipales) {
        this.habilidadesPrincipales = habilidadesPrincipales;
    }
    
}