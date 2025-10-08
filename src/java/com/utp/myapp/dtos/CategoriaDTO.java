package com.utp.myapp.dtos;

public class CategoriaDTO {

    private Integer categoriaId;
    private String nombre;

    public CategoriaDTO() {}

    public CategoriaDTO(Integer categoriaId, String nombre) {
        this.categoriaId = categoriaId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Integer categoriaId) { this.categoriaId = categoriaId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}