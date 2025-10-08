package com.utp.myapp.mappers;

import com.utp.myapp.dtos.PropuestaRequestDTO;
import com.utp.myapp.model.entities.Propuesta;

public class PropuestaMapper {

    public static Propuesta fromRequest(PropuestaRequestDTO request) {
        if (request == null) return null;

        return new Propuesta.Builder()
                .solicitudPublicaId(request.getSolicitudPublicaId())
                .profesionalId(request.getProfesionalId())
                .mensajePropuesta(request.getMensaje())
                .montoOfertado(request.getMontoOfertado())
                .tiempoEstimado(request.getTiempoEstimado())
                .build();
    }
    
    // Aquí iría un método toResponse si se necesitara
}