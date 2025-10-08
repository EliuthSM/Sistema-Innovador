package com.utp.myapp.model.dao;

import com.utp.myapp.model.connection.ConnectionDataBase;
import com.utp.myapp.model.entities.SolicitudDirecta;
import com.utp.myapp.model.repositories.ICRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SolicitudDirectaDAO implements ICRUD<SolicitudDirecta> {

    private PreparedStatement pstm;
    private ResultSet res;
    private final ConnectionDataBase con;
    
    public SolicitudDirectaDAO() { this.con = ConnectionDataBase.getInstance(); }
    private void close() { /* ... */ }

    @Override
    public Boolean insert(SolicitudDirecta sd) {
        final String SQL_INSERT = "INSERT INTO Solicitudes_Directas (Cliente_ID, Profesional_ID, Titulo, Descripcion_Problema, Presupuesto_Min, Presupuesto_Max, Urgencia) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            pstm = con.getConnection().prepareStatement(SQL_INSERT);
            pstm.setInt(1, sd.getClienteId());
            pstm.setInt(2, sd.getProfesionalId());
            pstm.setString(3, sd.getTitulo());
            pstm.setString(4, sd.getDescripcionProblema());
            pstm.setBigDecimal(5, sd.getPresupuestoMin());
            pstm.setBigDecimal(6, sd.getPresupuestoMax());
            pstm.setString(7, sd.getUrgencia());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error al insertar solicitud directa: " + e.getMessage());
            return false;
        } finally {
            close();
        }
    }
    
    @Override
    public Boolean update(SolicitudDirecta sd) {
        final String SQL_UPDATE = "UPDATE Solicitudes_Directas SET Estado = ? WHERE Solicitud_ID = ?";
         try {
            pstm = con.getConnection().prepareStatement(SQL_UPDATE);
            pstm.setString(1, sd.getEstado());
            pstm.setInt(2, sd.getSolicitudId());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error al actualizar solicitud directa: " + e.getMessage());
            return false;
        } finally {
            close();
        }
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SolicitudDirecta listById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SolicitudDirecta> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}