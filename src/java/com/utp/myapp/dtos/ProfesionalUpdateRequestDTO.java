package com.utp.myapp.dtos;

import java.math.BigDecimal;
import java.util.List;

public class ProfesionalUpdateRequestDTO {

    private Integer usuarioId; // ID del profesional a actualizar
    private String titulo;
    private String descripcionServicio;
    private Integer anosExperiencia;
    private String telefono;
    private String ubicacion;
    private String idiomas;

    // Tarifas
    private BigDecimal tarifaHoraMin;
    private BigDecimal tarifaHoraMax;
    // ...puedes añadir los otros campos de tarifa si permites su edición

    // IDs de las nuevas listas de categorías y habilidades
    private List<Integer> categoriaIds;
    private List<Integer> habilidadIds;

    public ProfesionalUpdateRequestDTO() {}

    // Constructor completo
    public ProfesionalUpdateRequestDTO(Integer usuarioId, String titulo, String descripcionServicio, Integer anosExperiencia, String telefono, String ubicacion, String idiomas, BigDecimal tarifaHoraMin, BigDecimal tarifaHoraMax, List<Integer> categoriaIds, List<Integer> habilidadIds) {
        this.usuarioId = usuarioId;
        this.titulo = titulo;
        this.descripcionServicio = descripcionServicio;
        this.anosExperiencia = anosExperiencia;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.idiomas = idiomas;
        this.tarifaHoraMin = tarifaHoraMin;
        this.tarifaHoraMax = tarifaHoraMax;
        this.categoriaIds = categoriaIds;
        this.habilidadIds = habilidadIds;
    }

    // Getters y Setters
    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcionServicio() { return descripcionServicio; }
    public void setDescripcionServicio(String descripcionServicio) { this.descripcionServicio = descripcionServicio; }
    public Integer getAnosExperiencia() { return anosExperiencia; }
    public void setAnosExperiencia(Integer anosExperiencia) { this.anosExperiencia = anosExperiencia; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public String getIdiomas() { return idiomas; }
    public void setIdiomas(String idiomas) { this.idiomas = idiomas; }
    public BigDecimal getTarifaHoraMin() { return tarifaHoraMin; }
    public void setTarifaHoraMin(BigDecimal tarifaHoraMin) { this.tarifaHoraMin = tarifaHoraMin; }
    public BigDecimal getTarifaHoraMax() { return tarifaHoraMax; }
    public void setTarifaHoraMax(BigDecimal tarifaHoraMax) { this.tarifaHoraMax = tarifaHoraMax; }
    public List<Integer> getCategoriaIds() { return categoriaIds; }
    public void setCategoriaIds(List<Integer> categoriaIds) { this.categoriaIds = categoriaIds; }
    public List<Integer> getHabilidadIds() { return habilidadIds; }
    public void setHabilidadIds(List<Integer> habilidadIds) { this.habilidadIds = habilidadIds; }
}