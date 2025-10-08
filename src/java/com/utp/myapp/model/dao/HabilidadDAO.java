package com.utp.myapp.model.dao;

import com.utp.myapp.model.connection.ConnectionDataBase;
import com.utp.myapp.model.entities.Habilidad;
import com.utp.myapp.model.repositories.ICRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HabilidadDAO implements ICRUD<Habilidad> {
    
    private PreparedStatement pstm;
    private ResultSet res;
    private final ConnectionDataBase con;
    
    public HabilidadDAO() { this.con = ConnectionDataBase.getInstance(); }
    private void close() { /* ... */ }

    @Override
    public List<Habilidad> list() {
        final String SQL_FIND_ALL = "SELECT * FROM Habilidades ORDER BY Nombre";
        List<Habilidad> habilidades = new ArrayList<>();
        try {
            pstm = con.getConnection().prepareStatement(SQL_FIND_ALL);
            res = pstm.executeQuery();
            while (res.next()) {
                habilidades.add(new Habilidad
                    .Builder()
                    .habilidadId(res.getInt("Habilidad_ID"))
                    .nombre(res.getString("Nombre"))
                    .build()
                );
            }
        } catch (Exception e) {
            System.err.println("Error al listar habilidades: " + e.getMessage());
        } finally {
            close();
        }
        return habilidades;
    }

    @Override
    public Boolean insert(Habilidad t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean update(Habilidad t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Habilidad listById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}