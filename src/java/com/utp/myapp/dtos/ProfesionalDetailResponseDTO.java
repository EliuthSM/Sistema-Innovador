package com.utp.myapp.dtos;

import java.math.BigDecimal;
import java.util.List;

public class ProfesionalDetailResponseDTO {

    // Información básica
    private Integer usuarioId;
    private String nombreCompleto;
    private String titulo;
    private String fotoPerfilUrl;
    private BigDecimal promedioCalificacion;
    private Integer totalCalificaciones;

    // Detalles del perfil
    private String descripcionServicio;
    private Integer anosExperiencia;
    private String ubicacion;
    private String miembroDesde; // Ej: "Enero 2020"
    private String idiomas;
    private List<String> habilidades;
    private List<String> categorias;

    // Tarifas
    private BigDecimal tarifaHoraMin;
    private BigDecimal tarifaHoraMax;
    private BigDecimal tarifaProyectoPequenoMin;
    private BigDecimal tarifaProyectoPequenoMax;
    private BigDecimal tarifaProyectoMedianoMin;
    private BigDecimal tarifaProyectoMedianoMax;

    public ProfesionalDetailResponseDTO() {}

    // Constructor completo
    public ProfesionalDetailResponseDTO(Integer usuarioId, String nombreCompleto, String titulo, String fotoPerfilUrl, BigDecimal promedioCalificacion, Integer totalCalificaciones, String descripcionServicio, Integer anosExperiencia, String ubicacion, String miembroDesde, String idiomas, List<String> habilidades, List<String> categorias, BigDecimal tarifaHoraMin, BigDecimal tarifaHoraMax, BigDecimal tarifaProyectoPequenoMin, BigDecimal tarifaProyectoPequenoMax, BigDecimal tarifaProyectoMedianoMin, BigDecimal tarifaProyectoMedianoMax) {
        this.usuarioId = usuarioId;
        this.nombreCompleto = nombreCompleto;
        this.titulo = titulo;
        this.fotoPerfilUrl = fotoPerfilUrl;
        this.promedioCalificacion = promedioCalificacion;
        this.totalCalificaciones = totalCalificaciones;
        this.descripcionServicio = descripcionServicio;
        this.anosExperiencia = anosExperiencia;
        this.ubicacion = ubicacion;
        this.miembroDesde = miembroDesde;
        this.idiomas = idiomas;
        this.habilidades = habilidades;
        this.categorias = categorias;
        this.tarifaHoraMin = tarifaHoraMin;
        this.tarifaHoraMax = tarifaHoraMax;
        this.tarifaProyectoPequenoMin = tarifaProyectoPequenoMin;
        this.tarifaProyectoPequenoMax = tarifaProyectoPequenoMax;
        this.tarifaProyectoMedianoMin = tarifaProyectoMedianoMin;
        this.tarifaProyectoMedianoMax = tarifaProyectoMedianoMax;
    }

    // Getters y Setters para todos los campos

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getFotoPerfilUrl() { return fotoPerfilUrl; }
    public void setFotoPerfilUrl(String fotoPerfilUrl) { this.fotoPerfilUrl = fotoPerfilUrl; }
    public BigDecimal getPromedioCalificacion() { return promedioCalificacion; }
    public void setPromedioCalificacion(BigDecimal promedioCalificacion) { this.promedioCalificacion = promedioCalificacion; }
    public Integer getTotalCalificaciones() { return totalCalificaciones; }
    public void setTotalCalificaciones(Integer totalCalificaciones) { this.totalCalificaciones = totalCalificaciones; }
    public String getDescripcionServicio() { return descripcionServicio; }
    public void setDescripcionServicio(String descripcionServicio) { this.descripcionServicio = descripcionServicio; }
    public Integer getAnosExperiencia() { return anosExperiencia; }
    public void setAnosExperiencia(Integer anosExperiencia) { this.anosExperiencia = anosExperiencia; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public String getMiembroDesde() { return miembroDesde; }
    public void setMiembroDesde(String miembroDesde) { this.miembroDesde = miembroDesde; }
    public String getIdiomas() { return idiomas; }
    public void setIdiomas(String idiomas) { this.idiomas = idiomas; }
    public List<String> getHabilidades() { return habilidades; }
    public void setHabilidades(List<String> habilidades) { this.habilidades = habilidades; }
    public List<String> getCategorias() { return categorias; }
    public void setCategorias(List<String> categorias) { this.categorias = categorias; }
    public BigDecimal getTarifaHoraMin() { return tarifaHoraMin; }
    public void setTarifaHoraMin(BigDecimal tarifaHoraMin) { this.tarifaHoraMin = tarifaHoraMin; }
    public BigDecimal getTarifaHoraMax() { return tarifaHoraMax; }
    public void setTarifaHoraMax(BigDecimal tarifaHoraMax) { this.tarifaHoraMax = tarifaHoraMax; }
    public BigDecimal getTarifaProyectoPequenoMin() { return tarifaProyectoPequenoMin; }
    public void setTarifaProyectoPequenoMin(BigDecimal tarifaProyectoPequenoMin) { this.tarifaProyectoPequenoMin = tarifaProyectoPequenoMin; }
    public BigDecimal getTarifaProyectoPequenoMax() { return tarifaProyectoPequenoMax; }
    public void setTarifaProyectoPequenoMax(BigDecimal tarifaProyectoPequenoMax) { this.tarifaProyectoPequenoMax = tarifaProyectoPequenoMax; }
    public BigDecimal getTarifaProyectoMedianoMin() { return tarifaProyectoMedianoMin; }
    public void setTarifaProyectoMedianoMin(BigDecimal tarifaProyectoMedianoMin) { this.tarifaProyectoMedianoMin = tarifaProyectoMedianoMin; }
    public BigDecimal getTarifaProyectoMedianoMax() { return tarifaProyectoMedianoMax; }
    public void setTarifaProyectoMedianoMax(BigDecimal tarifaProyectoMedianoMax) { this.tarifaProyectoMedianoMax = tarifaProyectoMedianoMax; }
}