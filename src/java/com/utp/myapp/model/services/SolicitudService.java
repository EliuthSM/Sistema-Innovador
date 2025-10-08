package com.utp.myapp.model.services;

import com.utp.myapp.dtos.SolicitudDirectaRequestDTO;
import com.utp.myapp.dtos.SolicitudDirectaResponseDTO;
import com.utp.myapp.dtos.SolicitudPublicaRequestDTO;
import com.utp.myapp.dtos.SolicitudPublicaResponseDTO;
import com.utp.myapp.mappers.SolicitudMapper;
import com.utp.myapp.model.dao.SolicitudDirectaDAO;
import com.utp.myapp.model.dao.SolicitudPublicaDAO;
import com.utp.myapp.model.entities.SolicitudDirecta;
import com.utp.myapp.model.entities.SolicitudPublica;
import java.util.List;
import java.util.stream.Collectors;

public class SolicitudService {
    
    private final SolicitudPublicaDAO solicitudPublicaDAO = new SolicitudPublicaDAO();
    private final SolicitudDirectaDAO solicitudDirectaDAO = new SolicitudDirectaDAO();

    public SolicitudPublicaResponseDTO crearSolicitudPublica(SolicitudPublicaRequestDTO request) {
        SolicitudPublica nuevaSolicitud = SolicitudMapper.fromPublicaRequest(request);
        solicitudPublicaDAO.insert(nuevaSolicitud);
        // Se podría retornar el objeto creado con su ID
        return null; //new SolicitudPublicaResponseDTO(); // Simplificado
    }

    public List<SolicitudPublicaResponseDTO> listarSolicitudesPublicasActivas() {
        return solicitudPublicaDAO.list().stream()
                .map(SolicitudMapper::toPublicaResponse)
                .collect(Collectors.toList());
    }

    public List<SolicitudDirectaResponseDTO> listarSolicitudesDirectasRecibidas(int profesionalId) {
        return null; /*solicitudDirectaDAO.findByProfesionalId(profesionalId).stream()
                .map(SolicitudMapper::toDirectaResponse)
                .collect(Collectors.toList());*/
    }

    public boolean actualizarEstadoSolicitudDirecta(int solicitudId, String nuevoEstado) {
        SolicitudDirecta solicitud = null; // solicitudDirectaDAO.findById(solicitudId);
        /*
        if (solicitud != null) {
            solicitud.setEstado(nuevoEstado);
            return solicitudDirectaDAO.update(solicitud);
        }*/
        return false;
    }
}