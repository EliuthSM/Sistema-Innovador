package com.utp.myapp.model.dao;

import com.utp.myapp.model.connection.ConnectionDataBase;
import com.utp.myapp.model.entities.Usuario;
import com.utp.myapp.model.repositories.ICRUD; // Usamos la interfaz base
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements ICRUD<Usuario> {

    private PreparedStatement pstm;
    private ResultSet res;
    private final ConnectionDataBase con;

    public UsuarioDAO() {
        this.con = ConnectionDataBase.getInstance();
    }

    private void close() {
        try {
            if (res != null) res.close();
            if (pstm != null) pstm.close();
            // No cerramos la conexión principal aquí para poder reutilizarla
        } catch (Exception e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }

    //Boolean insert(T t);
    
    @Override
    public Boolean insert(Usuario usuario) {
        final String SQL_INSERT = "INSERT INTO Usuario (Nombre_Completo, Correo_Electronico, Contrasena_Hash, Rol) VALUES (?, ?, ?, ?)";
        try {
            pstm = con.getConnection().prepareStatement(SQL_INSERT);
            pstm.setString(1, usuario.getNombreCompleto());
            pstm.setString(2, usuario.getCorreoElectronico());
            pstm.setString(3, usuario.getContrasenaHash());
            pstm.setString(4, usuario.getRol());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
            return false;
        } finally {
            close();
        }
    }

    @Override
    public Boolean update(Usuario usuario) {
        // Implementar lógica de actualización si es necesario
        return false;
    }

    @Override
    public Usuario listById(Integer id) {
        final String SQL_FIND_BY_ID = "SELECT * FROM Usuario WHERE Usuario_ID = ?";
        Usuario usuario = null;
        try {
            pstm = con.getConnection().prepareStatement(SQL_FIND_BY_ID);
            pstm.setInt(1, id);
            res = pstm.executeQuery();
            if (res.next()) {
                usuario = new Usuario.Builder()
                .usuarioId(res.getInt("Usuario_ID"))
                .nombreCompleto(res.getString("Nombre_Completo"))
                .correoElectronico(res.getString("Correo_Electronico"))
                .contrasenaHash(res.getString("Contrasena_Hash")) // Temporalmente en texto plano
                .rol("Profesional")
                .build();
            }
        } catch (Exception e) {
            System.out.println("Error al buscar usuario por ID: " + e.getMessage());
        } finally {
            close();
        }
        return usuario;
    }

    public Usuario findByCorreo(String correo) {
        final String SQL_FIND_BY_CORREO = "SELECT * FROM Usuario WHERE Correo_Electronico = ?";
        Usuario usuario = null;
        try {
            pstm = con.getConnection().prepareStatement(SQL_FIND_BY_CORREO);
            pstm.setString(1, correo);
            res = pstm.executeQuery();
            if (res.next()) {
                usuario = new Usuario.Builder()
                .usuarioId(res.getInt("Usuario_ID"))
                .nombreCompleto(res.getString("Nombre_Completo"))
                .correoElectronico(res.getString("Correo_Electronico"))
                .contrasenaHash(res.getString("Contrasena_Hash")) // Temporalmente en texto plano
                .rol("Profesional")
                .build();
            }
        } catch (Exception e) {
            System.out.println("Error al buscar usuario por correo: " + e.getMessage());
        } finally {
            close();
        }
        return usuario;
    }

    public boolean existsByCorreo(String correo) {
        final String SQL_EXISTS = "SELECT 1 FROM Usuario WHERE Correo_Electronico = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_EXISTS);
            pstm.setString(1, correo);
            res = pstm.executeQuery();
            return res.next();
        } catch (Exception e) {
            System.out.println("Error al verificar existencia de correo: " + e.getMessage());
            return false;
        } finally {
            close();
        }
    }

    @Override
    public List<Usuario> list() {
        // Implementar si se necesita una lista de todos los usuarios
        return new ArrayList<>();
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}