package com.utp.myapp.controllers;

import com.utp.myapp.dtos.RegistroClienteRequestDTO;
import com.utp.myapp.dtos.RegistroProfesionalRequestDTO;
import com.utp.myapp.dtos.UsuarioResponseDTO;
import com.utp.myapp.model.services.UsuarioService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthController extends HttpServlet {

    private final UsuarioService usuarioService = new UsuarioService();

    // Helper para obtener parámetros de forma segura
    private String getParam(HttpServletRequest request, String name) {
        String value = request.getParameter(name);
        return (value != null && !value.trim().isEmpty()) ? value.trim() : null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // El parámetro de operación puede venir de GET o POST
        String operacion = getParam(request, "operacion");

        if (operacion == null || operacion.isEmpty()) {
            operacion = "login_view"; // Operación por defecto
        }

        try {
            switch (operacion) {
                case "login":
                    login(request, response);
                    break;
                case "logout":
                    logout(request, response);
                    break;
                case "registrar_cliente":
                    registrarCliente(request, response);
                    break;
                case "registrar_profesional":
                    registrarProfesional(request, response);
                    break;
                case "login_view":
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    break;
                case "registro_view":
                    request.getRequestDispatcher("registro.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError("Operación desconocida: " + operacion);
            }
        } catch (Exception e) {
            // Manejador general de excepciones para evitar fallos catastróficos.
            // Esto capturará la SQLException si la inserción falla
            System.err.println("Error en AuthController para operación " + operacion + ": " + e.getMessage());
            e.printStackTrace(); // Imprime la traza completa para diagnóstico
            
            // Reenvía a la vista de registro o error con el mensaje
            request.setAttribute("error", "Ocurrió un error inesperado en el servidor: " + e.getMessage());
            request.getRequestDispatcher("registro.jsp").forward(request, response); 
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Lógica de login
        String correo = getParam(request, "correo");
        String contrasena = request.getParameter("contrasena");

        try {
            UsuarioResponseDTO usuario = usuarioService.login(correo, contrasena);
            if (usuario != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario", usuario);
                // Redirigir según el rol
                if ("Profesional".equals(usuario.getRol())) {
                    response.sendRedirect("profesional?operacion=dashboard");
                } else {
                    response.sendRedirect("cliente?operacion=dashboard");
                }
            } else {
                request.setAttribute("error", "Credenciales incorrectas.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "Ocurrió un error: " + e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("auth?operacion=login_view");
    }

    private void registrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Obtener parámetros de forma segura usando getParam
        String nombreCompleto = getParam(request, "nombreCompleto");
        String correo = getParam(request, "correo");
        String contrasena = request.getParameter("contrasena"); // La contraseña no se trimea
        String telefono = getParam(request, "telefono");

        // 2. Validación de campos críticos antes de crear el DTO
        if (nombreCompleto == null || correo == null || contrasena == null || contrasena.length() < 6) {
             request.setAttribute("error", "Por favor, complete los campos Nombre, Correo y Contraseña.");
             request.getRequestDispatcher("registro.jsp").forward(request, response);
             return;
        }

        // 3. Crear DTO
        RegistroClienteRequestDTO dto = new RegistroClienteRequestDTO(nombreCompleto, correo, contrasena, telefono);

        // 4. Llamar al servicio y manejar excepciones de negocio
        try {
            usuarioService.registrarCliente(dto);
            // Redirección exitosa con mensaje
            response.sendRedirect("auth?operacion=login_view&registro=exitoso");
        } catch (IllegalArgumentException e) {
            // Error de negocio: ej. "El correo ya existe"
            request.setAttribute("error", "Error de registro: " + e.getMessage());
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }

    private void registrarProfesional(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Obtener todos los parámetros de forma segura
        
        // Datos de Usuario
        String nombreCompleto = getParam(request, "nombreCompleto");
        String correo = getParam(request, "correo");
        String contrasena = request.getParameter("contrasena"); // La contraseña no se trimea
        String telefono = getParam(request, "telefono");
        
        // Validación de campos críticos (mínima)
        if (nombreCompleto == null || correo == null || contrasena == null) {
             request.setAttribute("error", "Complete la información personal y de acceso.");
             request.getRequestDispatcher("registro.jsp").forward(request, response);
             return;
        }
        
        // Datos de Profesional
        String ubicacion = getParam(request, "ubicacion");
        String titulo = getParam(request, "titulo");
        String descripcionServicios = getParam(request, "descripcionServicios");
        
        // Campos numéricos (requieren conversión)
        int anosExperiencia = 0;
        int categoriaPrincipalId = 0;

        try {
            anosExperiencia = Integer.parseInt(getParam(request, "anosExperiencia"));
            categoriaPrincipalId = Integer.parseInt(getParam(request, "categoriaPrincipalId"));
        } catch (NumberFormatException e) {
             request.setAttribute("error", "Los campos Experiencia/Especialidad deben ser números válidos.");
             request.getRequestDispatcher("registro.jsp").forward(request, response);
             return;
        }

        // Listas (habilidadesIds)
        String[] habilidadesArray = request.getParameterValues("habilidadesIds");
        List<Integer> habilidadesIds;
        
        if (habilidadesArray != null) {
            try {
                habilidadesIds = Arrays.stream(habilidadesArray)
                                         .map(Integer::parseInt)
                                         .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                 request.setAttribute("error", "Las habilidades seleccionadas contienen valores no numéricos.");
                 request.getRequestDispatcher("registro.jsp").forward(request, response);
                 return;
            }
        } else {
             habilidadesIds = java.util.Collections.emptyList();
        }
        
        // 2. Crear DTO utilizando el constructor completo
        RegistroProfesionalRequestDTO dto = new RegistroProfesionalRequestDTO(
                nombreCompleto, 
                correo, 
                contrasena, 
                telefono,
                ubicacion,
                titulo,
                anosExperiencia,
                descripcionServicios,
                categoriaPrincipalId,
                habilidadesIds
        );
        
        // 3. Llamar al servicio y manejar excepciones
        try {
            usuarioService.registrarProfesional(dto);
            response.sendRedirect("auth?operacion=login_view&registro=exitoso");
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "Error de registro: " + e.getMessage());
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}