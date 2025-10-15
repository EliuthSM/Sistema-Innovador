package com.utp.myapp.mappers;

import com.utp.myapp.dtos.ProfesionalCardResponseDTO;
import com.utp.myapp.dtos.ProfesionalDetailResponseDTO;
import com.utp.myapp.dtos.RegistroProfesionalRequestDTO;
import com.utp.myapp.model.entities.Profesional;
import com.utp.myapp.model.entities.Usuario;
import java.util.Collections;

public class ProfesionalMapper {
    
    // --- De DTO Request a Entidad ---

    /**
     * Convierte RegistroProfesionalRequestDTO a una entidad Profesional.
     * Este método se usa en el service *después* de obtener el ID del Usuario.
     */
    public static Profesional fromProfesionalRequest(RegistroProfesionalRequestDTO request, int usuarioId) {
        if (request == null) return null;
        
        return new Profesional.Builder()
                // El ID del usuario recién insertado se vincula aquí.
                .usuarioId(usuarioId)
                
                .titulo(request.getTitulo())
                .descripcionServicio(request.getDescripcionServicios()) // Corregido el nombre del campo
                .anosExperiencia(request.getAnosExperiencia())
                .ubicacion(request.getUbicacion())
                // Los demás campos como tarifas, foto, etc., se pueden setear después
                .build();
    }
    
    // NOTA: Se mantiene la versión original que usaste como base, pero no se usará en el registro.
    public static Profesional fromProfesionalRequest(RegistroProfesionalRequestDTO request) {
        return fromProfesionalRequest(request, 0); // Llama a la versión con ID 0 (no válido)
    }

    // --- De Entidad a DTO Response (Mantenido sin cambios) ---

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
