
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Comportamiento responsivo -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <%@include  file="WEB-INF/jspfCss/perfilProfesionalCss.jspf" %>
        <%@include  file="WEB-INF/jspfCss/styles.jspf" %>
    </head>
    <body>
        <!-- Header -->
        <%@include  file="WEB-INF/jspf/header.jspf" %>
        <div class="container">
        <div class="profile-header">
            <div class="profile-top">
                <div class="profile-photo-section">
                    <div class="profile-photo">MG</div>
                    <button class="btn-change-photo">Verificado ✓</button>
                </div>

                <div class="profile-info">
                    <h1>María González</h1>
                    <span class="profession-tag">Desarrolladora Web</span>
                    
                    <div class="rating-section">
                        <div class="stars">★★★★★</div>
                        <span class="rating-text">5.0 (48 reseñas)</span>
                    </div>

                    <p class="description-text">
                        Desarrolladora web full-stack con más de 8 años de experiencia creando sitios web y aplicaciones empresariales. 
                        Especializada en React, Node.js y UI/UX design. Comprometida con la entrega de proyectos de alta calidad.
                    </p>

                    <div class="stats-grid">
                        <div class="stat-item">
                            <div class="stat-number">200+</div>
                            <div class="stat-label">Proyectos completados</div>
                        </div>
                        <div class="stat-item">
                            <div class="stat-number">98%</div>
                            <div class="stat-label">Satisfacción</div>
                        </div>
                        <div class="stat-item">
                            <div class="stat-number">8</div>
                            <div class="stat-label">Años de experiencia</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

                <div class="profile-section">
                    <button class="btn-contact">Solicitar Servicio</button>
                    <button class="btn-message">Enviar Mensaje</button>
                </div>

        <div class="profile-content">
            <div class="main-content">
                <div class="profile-section">
                    <h2 class="section-title">Habilidades</h2>
                    <div class="skills-list">
                        <span class="skill-tag">React</span>
                        <span class="skill-tag">Node.js</span>
                        <span class="skill-tag">JavaScript</span>
                        <span class="skill-tag">UI/UX</span>
                        <span class="skill-tag">HTML/CSS</span>
                        <span class="skill-tag">MongoDB</span>
                        <span class="skill-tag">Git</span>
                        <span class="skill-tag">API REST</span>
                        <span class="skill-tag">Responsive Design</span>
                    </div>
                </div>

                <div class="profile-section">
                    <h2 class="section-title">Reseñas de Clientes</h2>
                    
                    <div class="review-item">
                        <div class="review-header">
                            <span class="reviewer-name">Carlos Rodríguez</span>
                            <span class="review-date">Hace 2 semanas</span>
                        </div>
                        <div class="review-stars">★★★★★</div>
                        <p class="review-text">
                            Excelente profesional. Desarrolló un sitio web para mi negocio y el resultado superó mis expectativas. 
                            Muy comunicativa y atenta a los detalles. La recomiendo 100%.
                        </p>
                    </div>

                    <div class="review-item">
                        <span class="reviewer-name">Laura Martínez</span>
                            <span class="review-date">Hace 1 mes</span>
                        </div>
                        <div class="review-stars">★★★★★</div>
                        <p class="review-text">
                            María es increíble. No solo tiene conocimientos técnicos sólidos, sino que también entiende las 
                            necesidades del negocio. Entregó el proyecto antes de tiempo.
                        </p>
                    </div>

                </div>
            </div>

            <div class="sidebar">
                <div class="profile-section">
                    <h2 class="section-title">Información</h2>
                    
                    <div class="info-item">
                        <span class="info-label">Ubicación:</span>
                        <span class="info-value">Lima, Perú</span>
                    </div>
                    
                    <div class="info-item">
                        <span class="info-label">Miembro desde:</span>
                        <span class="info-value">Enero 2020</span>
                    </div>
                    
                    <div class="info-item">
                        <span class="info-label">Tiempo respuesta:</span>
                        <span class="info-value">< 1 hora</span>
                    </div>
                    
                    <div class="info-item">
                        <span class="info-label">Última conexión:</span>
                        <span class="info-value">Hace 2 horas</span>
                    </div>

                    <div class="info-item">
                        <span class="info-label">Idiomas:</span>
                        <span class="info-value">Español, Inglés</span>
                    </div>
                </div>

                <div class="profile-section">
                    <h2 class="section-title">Tarifas</h2>
                    
                    <div class="info-item">
                        <span class="info-label">Por hora:</span>
                        <span class="info-value">$50 - $75</span>
                    </div>
                    
                    <div class="info-item">
                        <span class="info-label">Proyecto pequeño:</span>
                        <span class="info-value">$500 - $1,500</span>
                    </div>
                    
                    <div class="info-item">
                        <span class="info-label">Proyecto mediano:</span>
                        <span class="info-value">$1,500 - $5,000</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        document.querySelector('.btn-contact').addEventListener('click', function() {
            alert('Redirigiendo a formulario de solicitud de servicio...');
            // window.location.href = 'solicitar-servicio.html';
        });

        document.querySelector('.btn-message').addEventListener('click', function() {
            alert('Abriendo chat con el profesional...');
            // window.location.href = 'mensajes.html';
        });
    </script>
    </body>
</html>
