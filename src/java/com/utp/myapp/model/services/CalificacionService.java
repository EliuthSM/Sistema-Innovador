package com.utp.myapp.model.services;

import com.utp.myapp.dtos.CalificacionRequestDTO;
import com.utp.myapp.mappers.CalificacionMapper;
import com.utp.myapp.model.dao.CalificacionDAO;
import com.utp.myapp.model.dao.ProfesionalDAO;
import com.utp.myapp.model.entities.Calificacion;
import java.math.BigDecimal;

public class CalificacionService {
    
    private final CalificacionDAO calificacionDAO = new CalificacionDAO();
    private final ProfesionalDAO profesionalDAO = new ProfesionalDAO();

    public void registrarCalificacion(CalificacionRequestDTO request) {
        // --- INICIO DE TRANSACCIÓN ---
        
        // 1. Guardar la nueva calificación
        Calificacion nuevaCalificacion = CalificacionMapper.fromRequest(request);
        calificacionDAO.insert(nuevaCalificacion);
        
        // 2. Recalcular el promedio de calificación del profesional
        int profesionalId = request.getProfesionalId();
        BigDecimal nuevoPromedio = calificacionDAO.calcularPromedioParaProfesional(profesionalId);
        
        // 3. Actualizar el perfil del profesional con el nuevo promedio
        profesionalDAO.updatePromedioCalificacion(profesionalId, nuevoPromedio);
        
        // --- FIN DE TRANSACCIÓN ---
    }
}