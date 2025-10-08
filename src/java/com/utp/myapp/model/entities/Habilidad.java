package com.utp.myapp.model.entities;

public class Habilidad {
    private int habilidadId;
    private String nombre;

    private Habilidad() {}

    // Getters y Setters
    public int getHabilidadId() { return habilidadId; }
    public void setHabilidadId(int habilidadId) { this.habilidadId = habilidadId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    // Clase Builder interna
    public static class Builder {
        private final Habilidad habilidad;

        public Builder() {
            this.habilidad = new Habilidad();
        }

        public Builder habilidadId(int id) {
            this.habilidad.habilidadId = id;
            return this;
        }

        public Builder nombre(String nombre) {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre de la habilidad no puede ser vacío.");
            }
            this.habilidad.nombre = nombre;
            return this;
        }
        
        public Habilidad build() {
            return this.habilidad;
        }
    }
}