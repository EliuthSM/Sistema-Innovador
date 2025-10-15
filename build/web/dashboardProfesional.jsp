<%-- 
    Document   : dashboardProfesional
    Created on : 12 oct 2025, 1:28:06
    Author     : Administrador
--%>
<%@page import="com.utp.myapp.dtos.UsuarioResponseDTO"%>
<%
    UsuarioResponseDTO usuario = (UsuarioResponseDTO) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>¡Hola <%= usuario.getNombreCompleto()%>! 🌟</h2>
        <p>Correo: <%= usuario.getCorreo()%></p>
        <p>Rol: <%= usuario.getRol()%></p>

        <a href="../logout.jsp">Cerrar sesión</a>
    </body>
</html>
