package com.utp.myapp.model.dao;

import com.utp.myapp.model.connection.ConnectionDataBase;
import com.utp.myapp.model.entities.Propuesta;
import com.utp.myapp.model.repositories.ICRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class PropuestaDAO implements ICRUD<Propuesta> {
    
    private PreparedStatement pstm;
    private ResultSet res;
    private final ConnectionDataBase con;

    public PropuestaDAO() { this.con = ConnectionDataBase.getInstance(); }
    private void close() { /* ... */ }

    @Override
    public Boolean insert(Propuesta p) {
        final String SQL_INSERT = "INSERT INTO Propuestas (Solicitud_Publica_ID, Profesional_ID, Mensaje_Propuesta, Monto_Ofertado, Tiempo_Estimado) VALUES (?, ?, ?, ?, ?)";
        try {
            pstm = con.getConnection().prepareStatement(SQL_INSERT);
            pstm.setInt(1, p.getSolicitudPublicaId());
            pstm.setInt(2, p.getProfesionalId());
            pstm.setString(3, p.getMensajePropuesta());
            pstm.setBigDecimal(4, p.getMontoOfertado());
            pstm.setString(5, p.getTiempoEstimado());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error al insertar propuesta: " + e.getMessage());
            return false;
        } finally {
            close();
        }
    }

    @Override
    public Boolean update(Propuesta t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Propuesta listById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Propuesta> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}