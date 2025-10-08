/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.utp.myapp.model.dao;

import com.utp.myapp.model.entities.Usuario;
import com.utp.myapp.security.EncriptarClave;


/**
 *
 * @author Administrador
 */
public class UsuarioDAOTest {
    

    public static void main(String[] args) {
        
        Usuario usuario = new Usuario.Builder()
                .correo("Eliuth")
                .clave("12345678%aB")
                .build();
         
        
        UsuarioDAO dao = new UsuarioDAO();
        
        if (dao.insertSecurity(usuario.getCorreo(),EncriptarClave.encriptar(usuario.getClave()))) {
            System.out.println("Se registro correctamente el usuario");
        } else {
            System.out.println("No se registro el usuairo en la BD");
        }
        
    }
    
    
}
