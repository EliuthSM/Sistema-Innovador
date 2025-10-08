package com.utp.myapp.model.dao;

import com.utp.myapp.model.connection.ConnectionDataBase;
import com.utp.myapp.model.entities.SolicitudPublica;
import com.utp.myapp.model.repositories.ICRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SolicitudPublicaDAO implements ICRUD<SolicitudPublica> {
    
    private PreparedStatement pstm;
    private ResultSet res;
    private final ConnectionDataBase con;

    public SolicitudPublicaDAO() { this.con = ConnectionDataBase.getInstance(); }
    private void close() { /* ... */ }

    @Override
    public Boolean insert(SolicitudPublica sp) {
        final String SQL_INSERT = "INSERT INTO Solicitudes_Publicas (Cliente_ID, Categoria_ID, Titulo, Descripcion, Presupuesto_Min, Presupuesto_Max, Urgencia, Plazo_Entrega) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pstm = con.getConnection().prepareStatement(SQL_INSERT);
            pstm.setInt(1, sp.getClienteId());
            pstm.setInt(2, sp.getCategoriaId());
            pstm.setString(3, sp.getTitulo());
            pstm.setString(4, sp.getDescripcion());
            pstm.setBigDecimal(5, sp.getPresupuestoMin());
            pstm.setBigDecimal(6, sp.getPresupuestoMax());
            pstm.setString(7, sp.getUrgencia());
            pstm.setString(8, sp.getPlazoEntrega());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error al insertar solicitud pública: " + e.getMessage());
            return false;
        } finally {
            close();
        }
    }

    public Boolean updateEstado(int solicitudId, String nuevoEstado) {
        final String SQL_UPDATE_STATUS = "UPDATE Solicitudes_Publicas SET Estado = ? WHERE Solicitud_Publica_ID = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_UPDATE_STATUS);
            pstm.setString(1, nuevoEstado);
            pstm.setInt(2, solicitudId);
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error al actualizar estado de solicitud: " + e.getMessage());
            return false;
        } finally {
            close();
        }
    }

    @Override
    public Boolean update(SolicitudPublica t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SolicitudPublica listById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SolicitudPublica> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    


}