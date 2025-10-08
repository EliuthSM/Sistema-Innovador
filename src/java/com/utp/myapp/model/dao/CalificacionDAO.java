package com.utp.myapp.model.dao;

import com.utp.myapp.model.connection.ConnectionDataBase;
import com.utp.myapp.model.entities.Calificacion;
import com.utp.myapp.model.repositories.ICRUD;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class CalificacionDAO implements ICRUD<Calificacion> {
    
    private PreparedStatement pstm;
    private ResultSet res;
    private final ConnectionDataBase con;

    public CalificacionDAO() { this.con = ConnectionDataBase.getInstance(); }
    private void close() { /* ... */ }

    @Override
    public Boolean insert(Calificacion c) {
        final String SQL_INSERT = "INSERT INTO Calificaciones (Profesional_ID, Cliente_ID, Solicitud_ID, Puntuacion, Comentario) VALUES (?, ?, ?, ?, ?)";
        try {
            pstm = con.getConnection().prepareStatement(SQL_INSERT);
            pstm.setInt(1, c.getProfesionalId());
            pstm.setInt(2, c.getClienteId());
            pstm.setInt(3, c.getSolicitudId());
            pstm.setInt(4, c.getPuntuacion());
            pstm.setString(5, c.getComentario());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error al insertar calificación: " + e.getMessage());
            return false;
        } finally {
            close();
        }
    }
    
    public BigDecimal calcularPromedioParaProfesional(int profesionalId) {
        final String SQL_AVG = "SELECT AVG(CAST(Puntuacion AS DECIMAL(10,2))) as promedio FROM Calificaciones WHERE Profesional_ID = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_AVG);
            pstm.setInt(1, profesionalId);
            res = pstm.executeQuery();
            if (res.next()) {
                return res.getBigDecimal("promedio");
            }
        } catch (Exception e) {
            System.err.println("Error al calcular promedio: " + e.getMessage());
        } finally {
            close();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public Boolean update(Calificacion t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Calificacion listById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Calificacion> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}