package com.utp.myapp.mappers;

import com.utp.myapp.dtos.SolicitudPublicaRequestDTO;
import com.utp.myapp.dtos.SolicitudPublicaResponseDTO;
import com.utp.myapp.model.entities.SolicitudPublica;
// Importar también lo relacionado a SolicitudDirecta

public class SolicitudMapper {

    // --- Solicitud Pública ---

    public static SolicitudPublica fromPublicaRequest(SolicitudPublicaRequestDTO request) {
        if (request == null) return null;

        return new SolicitudPublica.Builder()
                .clienteId(request.getClienteId())
                .categoriaId(request.getCategoriaId())
                .titulo(request.getTitulo())
                .descripcion(request.getDescripcion())
                .presupuestoMin(request.getPresupuestoMin())
                .presupuestoMax(request.getPresupuestoMax())
                .urgencia(request.getUrgencia())
                .plazoEntrega(request.getPlazoEntrega())
                .build();
    }
    
    public static SolicitudPublicaResponseDTO toPublicaResponse(SolicitudPublica sp) {
        if (sp == null) return null;

        // Lógica para formatear los datos para la vista
        String rangoPresupuesto = "S/" + sp.getPresupuestoMin() + " - S/" + sp.getPresupuestoMax();
        
        SolicitudPublicaResponseDTO dto = new SolicitudPublicaResponseDTO();
        dto.setSolicitudId(sp.getSolicitudPublicaId());
        dto.setTitulo(sp.getTitulo());
        dto.setPresupuestoRango(rangoPresupuesto);
        dto.setUrgencia(sp.getUrgencia());
        dto.setPlazoEntrega(sp.getPlazoEntrega());
        // Aquí se necesitarían JOINS en la consulta DAO para obtener nombres de categoría, cliente, etc.
        // dto.setCategoriaNombre("Tecnología"); 
        // dto.setClienteNombre("Nombre Cliente");
        return dto;
    }

    // --- Aquí irían los mappers para SolicitudDirecta (fromDirectaRequest y toDirectaResponse) ---
}