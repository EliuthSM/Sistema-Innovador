package com.utp.myapp.dtos;

public class HabilidadDTO {

    private Integer habilidadId;
    private String nombre;

    public HabilidadDTO() {}

    public HabilidadDTO(Integer habilidadId, String nombre) {
        this.habilidadId = habilidadId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getHabilidadId() { return habilidadId; }
    public void setHabilidadId(Integer habilidadId) { this.habilidadId = habilidadId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}