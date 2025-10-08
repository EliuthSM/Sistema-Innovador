package com.utp.myapp.model.dao;

import com.utp.myapp.model.connection.ConnectionDataBase;
import com.utp.myapp.model.entities.Categoria;
import com.utp.myapp.model.repositories.ICRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements ICRUD<Categoria> {
    
    private PreparedStatement pstm;
    private ResultSet res;
    private final ConnectionDataBase con;
    
    public CategoriaDAO() { this.con = ConnectionDataBase.getInstance(); }
    private void close() { /* ... */ }

    @Override
    public List<Categoria> list() {
        final String SQL_FIND_ALL = "SELECT * FROM Categorias ORDER BY Nombre";
        List<Categoria> categorias = new ArrayList<>();
        try {
            pstm = con.getConnection().prepareStatement(SQL_FIND_ALL);
            res = pstm.executeQuery();
            while (res.next()) {
                categorias.add(new Categoria.Builder()
                        .categoriaId(res.getInt("Categoria_ID"))
                        .nombre(res.getString("Nombre"))
                        .descripcion(res.getString("Descripcion"))
                        .build()
                );
            }
        } catch (Exception e) {
            System.err.println("Error al listar categorías: " + e.getMessage());
        } finally {
            close();
        }
        return categorias;
    }

    @Override
    public Boolean insert(Categoria t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean update(Categoria t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categoria listById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}