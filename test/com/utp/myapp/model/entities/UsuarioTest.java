/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.utp.myapp.model.entities;

/**
 *
 * @author Administrador
 */
public class UsuarioTest {

    public static void main(String[] args) {

        //Crear instancia de usuario válido;
//        Usuario usuario1 = new Usuario.Builder()
//                .id(1)
//                .nombre("nombre")
//                .clave("clavE123@")
//                .build();
//        System.out.println("" + usuario1);

        try {
            Usuario usuario2 = new Usuario.Builder()
                    .id(1)
                    .correo("correo")
                    .clave("clav")
                    .build();
            System.out.println("" + usuario2);
            
        } catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        }
        
//        try {
//             Usuario usuario3 = new Usuario.Builder()
//                    .id(1)
//                    .nombre("nombre")
//                    .clave("clave")
//                    .build();
//            System.out.println("" + usuario3);
//        } catch (Exception e) {
//            System.out.println("Error :"+e.getMessage());
//        }
    }

}
