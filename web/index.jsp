
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Comportamiento responsivo -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <%@include  file="WEB-INF/jspfCss/indexCss.jspf" %>
        <%@include  file="WEB-INF/jspfCss/styles.jspf" %>
    </head>
    <body>
        <!-- Header -->
        <%@include  file="WEB-INF/jspf/header.jspf" %>

        <section class="hero">
            <h1>Encuentra Profesionales de Confianza</h1>
            <p>Conecta con expertos verificados en más de 100 especialidades</p>

            <div class="search-container">
                <form class="search-form">
                    <input type="text" placeholder="¿Qué servicio necesitas?" id="servicio">
                    <select id="categoria">
                        <option value="">Todas las categorías</option>
                        <option value="salud">Salud</option>
                        <option value="tecnologia">Tecnología</option>
                        <option value="educacion">Educación</option>
                        <option value="hogar">Hogar</option>
                        <option value="legal">Legal</option>
                        <option value="finanzas">Finanzas</option>
                    </select>
                    <button type="submit" class="btn btn-primary">Buscar</button>
                </form>
            </div>
        </section>

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
                <div class="category-card" onclick="location.href = 'content.jsp?cat_id=5'">
                    <div class="category-icon">⚖️</div>
                    <h3>Legal</h3>
                    <p>Abogados, notarios, asesores</p>
                </div>
                <div class="category-card" onclick="location.href = 'content.jsp?cat_id=6'">
                    <div class="category-icon">💰</div>
                    <h3>Finanzas</h3>
                    <p>Contadores, asesores financieros</p>
                </div>
            </div>
        </section>

        <section class="featured-professionals">
            <h2>Profesionales Destacados</h2>
            <div class="professionals-grid">
                <div class="professional-card">
                    <div class="professional-header">
                        <div class="professional-avatar">👨‍⚕️</div>
                        <h3>Dr. Juan Pérez</h3>
                        <p>Médico General</p>
                    </div>
                    <div class="professional-body">
                        <div class="rating">⭐⭐⭐⭐⭐ (4.9)</div>
                        <p>15 años de experiencia</p>
                        <p>+500 consultas realizadas</p>
                        <div class="professional-tags">
                            <span class="tag">Medicina General</span>
                            <span class="tag">Pediatría</span>
                        </div>
                        <button class="btn btn-primary" style="width: 100%; margin-top: 1rem;" 
                                onclick="location.href = 'perfilProfesional.jsp?id=1'">Ver Perfil</button>
                    </div>
                </div>

                <div class="professional-card">
                    <div class="professional-header">
                        <div class="professional-avatar">👩‍💻</div>
                        <h3>María González</h3>
                        <p>Desarrolladora Web</p>
                    </div>
                    <div class="professional-body">
                        <div class="rating">⭐⭐⭐⭐⭐ (5.0)</div>
                        <p>8 años de experiencia</p>
                        <p>+200 proyectos completados</p>
                        <div class="professional-tags">
                            <span class="tag">React</span>
                            <span class="tag">Node.js</span>
                            <span class="tag">UI/UX</span>
                        </div>
                        <button class="btn btn-primary" style="width: 100%; margin-top: 1rem;"
                                onclick="location.href = 'perfilProfesional.jsp?id=2'">Ver Perfil</button>
                    </div>
                </div>

                <div class="professional-card">
                    <div class="professional-header">
                        <div class="professional-avatar">👨‍🏫</div>
                        <h3>Carlos Rodríguez</h3>
                        <p>Profesor de Matemáticas</p>
                    </div>
                    <div class="professional-body">
                        <div class="rating">⭐⭐⭐⭐⭐ (4.8)</div>
                        <p>12 años de experiencia</p>
                        <p>+1000 estudiantes</p>
                        <div class="professional-tags">
                            <span class="tag">Cálculo</span>
                            <span class="tag">Álgebra</span>
                            <span class="tag">Preparación Exámenes</span>
                        </div>
                        <button class="btn btn-primary" style="width: 100%; margin-top: 1rem;"
                                onclick="location.href = 'perfilProfesional.jsp?id=3'">Ver Perfil</button>
                    </div>
                </div>
            </div>
        </section>
        <%@include  file="WEB-INF/jspf/footer.jspf" %>
        <script src= "<%= request.getContextPath()%>/RESOURCES/js/header.js" defer></script>
    </body>
</html>
