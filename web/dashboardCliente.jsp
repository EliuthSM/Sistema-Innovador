<%-- 
    Document   : dashboardCliente
    Created on : 12 oct 2025, 1:27:31
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
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bienvenido - Cliente</title>
<%@include file="WEB-INF/jspfCss/indexCss.jspf" %>
<%@include file="WEB-INF/jspfCss/styles.jspf" %>

        <!-- Script del header para mostrar usuario -->
        <script src="<%= request.getContextPath()%>/RESOURCES/js/headerLogin.js" defer></script>
    </head>

    <!-- 🔹 Aquí añadimos los atributos data-* para que header.js detecte el usuario -->
    <body>
        
        <!-- Header -->
<%@include file="WEB-INF/jspf/headerLogin.jspf" %>
        <!-- Hero / Bienvenida -->
        <section class="hero">
            <h1>👋 ¡Bienvenido, <%= usuario.getNombreCompleto()%>!</h1>
            <p>Nos alegra verte de nuevo en ProfiNet.</p>
            <p>Tu rol actual: <strong><%= usuario.getRol()%></strong></p>
        </section>

        <!-- Contenido principal -->
        <section class="categories">
            <h2>Categorías Populares</h2>
            <div class="category-grid">
                <div class="category-card" onclick="location.href = 'content.jsp?cat_id=1'">
                    <div class="category-icon">⚕️</div>
                    <h3>Salud</h3>
                    <p>Médicos, psicólogos, nutricionistas</p>
                </div>
                <div class="category-card" onclick="location.href = 'content.jsp?cat_id=2'">
                    <div class="category-icon">💻</div>
                    <h3>Tecnología</h3>
                    <p>Programadores, diseñadores, soporte IT</p>
                </div>
                <div class="category-card" onclick="location.href = 'content.jsp?cat_id=3'">
                    <div class="category-icon">📚</div>
                    <h3>Educación</h3>
                    <p>Profesores, tutores, coaches</p>
                </div>
                <div class="category-card" onclick="location.href = 'content.jsp?cat_id=4'">
                    <div class="category-icon">🏠</div>
                    <h3>Hogar</h3>
                    <p>Plomeros, electricistas, jardineros</p>
                </div>
            </div>
        </section>

<%@include file="WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
