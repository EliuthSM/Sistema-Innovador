package com.utp.myapp.model.connection;

import java.sql.*;

public class ConnectionDataBase {

    private static ConnectionDataBase instance;
    private static Connection con;
    
    // CORRECCIÓN: Se ajusta el formato de la URL para usar ';' en lugar de ':' 
    // y se elimina la doble barra '\' para la instancia.
    // Confirma que tu instancia se llama 'MSSQLSERVER'
    private static final String URL = "jdbc:sqlserver://localhost:1433;instanceName=MSSQLSERVER;databaseName=BDServicioIntegral;Encrypt=True;TrustServerCertificate=True";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String USER = "sa";
    private static final String PASS = "123456";

    private ConnectionDataBase() {
        try {
            Class.forName(DRIVER);
            
            // INTENTA CONECTARSE
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado a la base de datos");

        } catch (Exception e) {
            // SI FALLA, LANZA UNA EXCEPCIÓN FATAL
            System.err.println("-----------------------------------------------------------------");
            System.err.println("--- ERROR CRÍTICO: FALLÓ LA CONEXIÓN A LA BASE DE DATOS MSSQL ---");
            System.err.println("--- REVISA: Usuario, Contraseña, y si la instancia está activa. ---");
            System.err.println("-----------------------------------------------------------------");
            e.printStackTrace();
            
            // Relanza el error como una RuntimeException para detener el despliegue
            throw new RuntimeException("Error fatal de conexión a DB. Ver consola para detalles.", e);
        }
    }

    public synchronized static ConnectionDataBase getInstance() {
        // La conexión se intenta establecer en el constructor solo la primera vez.
        if (instance == null) {
            instance = new ConnectionDataBase();
        }
        return instance;
    }

    public Connection getConnection() {
        // Aseguramos que la instancia no sea nula, aunque el constructor debe garantizarlo
        if (con == null) {
             throw new IllegalStateException("La conexión a la base de datos no fue inicializada.");
        }
        return con;
    }

    public void close() {
        instance = null;
    }
}