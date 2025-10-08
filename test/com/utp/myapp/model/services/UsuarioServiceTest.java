/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.utp.myapp.model.services;

import com.utp.myapp.dtos.UsuarioDTORequest;

/**
 *
 * @author C19255
 */

public class UsuarioServiceTest {
    
    public static void main(String[] args) {
        
        UsuarioDTORequest usuario = new UsuarioDTORequest("usuario", "clave123ABC%");
    
        UsuarioService usuarioService = new UsuarioService();
        
        
        if (usuarioService.insert(usuario)) {
            System.out.println("Se inserto el registro en la base de datos");    
        } else {
            System.out.println("No se inserto el registro en la bd");
        }
              
        
    }
    
}
