package com.utp.myapp.controllers;

import com.utp.myapp.dtos.RegistroClienteRequestDTO;
import com.utp.myapp.dtos.RegistroProfesionalRequestDTO;
import com.utp.myapp.dtos.UsuarioResponseDTO;
import com.utp.myapp.model.services.UsuarioService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthController extends HttpServlet {

    private final UsuarioService usuarioService = new UsuarioService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String operacion = request.getParameter("operacion");

        if (operacion == null || operacion.isEmpty()) {
            operacion = "login_view"; // Operación por defecto
        }

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
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String correo = request.getParameter("correo");
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
        // 1. Obtener parámetros
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String telefono = request.getParameter("telefono");

        // 2. Crear DTO
        RegistroClienteRequestDTO dto = new RegistroClienteRequestDTO(nombre, correo, contrasena, telefono);

        // 3. Llamar al servicio
        try {
            usuarioService.registrarCliente(dto);
            response.sendRedirect("auth?operacion=login_view&registro=exitoso");
        } catch (Exception e) {
            request.setAttribute("error", "No se pudo registrar: " + e.getMessage());
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
    
    private void registrarProfesional(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica similar a registrarCliente pero con más campos y usando RegistroProfesionalRequestDTO
        // NOTA: Para campos como 'habilidadesIds' que son múltiples, usar request.getParameterValues("habilidadesIds");
        System.out.println("Lógica para registrar profesional aquí...");
        response.sendRedirect("auth?operacion=login_view&registro=exitoso");
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