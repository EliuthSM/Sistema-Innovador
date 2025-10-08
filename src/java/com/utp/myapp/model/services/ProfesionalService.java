package com.utp.myapp.model.services;

import com.utp.myapp.dtos.ProfesionalCardResponseDTO;
import com.utp.myapp.dtos.ProfesionalDetailResponseDTO;
import com.utp.myapp.dtos.ProfesionalUpdateRequestDTO;
import com.utp.myapp.mappers.ProfesionalMapper;
import com.utp.myapp.model.dao.ProfesionalDAO;
import com.utp.myapp.model.dao.UsuarioDAO;
import com.utp.myapp.model.entities.Profesional;
import com.utp.myapp.model.entities.Usuario;
import java.util.List;
import java.util.stream.Collectors;


public class ProfesionalService {

    private final ProfesionalDAO profesionalDAO = new ProfesionalDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public List<ProfesionalCardResponseDTO> buscarProfesionales(/* FiltrosBusquedaDTO filtros */) {
        // El DAO se encargaría de la consulta compleja con filtros
        List<Profesional> profesionales = profesionalDAO.list();//findAllWithDetails(); // Método de ejemplo

        // Mapear la lista de entidades a una lista de DTOs
        return null;/*profesionales.stream()
                .map(ProfesionalMapper::toCardResponse)
                .collect(Collectors.toList());*/
    }
    

    public ProfesionalDetailResponseDTO obtenerPerfilDetallado(int profesionalId) {
        Profesional profesional = profesionalDAO.listById(profesionalId);
        if (profesional == null) {
            return null;
            
        }
        Usuario usuario = usuarioDAO.listById(profesional.getUsuarioId());
        // Aquí también se buscarían las listas de categorías y habilidades del profesional
        
        return ProfesionalMapper.toDetailResponse(profesional, usuario /*, categorias, habilidades */);
    }

    public ProfesionalDetailResponseDTO actualizarPerfil(ProfesionalUpdateRequestDTO request) {
        Profesional profesional = profesionalDAO.listById(request.getUsuarioId());
        if (profesional != null) {
            // Actualizar los campos del objeto 'profesional' con los datos del 'request'
            profesional.setTitulo(request.getTitulo());
            profesional.setDescripcionServicio(request.getDescripcionServicio());
            // ... otros campos
            
            profesionalDAO.update(profesional);
            
            // Retornar el perfil actualizado
            return obtenerPerfilDetallado(request.getUsuarioId());
        }
        return null;
    }
}