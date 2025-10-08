package com.utp.myapp.model.services;

import com.utp.myapp.dtos.PropuestaRequestDTO;
import com.utp.myapp.dtos.PropuestaResponseDTO;
import com.utp.myapp.mappers.PropuestaMapper;
import com.utp.myapp.model.dao.PropuestaDAO;
import com.utp.myapp.model.dao.SolicitudPublicaDAO;
import com.utp.myapp.model.entities.Propuesta;
import java.util.List;
import java.util.stream.Collectors;

public class PropuestaService {
    
    private final PropuestaDAO propuestaDAO = new PropuestaDAO();
    private final SolicitudPublicaDAO solicitudPublicaDAO = new SolicitudPublicaDAO();

    public void enviarPropuesta(PropuestaRequestDTO request) {
        Propuesta nuevaPropuesta = PropuestaMapper.fromRequest(request);
        propuestaDAO.insert(nuevaPropuesta);
    }

    public List<PropuestaResponseDTO> listarPropuestasPorSolicitud(int solicitudId) {
        return null;/*propuestaDAO.listBySolicitudId(solicitudId).stream()
                .map(PropuestaMapper::toResponse)
                .collect(Collectors.toList());*/
    }

    public boolean aceptarPropuesta(int propuestaId) {
        // --- INICIO DE TRANSACCIÓN ---
        Propuesta propuesta = propuestaDAO.listById(propuestaId);
        if (propuesta != null) {
            // 1. Actualizar estado de la propuesta
            propuesta.setEstado("Aceptada");
            propuestaDAO.update(propuesta);
            
            // 2. Actualizar estado de la solicitud pública
            solicitudPublicaDAO.updateEstado(propuesta.getSolicitudPublicaId(), "En Proceso");
            return true;
        }
        // --- FIN DE TRANSACCIÓN ---
        return false;
    }
}