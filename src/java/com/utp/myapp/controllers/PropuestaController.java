    package com.utp.myapp.controllers;

import com.utp.myapp.dtos.PropuestaRequestDTO;
import com.utp.myapp.dtos.PropuestaResponseDTO;
import com.utp.myapp.dtos.UsuarioResponseDTO;
import com.utp.myapp.model.services.PropuestaService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PropuestaController extends HttpServlet {

    private final PropuestaService propuestaService = new PropuestaService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operacion = request.getParameter("operacion");

        if (operacion == null || operacion.isEmpty()) {
            // Redirigir a una página principal o de error si no hay operación
            response.sendRedirect("index.jsp");
            return;
        }

        switch (operacion) {
            case "enviar":
                enviar(request, response);
                break;
            case "listarPorSolicitud":
                listarPorSolicitud(request, response);
                break;
            default:
                throw new AssertionError("Operación desconocida: " + operacion);
        }
    }

    private void enviar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            // 1. Obtener datos del formulario y de la sesión
            int solicitudId = Integer.parseInt(request.getParameter("solicitudId"));
            String mensaje = request.getParameter("mensaje");
            BigDecimal monto = new BigDecimal(request.getParameter("monto"));
            String tiempo = request.getParameter("tiempoEstimado");
            
            UsuarioResponseDTO profesional = (UsuarioResponseDTO) request.getSession().getAttribute("usuario");
            int profesionalId = profesional.getUsuarioId();

            // 2. Crear DTO
            PropuestaRequestDTO dto = new PropuestaRequestDTO(solicitudId, profesionalId, mensaje, monto, tiempo);
            
            // 3. Llamar al servicio
            propuestaService.enviarPropuesta(dto);

            // 4. Redirigir a una página de éxito
            response.sendRedirect("solicitud?operacion=explorar&propuesta=exitosa");

        } catch (Exception e) {
            request.setAttribute("error", "No se pudo enviar la propuesta: " + e.getMessage());
            // Idealmente, redirigir a la página de la solicitud con el error
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void listarPorSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1. Obtener ID de la solicitud
            int solicitudId = Integer.parseInt(request.getParameter("solicitudId"));

            // 2. Llamar al servicio
            List<PropuestaResponseDTO> propuestas = propuestaService.listarPropuestasPorSolicitud(solicitudId);

            // 3. Poner resultados en el request y despachar a la vista
            request.setAttribute("propuestas", propuestas);
            request.setAttribute("solicitudId", solicitudId); // Enviar el ID para el título de la página
            request.getRequestDispatcher("ver_propuestas.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "No se pudieron cargar las propuestas: " + e.getMessage());
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