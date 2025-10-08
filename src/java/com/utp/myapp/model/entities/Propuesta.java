package com.utp.myapp.model.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Propuesta {
    private int propuestaId;
    private int solicitudPublicaId;
    private int profesionalId;
    private String mensajePropuesta;
    private BigDecimal montoOfertado;
    private String tiempoEstimado;
    private Timestamp fechaEnvio;
    private String estado;
    
    private Propuesta() {}
    
    
    public static class Builder {
        private final Propuesta propuesta;
        
        public Builder() { this.propuesta = new Propuesta(); }
        
        public Builder propuestaId(int id) { this.propuesta.propuestaId = id; return this; }
        public Builder solicitudPublicaId(int id) { this.propuesta.solicitudPublicaId = id; return this; }
        public Builder profesionalId(int id) { this.propuesta.profesionalId = id; return this; }
        public Builder montoOfertado(BigDecimal monto) {
            if (monto != null && monto.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("El monto ofertado no puede ser negativo.");
            }
            this.propuesta.montoOfertado = monto;
            return this;
        }
        public Builder mensajePropuesta(String mensaje) { this.propuesta.mensajePropuesta = mensaje; return this; }
        public Builder tiempoEstimado(String tiempo) { this.propuesta.tiempoEstimado = tiempo; return this; }
        public Builder fechaEnvio(Timestamp fecha) { this.propuesta.fechaEnvio = fecha; return this; }
        public Builder estado(String estado) { this.propuesta.estado = estado; return this; }   
        
        public Propuesta build() { return this.propuesta; }
    }

    public int getPropuestaId() {
        return propuestaId;
    }

    public void setPropuestaId(int propuestaId) {
        this.propuestaId = propuestaId;
    }

    public int getSolicitudPublicaId() {
        return solicitudPublicaId;
    }

    public void setSolicitudPublicaId(int solicitudPublicaId) {
        this.solicitudPublicaId = solicitudPublicaId;
    }

    public int getProfesionalId() {
        return profesionalId;
    }

    public void setProfesionalId(int profesionalId) {
        this.profesionalId = profesionalId;
    }

    public String getMensajePropuesta() {
        return mensajePropuesta;
    }

    public void setMensajePropuesta(String mensajePropuesta) {
        this.mensajePropuesta = mensajePropuesta;
    }

    public BigDecimal getMontoOfertado() {
        return montoOfertado;
    }

    public void setMontoOfertado(BigDecimal montoOfertado) {
        this.montoOfertado = montoOfertado;
    }

    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public Timestamp getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Timestamp fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}

