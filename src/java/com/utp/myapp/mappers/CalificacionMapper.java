package com.utp.myapp.mappers;

import com.utp.myapp.dtos.CalificacionRequestDTO;
import com.utp.myapp.model.entities.Calificacion;

public class CalificacionMapper {

    public static Calificacion fromRequest(CalificacionRequestDTO request) {
        if (request == null) return null;

        return new Calificacion.Builder()
                .profesionalId(request.getProfesionalId())
                .clienteId(request.getClienteId())
                .solicitudId(request.getSolicitudId())
                .puntuacion(request.getPuntuacion())
                .comentario(request.getComentario())
                .build();
    }
}