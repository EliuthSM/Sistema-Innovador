package com.utp.myapp.controllers;

import com.utp.myapp.dtos.CalificacionRequestDTO;
import com.utp.myapp.dtos.UsuarioResponseDTO;
import com.utp.myapp.model.services.CalificacionService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalificacionController extends HttpServlet {

    private final CalificacionService calificacionService = new CalificacionService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operacion = request.getParameter("operacion");

        if (operacion == null || operacion.isEmpty()) {
            response.sendRedirect("index.jsp");
            return;
        }

        switch (operacion) {
            case "mostrarFormulario":
                mostrarFormulario(request, response);
                break;
            case "registrar":
                registrar(request, response);
                break;
            default:
                throw new AssertionError("Operación desconocida: " + operacion);
        }
    }
    
    private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pasamos los IDs necesarios a la vista para que el formulario sepa a quién calificar
        request.setAttribute("solicitudId", request.getParameter("solicitudId"));
        request.setAttribute("profesionalId", request.getParameter("profesionalId"));
        request.getRequestDispatcher("calificar_servicio.jsp").forward(request, response);
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            // 1. Obtener datos del formulario y de la sesión
            int puntuacion = Integer.parseInt(request.getParameter("puntuacion"));
            String comentario = request.getParameter("comentario");
            int profesionalId = Integer.parseInt(request.getParameter("profesionalId"));
            int solicitudId = Integer.parseInt(request.getParameter("solicitudId"));
            
            UsuarioResponseDTO cliente = (UsuarioResponseDTO) request.getSession().getAttribute("usuario");
            int clienteId = cliente.getUsuarioId();
            
            // 2. Crear DTO
            CalificacionRequestDTO dto = new CalificacionRequestDTO(profesionalId, clienteId, solicitudId, puntuacion, comentario);
            
            // 3. Llamar al servicio
            calificacionService.registrarCalificacion(dto);
            
            // 4. Redirigir a una página de agradecimiento
            response.sendRedirect("cliente?operacion=dashboard&calificacion=exitosa");

        } catch (Exception e) {
            request.setAttribute("error", "No se pudo registrar la calificación: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
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