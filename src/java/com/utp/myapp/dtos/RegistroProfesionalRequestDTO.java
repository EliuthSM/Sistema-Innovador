package com.utp.myapp.dtos;

import java.util.List;

public class RegistroProfesionalRequestDTO {

    // Datos de Usuario
    private String nombreCompleto;
    private String correo;
    private String contrasena;
    private String telefono;
    private String rol;

    // Datos de Profesional
    private String ubicacion;
    private String titulo;
    private int anosExperiencia;
    private String descripcionServicios;
    private int categoriaPrincipalId;
    private List<Integer> habilidadesIds;

    public RegistroProfesionalRequestDTO() {
    }

    // Constructor completo
    public RegistroProfesionalRequestDTO(String nombreCompleto, String correo, String contrasena, String telefono, String rol, String ubicacion, String titulo, int anosExperiencia, String descripcionServicios, int categoriaPrincipalId, List<Integer> habilidadesIds) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.rol = rol;
        this.ubicacion = ubicacion;
        this.titulo = titulo;
        this.anosExperiencia = anosExperiencia;
        this.descripcionServicios = descripcionServicios;
        this.categoriaPrincipalId = categoriaPrincipalId;
        this.habilidadesIds = habilidadesIds;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public String getDescripcionServicios() {
        return descripcionServicios;
    }

    public void setDescripcionServicios(String descripcionServicios) {
        this.descripcionServicios = descripcionServicios;
    }

    public int getCategoriaPrincipalId() {
        return categoriaPrincipalId;
    }

    public void setCategoriaPrincipalId(int categoriaPrincipalId) {
        this.categoriaPrincipalId = categoriaPrincipalId;
    }

    public List<Integer> getHabilidadesIds() {
        return habilidadesIds;
    }

    public void setHabilidadesIds(List<Integer> habilidadesIds) {
        this.habilidadesIds = habilidadesIds;
    }

}
