<%

    String mensaje = (String) request.getSession().getAttribute("mensaje");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Comportamiento responsivo -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <%@include  file="WEB-INF/jspfCss/contentClienteCss.jspf" %>
        <%@include  file="WEB-INF/jspfCss/styles.jspf" %>
    </head>
    <body>
        <!-- Header -->
        <%@include  file="WEB-INF/jspf/header.jspf" %>
        <!-- Hero de búsqueda -->
        <div class="search-hero">
            <h1>Encuentra al Profesional Perfecto</h1>
            <p>Miles de expertos listos para ayudarte con tu proyecto</p>
            <div class="search-box-container">
                <div class="search-box">
                    <input type="text" id="searchInput" placeholder="¿Qué servicio necesitas? Ej: desarrollador web, diseñador gráfico...">
                    <button onclick="searchProfessionals()">Buscar</button>
                </div>
            </div>
        </div>

        <!-- Contenido principal -->
        <div class="container">
            <div class="content-layout">

                <!-- Filtros -->
                <aside class="filters-sidebar">
                    
                    <div class="filter-section">
                        <h3 class="filter-title">Categorías</h3>
                        <div class="filter-group">
                            <div class="filter-option">
                                <input type="checkbox" id="cat-tech" name="category" value="tecnologia">
                                <label for="cat-tech">Tecnología</label>
                                <span class="filter-count">(156)</span>
                            </div>
                            <div class="filter-option">
                                <input type="checkbox" id="cat-health" name="category" value="salud">
                                <label for="cat-health">Salud</label>
                                <span class="filter-count">(89)</span>
                            </div>
                            <div class="filter-option">
                                <input type="checkbox" id="cat-edu" name="category" value="educacion">
                                <label for="cat-edu">Educación</label>
                                <span class="filter-count">(124)</span>
                            </div>
                            <div class="filter-option">
                                <input type="checkbox" id="cat-legal" name="category" value="legal">
                                <label for="cat-legal">Legal</label>
                                <span class="filter-count">(67)</span>
                            </div>
                            <div class="filter-option">
                                <input type="checkbox" id="cat-finance" name="category" value="finanzas">
                                <label for="cat-finance">Finanzas</label>
                                <span class="filter-count">(45)</span>
                            </div>
                            <div class="filter-option">
                                <input type="checkbox" id="cat-home" name="category" value="hogar">
                                <label for="cat-home">Hogar</label>
                                <span class="filter-count">(98)</span>
                            </div>
                        </div>
                    </div>

                    <div class="filter-section">
                        <h3 class="filter-title">Rango de Precio</h3>
                        <div class="price-inputs">
                            <input type="number" placeholder="Min" id="priceMin">
                            <span class="price-separator">-</span>
                            <input type="number" placeholder="Max" id="priceMax">
                        </div>
                    </div>

                    <div class="filter-section">
                        <h3 class="filter-title">Calificación</h3>
                        <div class="filter-group">
                            <div class="rating-filter" onclick="selectRating(5)">
                                <input type="radio" name="rating" value="5">
                                <span class="stars">★★★★★</span>
                                <span>(45)</span>
                            </div>
                            <div class="rating-filter" onclick="selectRating(4)">
                                <input type="radio" name="rating" value="4">
                                <span class="stars">★★★★</span>
                                <span>y más (128)</span>
                            </div>
                            <div class="rating-filter" onclick="selectRating(3)">
                                <input type="radio" name="rating" value="3">
                                <span class="stars">★★★</span>
                                <span>y más (256)</span>
                            </div>
                        </div>
                    </div>

                    <div class="filter-section">
                        <h3 class="filter-title">Experiencia</h3>
                        <div class="filter-group">
                            <div class="filter-option">
                                <input type="radio" id="exp-all" name="experience" value="all" checked>
                                <label for="exp-all">Todos</label>
                            </div>
                            <div class="filter-option">
                                <input type="radio" id="exp-1" name="experience" value="1-3">
                                <label for="exp-1">1-3 años</label>
                            </div>
                            <div class="filter-option">
                                <input type="radio" id="exp-2" name="experience" value="3-5">
                                <label for="exp-2">3-5 años</label>
                            </div>
                            <div class="filter-option">
                                <input type="radio" id="exp-3" name="experience" value="5+">
                                <label for="exp-3">5+ años</label>
                            </div>
                        </div>
                    </div>

                    <div class="filter-section">
                        <h3 class="filter-title">Disponibilidad</h3>
                        <div class="filter-group">
                            <div class="filter-option">
                                <input type="checkbox" id="avail-now" name="availability">
                                <label for="avail-now">Disponible ahora</label>
                            </div>
                            <div class="filter-option">
                                <input type="checkbox" id="avail-verified" name="availability">
                                <label for="avail-verified">Verificado</label>
                            </div>
                            <div class="filter-option">
                                <input type="checkbox" id="avail-top" name="availability">
                                <label for="avail-top">Top Rated</label>
                            </div>
                        </div>
                    </div>

                    <button class="btn-clear-filters" onclick="clearFilters()">Limpiar Filtros</button>
                </aside>

                <main class="results-section">
                    <div class="results-header">
                        <div class="results-count" id="resultsCount">156 profesionales encontrados</div>
                        <div class="sort-dropdown">
                            <label>Ordenar por:</label>
                            <select id="sortSelect" onchange="sortResults()">
                                <option value="relevance">Relevancia</option>
                                <option value="rating">Mejor calificados</option>
                                <option value="price-low">Precio: menor a mayor</option>
                                <option value="price-high">Precio: mayor a menor</option>
                                <option value="experience">Más experiencia</option>
                            </select>
                        </div>
                    </div>

                    <div class="professionals-grid" id="professionalsGrid">
                        <!-- Profesional 1 -->
                        <div class="professional-card" onclick="viewProfile('maria-gonzalez')">
                            <div class="prof-avatar">MG</div>
                            <div class="prof-info">
                                <h3 class="prof-name">María González</h3>
                                <div class="prof-specialty">Desarrolladora Web Full Stack</div>
                                <div class="prof-rating">
                                    <span class="prof-rating-stars">★★★★★</span>
                                    <span class="prof-rating-text">5.0 (48 reseñas)</span>
                                </div>
                                <p class="prof-description">
                                    Especialista en desarrollo web con 8 años de experiencia. Experta en React, Node.js y diseño UI/UX. 
                                    He completado más de 200 proyectos exitosos.
                                </p>
                                <div class="prof-tags">
                                    <span class="tag">React</span>
                                    <span class="tag">Node.js</span>
                                    <span class="tag">UI/UX</span>
                                    <span class="tag">JavaScript</span>
                                </div>
                            </div>
                            <div class="prof-actions">
                                <div class="prof-price">
                                    <div class="price-label">Desde</div>
                                    <div class="price-value">$50/hr</div>
                                </div>
                                <button class="btn-contact-prof" onclick="event.stopPropagation(); contactProfessional('maria-gonzalez')">Contactar</button>
                                <button class="btn-view-profile" onclick="event.stopPropagation(); viewProfile('maria-gonzalez')">Ver Perfil</button>
                            </div>
                        </div>

                        <!-- Profesional 2 -->
                        <div class="professional-card" onclick="viewProfile('juan-perez')">
                            <div class="prof-avatar">JP</div>
                            <div class="prof-info">
                                <h3 class="prof-name">Dr. Juan Pérez</h3>
                                <div class="prof-specialty">Médico General</div>
                                <div class="prof-rating">
                                    <span class="prof-rating-stars">★★★★★</span>
                                    <span class="prof-rating-text">4.9 (63 reseñas)</span>
                                </div>
                                <p class="prof-description">
                                    Médico general con 15 años de experiencia. Especializado en medicina familiar y atención primaria. 
                                    Más de 500 consultas realizadas con excelentes resultados.
                                </p>
                                <div class="prof-tags">
                                    <span class="tag">Medicina General</span>
                                    <span class="tag">Pediatría</span>
                                    <span class="tag">Consulta Online</span>
                                </div>
                            </div>
                            <div class="prof-actions">
                                <div class="prof-price">
                                    <div class="price-label">Consulta</div>
                                    <div class="price-value">$35</div>
                                </div>
                                <button class="btn-contact-prof" onclick="event.stopPropagation(); contactProfessional('juan-perez')">Contactar</button>
                                <button class="btn-view-profile" onclick="event.stopPropagation(); viewProfile('juan-perez')">Ver Perfil</button>
                            </div>
                        </div>

                        <!-- Profesional 3 -->
                        <div class="professional-card" onclick="viewProfile('carlos-rodriguez')">
                            <div class="prof-avatar">CR</div>
                            <div class="prof-info">
                                <h3 class="prof-name">Carlos Rodríguez</h3>
                                <div class="prof-specialty">Profesor de Matemáticas</div>
                                <div class="prof-rating">
                                    <span class="prof-rating-stars">★★★★★</span>
                                    <span class="prof-rating-text">4.8 (92 reseñas)</span>
                                </div>
                                <p class="prof-description">
                                    Profesor de matemáticas con 12 años de experiencia. Especializado en cálculo diferencial, álgebra y 
                                    preparación para exámenes universitarios. Más de 1000 estudiantes satisfechos.
                                </p>
                                <div class="prof-tags">
                                    <span class="tag">Cálculo</span>
                                    <span class="tag">Álgebra</span>
                                    <span class="tag">Preparación Exámenes</span>
                                </div>
                            </div>
                            <div class="prof-actions">
                                <div class="prof-price">
                                    <div class="price-label">Por hora</div>
                                    <div class="price-value">$25/hr</div>
                                </div>
                                <button class="btn-contact-prof" onclick="event.stopPropagation(); contactProfessional('carlos-rodriguez')">Contactar</button>
                                <button class="btn-view-profile" onclick="event.stopPropagation(); viewProfile('carlos-rodriguez')">Ver Perfil</button>
                            </div>
                        </div>

                        <!-- Profesional 4 -->
                        <div class="professional-card" onclick="viewProfile('ana-martinez')">
                            <div class="prof-avatar">AM</div>
                            <div class="prof-info">
                                <h3 class="prof-name">Ana Martínez</h3>
                                <div class="prof-specialty">Diseñadora Gráfica</div>
                                <div class="prof-rating">
                                    <span class="prof-rating-stars">★★★★★</span>
                                    <span class="prof-rating-text">5.0 (37 reseñas)</span>
                                </div>
                                <p class="prof-description">
                                    Diseñadora gráfica especializada en branding e identidad corporativa. 6 años de experiencia creando 
                                    logos, material publicitario y diseño web. Portfolio con más de 150 proyectos.
                                </p>
                                <div class="prof-tags">
                                    <span class="tag">Branding</span>
                                    <span class="tag">Illustrator</span>
                                    <span class="tag">Photoshop</span>
                                    <span class="tag">Logo Design</span>
                                </div>
                            </div>
                            <div class="prof-actions">
                                <div class="prof-price">
                                    <div class="price-label">Desde</div>
                                    <div class="price-value">$200</div>
                                </div>
                                <button class="btn-contact-prof" onclick="event.stopPropagation(); contactProfessional('ana-martinez')">Contactar</button>
                                <button class="btn-view-profile" onclick="event.stopPropagation(); viewProfile('ana-martinez')">Ver Perfil</button>
                            </div>
                        </div>

                        <!-- Profesional 5 -->
                        <div class="professional-card" onclick="viewProfile('roberto-silva')">
                            <div class="prof-avatar">RS</div>
                            <div class="prof-info">
                                <h3 class="prof-name">Roberto Silva</h3>
                                <div class="prof-specialty">Abogado Corporativo</div>
                                <div class="prof-rating">
                                    <span class="prof-rating-stars">★★★★</span>
                                    <span class="prof-rating-text">4.7 (28 reseñas)</span>
                                </div>
                                <p class="prof-description">
                                    Abogado especializado en derecho corporativo y mercantil. 10 años de experiencia asesorando empresas 
                                    en constitución, contratos y resolución de conflictos comerciales.
                                </p>
                                <div class="prof-tags">
                                    <span class="tag">Derecho Corporativo</span>
                                    <span class="tag">Contratos</span>
                                    <span class="tag">Asesoría Legal</span>
                                </div>
                            </div>
                            <div class="prof-actions">
                                <div class="prof-price">
                                    <div class="price-label">Consulta</div>
                                    <div class="price-value">$80/hr</div>
                                </div>
                                <button class="btn-contact-prof" onclick="event.stopPropagation(); contactProfessional('roberto-silva')">Contactar</button>
                                <button class="btn-view-profile" onclick="event.stopPropagation(); viewProfile('roberto-silva')">Ver Perfil</button>
                            </div>
                        </div>
                    </div>

                    <div class="pagination">
                        <button class="page-btn">←</button>
                        <button class="page-btn active">1</button>
                        <button class="page-btn">2</button>
                        <button class="page-btn">3</button>
                        <button class="page-btn">4</button>
                        <button class="page-btn">5</button>
                        <button class="page-btn">→</button>
                    </div>
                </main>
            </div>
        </div>
        
         <!-- Footer -->
        <%@include  file="WEB-INF/jspf/footer.jspf" %>
        
        <!-- Script externo -->
        <script src="js/contentCliente.js"></script>
    </body>
</html>
