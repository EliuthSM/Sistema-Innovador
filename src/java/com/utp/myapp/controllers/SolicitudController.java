package com.utp.myapp.controllers;

import com.utp.myapp.dtos.UsuarioResponseDTO;
import com.utp.myapp.model.services.SolicitudService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SolicitudController extends HttpServlet {

    private final SolicitudService solicitudService = new SolicitudService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operacion = request.getParameter("operacion");

        switch (operacion) {
            case "explorar":
                explorar(request, response);
                break;
            case "crearPublica":
                // Lógica para guardar una nueva solicitud pública (POST)
                break;
            case "enviarDirecta":
                // Lógica para enviar una solicitud directa a un profesional (POST)
                break;
            case "dashboardProfesional":
                dashboardProfesional(request, response);
                break;
            case "actualizarEstado":
                // Lógica para que el profesional acepte o rechace una solicitud
                break;
            default:
                throw new AssertionError();
        }
    }

    private void explorar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // List<SolicitudPublicaResponseDTO> solicitudes = solicitudService.listarSolicitudesPublicasActivas();
        // request.setAttribute("solicitudes", solicitudes);
        request.getRequestDispatcher("explorar_solicitudes.jsp").forward(request, response);
    }

    private void dashboardProfesional(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Obtener usuario de la sesión
        UsuarioResponseDTO usuario = (UsuarioResponseDTO) request.getSession().getAttribute("usuario");
        
        // 2. Llamar al servicio
        // List<SolicitudDirectaResponseDTO> solicitudes = solicitudService.listarSolicitudesDirectasRecibidas(usuario.getUsuarioId());

        // 3. Poner resultados en el request y despachar
        // request.setAttribute("solicitudes", solicitudes);
        request.getRequestDispatcher("solicitudes_recibidas.jsp").forward(request, response);
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