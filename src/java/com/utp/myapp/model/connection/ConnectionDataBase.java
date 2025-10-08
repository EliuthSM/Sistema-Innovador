/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.myapp.model.connection;

import java.sql.*;

/**
 *
 * @author Administrador
 */
public class ConnectionDataBase {

    private static ConnectionDataBase instance;
    private static Connection con;
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=supermercado;Encrypt=True;TrustServerCertificate=True;Instance=MSSQLSERVER";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String USER = "sa";
    private static final String PASS = "123456";

    private ConnectionDataBase() {

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado a la base de datos");

        } catch (Exception e) {
            System.out.println("Error al conectar :" + e.getMessage());
            e.printStackTrace();
        }
    }

    public synchronized static ConnectionDataBase getInstance() {

        if (instance == null) {
            instance = new ConnectionDataBase();
        }
        return instance;
    }

    public Connection getConnection() {
        return con;
    }

    public void close() {
        instance = null;
    }

}
