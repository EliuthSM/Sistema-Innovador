package com.utp.myapp.mappers;

import com.utp.myapp.dtos.ProfesionalCardResponseDTO;
import com.utp.myapp.dtos.ProfesionalDetailResponseDTO;
import com.utp.myapp.dtos.RegistroProfesionalRequestDTO;
import com.utp.myapp.model.entities.Profesional;
import com.utp.myapp.model.entities.Usuario;
import java.util.Collections;

public class ProfesionalMapper {
    
    // --- De DTO Request a Entidad ---

    public static Profesional fromProfesionalRequest(RegistroProfesionalRequestDTO request) {
        if (request == null) return null;
        
        return new Profesional.Builder()
                .titulo(request.getTitulo())
                .descripcionServicio(request.getDescripcionServicios())
                .anosExperiencia(request.getAnosExperiencia())
                .ubicacion(request.getUbicacion())
                // Los demás campos como tarifas se pueden setear después
                .build();
    }
    
    // --- De Entidad a DTO Response ---

    public static ProfesionalCardResponseDTO toCardResponse(Profesional profesional, Usuario usuario) {
        if (profesional == null || usuario == null) return null;
        
        String tarifa = (profesional.getTarifaHoraMin() != null) 
                        ? "Desde S/" + profesional.getTarifaHoraMin() + "/hr" 
                        : "Consultar";

        return new ProfesionalCardResponseDTO(
            profesional.getUsuarioId(),
            usuario.getNombreCompleto(),
            profesional.getTitulo(),
            profesional.getFotoPerfilUrl(), // Asumiendo que existe
            profesional.getPromedioCalificacion(),
            0, // totalCalificaciones (necesitaría una consulta extra)
            tarifa,
            Collections.emptyList() // habilidades (necesitaría una consulta extra)
        );
    }

    public static ProfesionalDetailResponseDTO toDetailResponse(Profesional profesional, Usuario usuario) {
        if (profesional == null || usuario == null) return null;

        // Aquí se crearían y llenarían todos los campos del DTO detallado,
        // combinando la información de la entidad Profesional y Usuario.
        // Por brevedad, se muestra la instanciación.
        ProfesionalDetailResponseDTO dto = new ProfesionalDetailResponseDTO();
        dto.setUsuarioId(profesional.getUsuarioId());
        dto.setNombreCompleto(usuario.getNombreCompleto());
        dto.setTitulo(profesional.getTitulo());
        dto.setDescripcionServicio(profesional.getDescripcionServicio());
        dto.setAnosExperiencia(profesional.getAnosExperiencia());
        dto.setUbicacion(profesional.getUbicacion());
        dto.setIdiomas(profesional.getIdiomas());
        dto.setPromedioCalificacion(profesional.getPromedioCalificacion());
        dto.setTarifaHoraMin(profesional.getTarifaHoraMin());
        dto.setTarifaHoraMax(profesional.getTarifaHoraMax());
        
        
        return dto;
    }
}