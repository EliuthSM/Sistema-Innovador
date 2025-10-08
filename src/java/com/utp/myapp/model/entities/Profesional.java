package com.utp.myapp.model.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Profesional {
    private int usuarioId;
    private String titulo;
    private String descripcionServicio;
    private int anosExperiencia;
    private String fotoPerfilUrl;
    private String telefono;
    private String ubicacion;
    private String idiomas;
    private String estado;
    private BigDecimal promedioCalificacion;
    private Timestamp ultimaConexion;
    private BigDecimal tarifaHoraMin;
    private BigDecimal tarifaHoraMax;
    // ... otros campos de tarifa

    private Profesional() {}

    public static class Builder {
        private final Profesional profesional;

        public Builder() {
            this.profesional = new Profesional();
        }

        public Builder usuarioId(int id) {
            this.profesional.usuarioId = id;
            return this;
        }

        public Builder titulo(String titulo) {
            this.profesional.titulo = titulo;
            return this;
        }

        public Builder descripcionServicio(String desc) {
            this.profesional.descripcionServicio = desc;
            return this;
        }

        public Builder anosExperiencia(int anos) {
            if (anos < 0) {
                throw new IllegalArgumentException("Los años de experiencia no pueden ser negativos.");
            }
            this.profesional.anosExperiencia = anos;
            return this;
        }

        public Builder tarifaHoraMin(BigDecimal min) {
            this.profesional.tarifaHoraMin = min;
            return this;
        }
        
        public Builder tarifaHoraMax(BigDecimal max) {
            this.profesional.tarifaHoraMax = max;
            return this;
        }
        public Builder fotoPerfilUrl(String url) {
            this.profesional.fotoPerfilUrl = url;
            return this;
        }
        public Builder telefono(String telefono) {
            this.profesional.telefono = telefono;
            return this;
        }
        public Builder ubicacion(String ubicacion) {
            this.profesional.ubicacion = ubicacion;
            return this;
        }
        public Builder idiomas(String idiomas) {
            this.profesional.idiomas = idiomas;
            return this;
        }
        public Builder estado(String estado) {
            this.profesional.estado = estado;
            return this;
        }
        public Builder promedioCalificacion(BigDecimal calificacion) {
            this.profesional.promedioCalificacion = calificacion;
            return this;
        }
        public Builder ultimaConexion(Timestamp fecha) {
            this.profesional.ultimaConexion = fecha;
            return this;
        }

        public Profesional build() {
            return this.profesional;
        }
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public String getFotoPerfilUrl() {
        return fotoPerfilUrl;
    }

    public void setFotoPerfilUrl(String fotoPerfilUrl) {
        this.fotoPerfilUrl = fotoPerfilUrl;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPromedioCalificacion() {
        return promedioCalificacion;
    }

    public void setPromedioCalificacion(BigDecimal promedioCalificacion) {
        this.promedioCalificacion = promedioCalificacion;
    }

    public Timestamp getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Timestamp ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    public BigDecimal getTarifaHoraMin() {
        return tarifaHoraMin;
    }

    public void setTarifaHoraMin(BigDecimal tarifaHoraMin) {
        this.tarifaHoraMin = tarifaHoraMin;
    }

    public BigDecimal getTarifaHoraMax() {
        return tarifaHoraMax;
    }

    public void setTarifaHoraMax(BigDecimal tarifaHoraMax) {
        this.tarifaHoraMax = tarifaHoraMax;
    }
    
    
    
}