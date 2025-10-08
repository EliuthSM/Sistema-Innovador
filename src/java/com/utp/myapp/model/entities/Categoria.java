package com.utp.myapp.model.entities;

public class Categoria {
    private int categoriaId;
    private String nombre;
    private String descripcion;

    private Categoria() {}

    // Getters y Setters
    public int getCategoriaId() { return categoriaId; }
    public void setCategoriaId(int categoriaId) { this.categoriaId = categoriaId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    // Clase Builder interna
    public static class Builder {
        private final Categoria categoria;

        public Builder() {
            this.categoria = new Categoria();
        }

        public Builder categoriaId(int id) {
            this.categoria.categoriaId = id;
            return this;
        }

        public Builder nombre(String nombre) {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre de la categoría no puede ser vacío.");
            }
            this.categoria.nombre = nombre;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.categoria.descripcion = descripcion;
            return this;
        }
        
        public Categoria build() {
            return this.categoria;
        }
    }
}