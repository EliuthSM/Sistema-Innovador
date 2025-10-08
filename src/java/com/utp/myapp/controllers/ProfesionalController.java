package com.utp.myapp.controllers;

import com.utp.myapp.dtos.ProfesionalDetailResponseDTO;
import com.utp.myapp.model.services.ProfesionalService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfesionalController extends HttpServlet {
    
    private final ProfesionalService profesionalService = new ProfesionalService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String operacion = request.getParameter("operacion");

        switch (operacion) {
            case "listar":
                listar(request, response);
                break;
            case "verPerfil":
                verPerfil(request, response);
                break;
            case "miPerfil":
                // Lógica para que un profesional vea su propio perfil para editarlo
                break;
            case "actualizarPerfil":
                // Lógica para procesar la actualización del perfil
                break;
            case "dashboard":
                // Vista principal del profesional
                request.getRequestDispatcher("dashboard_profesional.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Obtener parámetros de filtro (opcional)
        String categoria = request.getParameter("categoria");
        String calificacion = request.getParameter("calificacion");
        
        // 2. Crear DTO de filtros y llamar al servicio (lógica a implementar)
        // List<ProfesionalCardResponseDTO> profesionales = profesionalService.buscarProfesionales(filtros);
        
        // 3. Poner resultados en el request y despachar a la vista
        // request.setAttribute("profesionales", profesionales);
        request.getRequestDispatcher("buscar.jsp").forward(request, response);
    }

    private void verPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Obtener ID del profesional
        int id = Integer.parseInt(request.getParameter("id"));

        // 2. Llamar al servicio
        ProfesionalDetailResponseDTO profesional = profesionalService.obtenerPerfilDetallado(id);

        // 3. Poner el DTO en el request y despachar
        request.setAttribute("profesional", profesional);
        request.getRequestDispatcher("perfil.jsp").forward(request, response);
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