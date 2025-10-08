/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.utp.myapp.security;


public class EncriptarClaveTest {
    
    public static void main(String[] args) {
        
     String clave =   EncriptarClave.encriptar("Hola");
        System.out.println("Encriptado :"+clave);
        
    }
}
