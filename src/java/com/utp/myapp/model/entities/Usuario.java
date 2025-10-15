package com.utp.myapp.model.entities;

import java.sql.Timestamp;

public class Usuario {

    private int usuarioId;
    private String nombreCompleto;
    private String correoElectronico;
    private String contrasenaHash;
    private String rol; // "Cliente" o "Profesional"
    private Timestamp fechaRegistro;

    // Constructor privado para ser usado solo por el Builder
    private Usuario() {
    }

    // Getters y Setters
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    // Clase Builder interna
    public static class Builder {

        private final Usuario usuario;

        public Builder() {
            this.usuario = new Usuario();
        }

        public Builder usuarioId(int id) {
            this.usuario.usuarioId = id;
            return this;
        }

        public Builder nombreCompleto(String nombre) {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede ser vacío.");
            }
            this.usuario.nombreCompleto = nombre;
            return this;
        }

        public Builder correoElectronico(String correo) {
            if (correo == null || !correo.contains("@")) {
                throw new IllegalArgumentException("El formato del correo es inválido.");
            }
            this.usuario.correoElectronico = correo;
            return this;
        }

        public Builder contrasenaHash(String hash) {
            if (hash == null || hash.trim().isEmpty()) {
                throw new IllegalArgumentException("La contraseña no puede ser vacía.");
            }
            this.usuario.contrasenaHash = hash;
            return this;
        }

        public Builder rol(String rol) {
            if (!"Cliente".equals(rol) && !"Profesional".equals(rol)) {
                throw new IllegalArgumentException("El rol debe ser 'Cliente' o 'Profesional'.");
            }
            this.usuario.rol = rol;
            return this;
        }

        public Builder fechaRegistro(Timestamp fecha) {
            this.usuario.fechaRegistro = fecha;
            return this;
        }

        public Usuario build() {
            return this.usuario;
        }
    }
}
