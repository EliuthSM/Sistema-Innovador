/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.myapp.controllers;

import com.utp.myapp.dtos.RegistroClienteRequestDTO;
import com.utp.myapp.dtos.RegistroProfesionalRequestDTO;
import com.utp.myapp.dtos.UsuarioResponseDTO;
import com.utp.myapp.model.services.UsuarioService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Administrador
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {

    private final UsuarioService usuarioService = new UsuarioService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operacion = request.getParameter("operacion");

        switch (operacion) {
            case "registrar_cliente":
                registrarCliente(request, response);
                break;
            case "registrar_profesional":
                registrarProfesional(request, response);
                break;
            case "login":
                login(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Operación desconocida: " + operacion);
        }
    }
    // ✅ REGISTRAR CLIENTE

    private void registrarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RegistroClienteRequestDTO dto = new RegistroClienteRequestDTO(
                request.getParameter("nombre"),
                request.getParameter("correo"),
                request.getParameter("contrasena"),
                request.getParameter("telefono"),
                "Cliente"
        );

        try {
            usuarioService.registrarCliente(dto);
            response.sendRedirect("login.jsp?registro=ok");
        } catch (Exception e) {
            request.setAttribute("error", "Error al registrar: " + e.getMessage());
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
    // ✅ REGISTRAR PROFESIONAL

    private void registrarProfesional(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            RegistroProfesionalRequestDTO dto = new RegistroProfesionalRequestDTO();
            dto.setNombreCompleto(request.getParameter("nombre"));
            dto.setCorreo(request.getParameter("correo"));
            dto.setContrasena(request.getParameter("contrasena"));
            dto.setTelefono(request.getParameter("telefono"));
            dto.setUbicacion(request.getParameter("ubicacion"));
            dto.setTitulo(request.getParameter("titulo"));
            dto.setAnosExperiencia(Integer.parseInt(request.getParameter("anosExperiencia")));
            dto.setDescripcionServicios(request.getParameter("descripcionServicios"));
            dto.setCategoriaPrincipalId(Integer.parseInt(request.getParameter("categoriaPrincipalId")));
            dto.setRol("Profesional");

            // Manejo de habilidades múltiples
            String[] habilidadesArray = request.getParameterValues("habilidadesIds");
            List<Integer> habilidadesIds = new ArrayList<>();
            if (habilidadesArray != null) {
                for (String h : habilidadesArray) {
                    habilidadesIds.add(Integer.parseInt(h));
                }
            }
            dto.setHabilidadesIds(habilidadesIds);

            usuarioService.registrarProfesional(dto);
            response.sendRedirect("login.jsp?registro=ok");

        } catch (Exception e) {
            request.setAttribute("error", "Error al registrar profesional: " + e.getMessage());
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        try {
            UsuarioResponseDTO usuario = usuarioService.login(correo, contrasena);

            if (usuario != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);

                // Redirigir según rol
                if ("Cliente".equalsIgnoreCase(usuario.getRol())) {
                    response.sendRedirect("dashboardCliente.jsp");
                } else if ("Profesional".equalsIgnoreCase(usuario.getRol())) {
                    response.sendRedirect("dashboardProfesional.jsp");
                } else {
                    response.sendRedirect("index.jsp");
                }

            } else {
                request.setAttribute("error", "Correo o contraseña incorrectos");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error al iniciar sesión: " + e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    // ✅ LOGOUT

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login.jsp?logout=ok");
    }
}
