package com.utp.myapp.model.dao;

import com.utp.myapp.model.connection.ConnectionDataBase;
import com.utp.myapp.model.entities.Usuario;
import com.utp.myapp.model.repositories.ICRUD;
import java.sql.Connection; // Importante para transacciones
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements ICRUD<Usuario> {

    private PreparedStatement pstm;
    private ResultSet res;
    private final ConnectionDataBase con;

    // Constructor por defecto (para operaciones unitarias sin transacción)
    public UsuarioDAO() {
        this.con = ConnectionDataBase.getInstance();
    }

    private void close() {
        try {
            // Se cierra solo si no estamos en una transacción controlada externamente
            if (res != null) res.close();
            if (pstm != null) pstm.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }

    // --- Métodos de Inserción ---
    
    // Método delegado para ICRUD
    @Override
    public Boolean insert(Usuario usuario) {
        // Ejecuta la inserción unitaria
        return insertAndGetId(usuario, con.getConnection()) > 0;
    }

    /**
     * Inserta un nuevo usuario y recupera el ID generado.
     * Este método gestiona su propia conexión y cierra recursos (para operaciones unitarias).
     * @param usuario El objeto Usuario a insertar.
     * @return El ID generado del nuevo usuario, o 0 si la inserción falla.
     */
    public int insertAndGetId(Usuario usuario) {
        return insertAndGetId(usuario, con.getConnection()); // Delega al método sobrecargado
    }
    
    /**
     * Inserta un nuevo usuario y recupera el ID generado usando una conexión externa (para transacciones).
     * NOTA: No cierra la conexión ni los recursos pstm/res en el finally.
     * @param usuario El objeto Usuario a insertar.
     * @param externalConn La conexión transaccional provista por el Service.
     * @return El ID generado del nuevo usuario, o 0 si la inserción falla.
     */
    public int insertAndGetId(Usuario usuario, Connection externalConn) {
        // La consulta debe coincidir con tu tabla: (Nombre_Completo, Correo_Electronico, Contrasena_Hash, Rol)
        final String SQL_INSERT = "INSERT INTO Usuario (Nombre_Completo, Correo_Electronico, Contrasena_Hash, Rol) VALUES (?, ?, ?, ?)";
        int idGenerado = 0;
        PreparedStatement localPstm = null;
        ResultSet localRes = null;

        try {
            localPstm = externalConn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            
            localPstm.setString(1, usuario.getNombreCompleto());
            localPstm.setString(2, usuario.getCorreoElectronico());
            localPstm.setString(3, usuario.getContrasenaHash());
            localPstm.setString(4, usuario.getRol());

            int filasAfectadas = localPstm.executeUpdate();
            
            if (filasAfectadas > 0) {
                localRes = localPstm.getGeneratedKeys();
                if (localRes.next()) {
                    idGenerado = localRes.getInt(1);
                    usuario.setUsuarioId(idGenerado);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al insertar usuario y obtener ID (Transaccional): " + e.getMessage());
        } finally {
            // Importante: No cerramos la conexión (externalConn). El Service lo hará.
            try {
                if (localRes != null) localRes.close();
                if (localPstm != null) localPstm.close();
            } catch (Exception ex) {
                System.out.println("Error al cerrar recursos locales en transacción: " + ex.getMessage());
            }
        }
        return idGenerado;
    }

    // --- Otros Métodos (Sin Cambios) ---

    @Override
    public Boolean update(Usuario usuario) {
        // Implementar lógica de actualización si es necesario
        return false;
    }

    // ... (listById, findByCorreo, existsByCorreo, list, delete se mantienen iguales o deben usar externalConn si se vuelven transaccionales)
    
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
                .rol(res.getString("Rol"))
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
                .contrasenaHash(res.getString("Contrasena_Hash")) 
                .rol(res.getString("Rol"))
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
        return new ArrayList<>();
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
