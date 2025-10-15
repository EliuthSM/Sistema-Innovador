package com.utp.myapp.model.dao;

import com.utp.myapp.model.connection.ConnectionDataBase;
import com.utp.myapp.model.entities.Profesional;
import com.utp.myapp.model.repositories.ICRUD;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfesionalDAO implements ICRUD<Profesional> {
    
    private PreparedStatement pstm;
    private ResultSet res;
    private final ConnectionDataBase con;

    public ProfesionalDAO() {
        this.con = ConnectionDataBase.getInstance();
    }
    
    private void close() {
        try {
            if (res != null) res.close();
            if (pstm != null) pstm.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar recursos en ProfesionalDAO: " + e.getMessage());
        }
    }

    /**
     * Inserta un nuevo perfil de Profesional en la base de datos con todos los campos.
     * @param profesional El objeto Profesional a insertar.
     * @return true si la inserción fue exitosa.
     */
    @Override
    public Boolean insert(Profesional profesional) {
        final String SQL_INSERT = "INSERT INTO Profesionales (Usuario_ID, Titulo, Descripcion_Servicio, Anos_Experiencia, Ubicacion, Idiomas, Tarifa_Hora_Min, Tarifa_Hora_Max) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pstm = con.getConnection().prepareStatement(SQL_INSERT);
            
            pstm.setInt(1, profesional.getUsuarioId());
            pstm.setString(2, profesional.getTitulo());
            pstm.setString(3, profesional.getDescripcionServicio());
            pstm.setInt(4, profesional.getAnosExperiencia());
            pstm.setString(5, profesional.getUbicacion());
            
            // Campos adicionales
            pstm.setString(6, profesional.getIdiomas());
            pstm.setBigDecimal(7, profesional.getTarifaHoraMin());
            pstm.setBigDecimal(8, profesional.getTarifaHoraMax());
            
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al insertar profesional: " + e.getMessage());
            return false;
        } finally {
            close();
        }
    }

    /**
     * Actualiza la información básica del perfil del profesional.
     */
    @Override
    public Boolean update(Profesional profesional) {
        final String SQL_UPDATE = "UPDATE Profesionales SET Titulo = ?, Descripcion_Servicio = ?, Anos_Experiencia = ?, Ubicacion = ?, Idiomas = ?, Tarifa_Hora_Min = ?, Tarifa_Hora_Max = ? WHERE Usuario_ID = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_UPDATE);
            pstm.setString(1, profesional.getTitulo());
            pstm.setString(2, profesional.getDescripcionServicio());
            pstm.setInt(3, profesional.getAnosExperiencia());
            pstm.setString(4, profesional.getUbicacion());
            pstm.setString(5, profesional.getIdiomas());
            pstm.setBigDecimal(6, profesional.getTarifaHoraMin());
            pstm.setBigDecimal(7, profesional.getTarifaHoraMax());
            pstm.setInt(8, profesional.getUsuarioId()); // Condición WHERE
            
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar profesional: " + e.getMessage());
            return false;
        } finally {
            close();
        }
    }
    
    /**
     * Actualiza únicamente el promedio de calificación.
     */
    public boolean updatePromedioCalificacion(int profesionalId, BigDecimal nuevoPromedio) {
        final String SQL_UPDATE_PROMEDIO = "UPDATE Profesionales SET Promedio_Calificacion = ? WHERE Usuario_ID = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_UPDATE_PROMEDIO);
            pstm.setBigDecimal(1, nuevoPromedio);
            pstm.setInt(2, profesionalId);
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar promedio: " + e.getMessage());
            return false;
        } finally {
            close();
        }
    }

    @Override
    public Profesional listById(Integer id) {
        // Implementar lógica para buscar un profesional por su Usuario_ID
        // Debería incluir la consulta para mapear todos los campos
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Método no implementado para ProfesionalDAO.");
    }

    @Override
    public List<Profesional> list() {
        return new ArrayList<>();
    }
}
