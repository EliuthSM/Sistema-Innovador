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
        <%@include  file="WEB-INF/jspfCss/contentProfesionalCss.jspf" %>
        <%@include  file="WEB-INF/jspfCss/styles.jspf" %>
    </head>
    <body>
        <!-- Header -->
        <%@include  file="WEB-INF/jspf/header.jspf" %>
        <div class="main-container">
        <div class="page-header">
            <h1 class="page-title">Explorar Solicitudes</h1>
            <p class="page-subtitle">Encuentra proyectos que coincidan con tus habilidades y envía tu propuesta</p>
        </div>

        <!-- Sección de Filtros -->
        <div class="filters-section">
            <div class="filters-grid">
                <div class="filter-group">
                    <label>Categoría</label>
                    <select id="filter-categoria">
                        <option value="">Todas las categorías</option>
                        <option value="tecnologia">Tecnología</option>
                        <option value="diseno">Diseño</option>
                        <option value="marketing">Marketing</option>
                        <option value="salud">Salud</option>
                        <option value="educacion">Educación</option>
                        <option value="legal">Legal</option>
                        <option value="hogar">Hogar</option>
                        <option value="otros">Otros</option>
                    </select>
                </div>
                
                <div class="filter-group">
                    <label>Presupuesto</label>
                    <select id="filter-presupuesto">
                        <option value="">Cualquier presupuesto</option>
                        <option value="0-500">$0 - $500</option>
                        <option value="500-1000">$500 - $1,000</option>
                        <option value="1000-2500">$1,000 - $2,500</option>
                        <option value="2500-5000">$2,500 - $5,000</option>
                        <option value="5000+">$5,000+</option>
                    </select>
                </div>
                
                <div class="filter-group">
                    <label>Urgencia</label>
                    <select id="filter-urgencia">
                        <option value="">Todas</option>
                        <option value="alta">Alta</option>
                        <option value="media">Media</option>
                        <option value="baja">Baja</option>
                    </select>
                </div>
                
                <div class="filter-group">
                    <label>Buscar por palabra clave</label>
                    <input type="text" id="filter-keyword" placeholder="Ej: desarrollo, diseño...">
                </div>
            </div>
            
            <div class="filter-actions">
                <button class="btn btn-primary" onclick="aplicarFiltros()">Aplicar Filtros</button>
                <button class="btn btn-secondary" onclick="limpiarFiltros()">Limpiar</button>
            </div>
        </div>

        <!-- Resultados -->
        <div class="results-header">
            <div class="results-count">
                Mostrando <strong id="count-results">24</strong> solicitudes disponibles
            </div>
            <select class="sort-select" onchange="ordenarSolicitudes(this.value)">
                <option value="reciente">Más recientes</option>
                <option value="presupuesto-alto">Mayor presupuesto</option>
                <option value="presupuesto-bajo">Menor presupuesto</option>
                <option value="urgente">Más urgentes</option>
            </select>
        </div>

        <!-- Grid de Solicitudes -->
        <div class="solicitudes-grid" id="solicitudes-list">
            <!-- Solicitud 1 - Nueva y Urgente -->
            <div class="solicitud-card" data-categoria="tecnologia" data-presupuesto="4000" data-urgencia="alta">
                <div class="solicitud-badges">
                    <span class="badge badge-nueva">NUEVA</span>
                    <span class="badge badge-urgente">URGENTE</span>
                </div>
                
                <div class="solicitud-header">
                    <div class="solicitud-info">
                        <div class="solicitud-numero">#SOL-2024-187</div>
                        <h3 class="solicitud-titulo">Desarrollo de Plataforma E-learning</h3>
                        <span class="solicitud-categoria">Tecnología</span>
                    </div>
                    <div class="solicitud-presupuesto">
                        💰 $3,500 - $5,000
                    </div>
                </div>
                
                <div class="solicitud-body">
                    <p class="solicitud-descripcion">
                        Necesito desarrollar una plataforma de e-learning completa con sistema de cursos en video,
                        evaluaciones, certificados digitales, panel de administración y pasarela de pagos.
                        La plataforma debe ser responsive y con diseño moderno.
                    </p>
                    
                    <div class="solicitud-detalles">
                        <div class="detalle-item">
                            <span class="detalle-icon">📅</span>
                            <span>Publicada hace 1 hora</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">⏱️</span>
                            <span class="urgencia-alta">Urgencia: Alta</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">📍</span>
                            <span>Lima, Perú</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">🎯</span>
                            <span>Plazo: 2 meses</span>
                        </div>
                    </div>
                </div>
                
                <div class="solicitud-footer">
                    <div class="cliente-info">
                        <div class="cliente-avatar">RC</div>
                        <div class="cliente-details">
                            <span class="cliente-nombre">Ricardo Castro</span>
                            <span class="cliente-rating">⭐ 4.9 • 18 proyectos</span>
                        </div>
                    </div>
                    <div class="solicitud-actions">
                        <div class="propuestas-count">
                            📨 2 propuestas
                        </div>
                        <button class="btn btn-secondary btn-sm" onclick="verDetalleSolicitud(1)">Ver Detalles</button>
                        <button class="btn btn-success btn-sm" onclick="enviarPropuesta(1)">Enviar Propuesta</button>
                    </div>
                </div>
            </div>

            <!-- Solicitud 2 - Premium -->
            <div class="solicitud-card" data-categoria="diseno" data-presupuesto="2000" data-urgencia="media">
                <div class="solicitud-badges">
                    <span class="badge badge-premium">CLIENTE PREMIUM</span>
                </div>
                
                <div class="solicitud-header">
                    <div class="solicitud-info">
                        <div class="solicitud-numero">#SOL-2024-186</div>
                        <h3 class="solicitud-titulo">Rediseño Completo de Marca Corporativa</h3>
                        <span class="solicitud-categoria">Diseño</span>
                    </div>
                    <div class="solicitud-presupuesto">
                        💰 $1,500 - $2,500
                    </div>
                </div>
                
                <div class="solicitud-body">
                    <p class="solicitud-descripcion">
                        Empresa de consultoría busca rediseño completo de identidad corporativa.
                        Incluye: nuevo logo, manual de marca, papelería corporativa, diseño de presentaciones,
                        plantillas para redes sociales y material promocional.
                    </p>
                    
                    <div class="solicitud-detalles">
                        <div class="detalle-item">
                            <span class="detalle-icon">📅</span>
                            <span>Publicada hace 3 horas</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">⏱️</span>
                            <span class="urgencia-media">Urgencia: Media</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">📍</span>
                            <span>Arequipa, Perú</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">🎯</span>
                            <span>Plazo: 6 semanas</span>
                        </div>
                    </div>
                </div>
                
                <div class="solicitud-footer">
                    <div class="cliente-info">
                        <div class="cliente-avatar">MV</div>
                        <div class="cliente-details">
                            <span class="cliente-nombre">María Vega</span>
                            <span class="cliente-rating">⭐ 5.0 • 25 proyectos</span>
                        </div>
                    </div>
                    <div class="solicitud-actions">
                        <div class="propuestas-count">
                            📨 5 propuestas
                        </div>
                        <button class="btn btn-secondary btn-sm" onclick="verDetalleSolicitud(2)">Ver Detalles</button>
                        <button class="btn btn-success btn-sm" onclick="enviarPropuesta(2)">Enviar Propuesta</button>
                    </div>
                </div>
            </div>

            <!-- Solicitud 3 -->
            <div class="solicitud-card" data-categoria="marketing" data-presupuesto="1000" data-urgencia="media">
                <div class="solicitud-header">
                    <div class="solicitud-info">
                        <div class="solicitud-numero">#SOL-2024-185</div>
                        <h3 class="solicitud-titulo">Estrategia de Marketing Digital - 3 Meses</h3>
                        <span class="solicitud-categoria">Marketing</span>
                    </div>
                    <div class="solicitud-presupuesto">
                        💰 $900 - $1,200/mes
                    </div>
                </div>
                
                <div class="solicitud-body">
                    <p class="solicitud-descripcion">
                        Startup tecnológica busca experto en marketing digital para desarrollar estrategia completa.
                        Incluye: gestión de redes sociales, SEO, Google Ads, email marketing y análisis de métricas.
                        Contrato por 3 meses renovable.
                    </p>
                    
                    <div class="solicitud-detalles">
                        <div class="detalle-item">
                            <span class="detalle-icon">📅</span>
                            <span>Publicada hace 5 horas</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">⏱️</span>
                            <span class="urgencia-media">Urgencia: Media</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">📍</span>
                            <span>Remoto</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">🎯</span>
                            <span>Inicio: Inmediato</span>
                        </div>
                    </div>
                </div>
                
                <div class="solicitud-footer">
                    <div class="cliente-info">
                        <div class="cliente-avatar">PL</div>
                        <div class="cliente-details">
                            <span class="cliente-nombre">Pedro López</span>
                            <span class="cliente-rating">⭐ 4.7 • 12 proyectos</span>
                        </div>
                    </div>
                    <div class="solicitud-actions">
                        <div class="propuestas-count">
                            📨 8 propuestas
                        </div>
                        <button class="btn btn-secondary btn-sm" onclick="verDetalleSolicitud(3)">Ver Detalles</button>
                        <button class="btn btn-success btn-sm" onclick="enviarPropuesta(3)">Enviar Propuesta</button>
                    </div>
                </div>
            </div>

            <!-- Solicitud 4 -->
            <div class="solicitud-card" data-categoria="tecnologia" data-presupuesto="800" data-urgencia="baja">
                <div class="solicitud-header">
                    <div class="solicitud-info">
                        <div class="solicitud-numero">#SOL-2024-184</div>
                        <h3 class="solicitud-titulo">Optimización y Mantenimiento Web WordPress</h3>
                        <span class="solicitud-categoria">Tecnología</span>
                    </div>
                    <div class="solicitud-presupuesto">
                        💰 $600 - $900
                    </div>
                </div>
                
                <div class="solicitud-body">
                    <p class="solicitud-descripcion">
                        Sitio web WordPress necesita optimización completa: mejorar velocidad de carga,
                        actualizar plugins, reforzar seguridad, optimizar SEO técnico y configurar backups automáticos.
                        Incluye 3 meses de soporte post-optimización.
                    </p>
                    
                    <div class="solicitud-detalles">
                        <div class="detalle-item">
                            <span class="detalle-icon">📅</span>
                            <span>Publicada hace 8 horas</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">⏱️</span>
                            <span class="urgencia-baja">Urgencia: Baja</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">📍</span>
                            <span>Cusco, Perú</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">🎯</span>
                            <span>Plazo: Flexible</span>
                        </div>
                    </div>
                </div>
                
                <div class="solicitud-footer">
                    <div class="cliente-info">
                        <div class="cliente-avatar">JS</div>
                        <div class="cliente-details">
                            <span class="cliente-nombre">Julia Sánchez</span>
                            <span class="cliente-rating">⭐ 4.8 • 9 proyectos</span>
                        </div>
                    </div>
                    <div class="solicitud-actions">
                        <div class="propuestas-count">
                            📨 4 propuestas
                        </div>
                        <button class="btn btn-secondary btn-sm" onclick="verDetalleSolicitud(4)">Ver Detalles</button>
                        <button class="btn btn-success btn-sm" onclick="enviarPropuesta(4)">Enviar Propuesta</button>
                    </div>
                </div>
            </div>

            <!-- Solicitud 5 -->
            <div class="solicitud-card" data-categoria="educacion" data-presupuesto="400" data-urgencia="alta">
                <div class="solicitud-badges">
                    <span class="badge badge-urgente">URGENTE</span>
                </div>
                
                <div class="solicitud-header">
                    <div class="solicitud-info">
                        <div class="solicitud-numero">#SOL-2024-183</div>
                        <h3 class="solicitud-titulo">Clases Particulares de Programación Python</h3>
                        <span class="solicitud-categoria">Educación</span>
                    </div>
                    <div class="solicitud-presupuesto">
                        💰 $30/hora
                    </div>
                </div>
                
                <div class="solicitud-body">
                    <p class="solicitud-descripcion">
                        Estudiante universitario necesita clases particulares intensivas de Python.
                        Temas: fundamentos, POO, manejo de datos con Pandas, visualización con Matplotlib
                        y proyecto final. 2-3 clases semanales por 4 semanas.
                    </p>
                    
                    <div class="solicitud-detalles">
                        <div class="detalle-item">
                            <span class="detalle-icon">📅</span>
                            <span>Publicada hace 12 horas</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">⏱️</span>
                            <span class="urgencia-alta">Urgencia: Alta</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">📍</span>
                            <span>Online</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">🎯</span>
                            <span>12 clases aprox.</span>
                        </div>
                    </div>
                </div>
                
                <div class="solicitud-footer">
                    <div class="cliente-info">
                        <div class="cliente-avatar">DR</div>
                        <div class="cliente-details">
                            <span class="cliente-nombre">Diego Ramos</span>
                            <span class="cliente-rating">⭐ 5.0 • 6 proyectos</span>
                        </div>
                    </div>
                    <div class="solicitud-actions">
                        <div class="propuestas-count">
                            📨 11 propuestas
                        </div>
                        <button class="btn btn-secondary btn-sm" onclick="verDetalleSolicitud(5)">Ver Detalles</button>
                        <button class="btn btn-success btn-sm" onclick="enviarPropuesta(5)">Enviar Propuesta</button>
                    </div>
                </div>
            </div>

            <!-- Solicitud 6 -->
            <div class="solicitud-card" data-categoria="legal" data-presupuesto="500" data-urgencia="media">
                <div class="solicitud-header">
                    <div class="solicitud-info">
                        <div class="solicitud-numero">#SOL-2024-182</div>
                        <h3 class="solicitud-titulo">Asesoría Legal para Constitución de Empresa</h3>
                        <span class="solicitud-categoria">Legal</span>
                    </div>
                    <div class="solicitud-presupuesto">
                        💰 $400 - $600
                    </div>
                </div>
                
                <div class="solicitud-body">
                    <p class="solicitud-descripcion">
                        Necesito asesoría legal completa para constituir una SRL. Incluye: elaboración de estatutos,
                        minuta, trámites en Sunarp, inscripción en SUNAT y asesoría sobre régimen tributario más conveniente.
                    </p>
                    
                    <div class="solicitud-detalles">
                        <div class="detalle-item">
                            <span class="detalle-icon">📅</span>
                            <span>Publicada hace 1 día</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">⏱️</span>
                            <span class="urgencia-media">Urgencia: Media</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">📍</span>
                            <span>Lima, Perú</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">🎯</span>
                            <span>Plazo: 3 semanas</span>
                        </div>
                    </div>
                </div>
                
                <div class="solicitud-footer">
                    <div class="cliente-info">
                        <div class="cliente-avatar">AF</div>
                        <div class="cliente-details">
                            <span class="cliente-nombre">Andrea Flores</span>
                            <span class="cliente-rating">⭐ 4.9 • 4 proyectos</span>
                        </div>
                    </div>
                    <div class="solicitud-actions">
                        <div class="propuestas-count">
                            📨 6 propuestas
                        </div>
                        <button class="btn btn-secondary btn-sm" onclick="verDetalleSolicitud(6)">Ver Detalles</button>
                        <button class="btn btn-success btn-sm" onclick="enviarPropuesta(6)">Enviar Propuesta</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Ver Detalle -->
    <div class="modal" id="modal-detalle">
        <div class="modal-content">
            <div class="modal-header">
                <h2 id="modal-titulo">Desarrollo de Plataforma E-learning</h2>
                <p style="margin-top: 0.5rem; opacity: 0.9;">#SOL-2024-187</p>
            </div>
            <div class="modal-body">
                <div class="detalle-completo">
                    <h3>Descripción del Proyecto</h3>
                    <p id="modal-descripcion">
                        Necesito desarrollar una plataforma de e-learning completa con sistema de cursos en video,
                        evaluaciones, certificados digitales, panel de administración y pasarela de pagos.
                        La plataforma debe ser responsive y con diseño moderno.
                        <br><br>
                        <strong>Requisitos técnicos:</strong>
                        <br>- Frontend: React o Vue.js
                        <br>- Backend: Node.js o Laravel
                        <br>- Base de datos: MySQL o PostgreSQL
                        <br>- Hosting en AWS o similar
                        <br>- Integración con Vimeo o similar para videos
                        <br>- Sistema de pagos con Stripe/PayPal
                        <br>- Panel administrativo completo
                        <br>- Diseño UI/UX profesional
                        <br>- Documentación técnica
                    </p>
                </div>

                <div class="info-adicional">
                    <div class="info-adicional-item">
                        <span class="info-label">Cliente:</span>
                        <span class="info-value">Ricardo Castro</span>
                    </div>
                    <div class="info-adicional-item">
                        <span class="info-label">Rating del cliente:</span>
                        <span class="info-value">⭐ 4.9/5.0 (18 proyectos)</span>
                    </div>
                    <div class="info-adicional-item">
                        <span class="info-label">Categoría:</span>
                        <span class="info-value">Tecnología</span>
                    </div>
                    <div class="info-adicional-item">
                        <span class="info-label">Presupuesto:</span>
                        <span class="info-value">$3,500 - $5,000</span>
                    </div>
                    <div class="info-adicional-item">
                        <span class="info-label">Urgencia:</span>
                        <span class="info-value" style="color: #dc3545; font-weight: bold;">Alta</span>
                    </div>
                    <div class="info-adicional-item">
                        <span class="info-label">Ubicación:</span>
                        <span class="info-value">Lima, Perú</span>
                    </div>
                    <div class="info-adicional-item">
                        <span class="info-label">Plazo de entrega:</span>
                        <span class="info-value">2 meses</span>
                    </div>
                    <div class="info-adicional-item">
                        <span class="info-label">Fecha límite propuestas:</span>
                        <span class="info-value">20/10/2024</span>
                    </div>
                    <div class="info-adicional-item">
                        <span class="info-label">Propuestas recibidas:</span>
                        <span class="info-value">2 profesionales interesados</span>
                    </div>
                </div>

                <div class="detalle-completo" style="margin-top: 1.5rem;">
                    <h3>Habilidades Requeridas</h3>
                    <p>
                        <span class="solicitud-categoria" style="margin-right: 0.5rem;">React.js</span>
                        <span class="solicitud-categoria" style="margin-right: 0.5rem;">Node.js</span>
                        <span class="solicitud-categoria" style="margin-right: 0.5rem;">MySQL</span>
                        <span class="solicitud-categoria" style="margin-right: 0.5rem;">UI/UX</span>
                        <span class="solicitud-categoria" style="margin-right: 0.5rem;">AWS</span>
                    </p>
                </div>
            </div>
            <div class="modal-footer">
                <div class="propuesta-info">
                    💡 Tip: Personaliza tu propuesta para destacar
                </div>
                <div style="display: flex; gap: 1rem;">
                    <button class="btn btn-secondary" onclick="closeModal()">Cerrar</button>
                    <button class="btn btn-success" onclick="abrirModalPropuesta()">Enviar Propuesta</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Enviar Propuesta -->
    <div class="modal" id="modal-propuesta">
        <div class="modal-content">
            <div class="modal-header">
                <h2>Enviar Propuesta</h2>
                <p style="margin-top: 0.5rem; opacity: 0.9;">Describe por qué eres el profesional ideal para este proyecto</p>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="propuesta-monto">Tu Presupuesto ($)</label>
                    <input type="number" id="propuesta-monto" placeholder="Ej: 4000" style="width: 100%; padding: 0.75rem; border: 2px solid #e0e0e0; border-radius: 10px;">
                </div>

                <div class="form-group">
                    <label for="propuesta-tiempo">Tiempo de Entrega (días)</label>
                    <input type="number" id="propuesta-tiempo" placeholder="Ej: 45" style="width: 100%; padding: 0.75rem; border: 2px solid #e0e0e0; border-radius: 10px;">
                </div>

                <div class="form-group">
                    <label for="propuesta-mensaje">Tu Propuesta *</label>
                    <textarea id="propuesta-mensaje" placeholder="Explica tu experiencia relevante, metodología de trabajo y por qué eres la mejor opción para este proyecto..." style="min-height: 180px;"></textarea>
                    <small style="color: #666; display: block; margin-top: 0.5rem;">
                        📝 Incluye: experiencia previa, enfoque del proyecto, tecnologías a usar
                    </small>
                </div>

                <div class="form-group">
                    <label>
                        <input type="checkbox" id="terminos-propuesta" style="width: auto; margin-right: 0.5rem;">
                        Acepto los términos y condiciones de ProfiNet
                    </label>
                </div>
            </div>
            <div class="modal-footer">
                <div class="propuesta-info">
                    ⚡ El cliente suele responder en 24-48 horas
                </div>
                <div style="display: flex; gap: 1rem;">
                    <button class="btn btn-secondary" onclick="closeModalPropuesta()">Cancelar</button>
                    <button class="btn btn-success" onclick="enviarPropuestaFinal()">Enviar Propuesta</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        let solicitudActual = null;

        function aplicarFiltros() {
            const categoria = document.getElementById('filter-categoria').value;
            const presupuesto = document.getElementById('filter-presupuesto').value;
            const urgencia = document.getElementById('filter-urgencia').value;
            const keyword = document.getElementById('filter-keyword').value.toLowerCase();

            const cards = document.querySelectorAll('.solicitud-card');
            let visibleCount = 0;

            cards.forEach(card => {
                let visible = true;

                // Filtro por categoría
                if (categoria && card.getAttribute('data-categoria') !== categoria) {
                    visible = false;
                }

                // Filtro por urgencia
                if (urgencia && card.getAttribute('data-urgencia') !== urgencia) {
                    visible = false;
                }

                // Filtro por palabra clave
                if (keyword) {
                    const titulo = card.querySelector('.solicitud-titulo').textContent.toLowerCase();
                    const descripcion = card.querySelector('.solicitud-descripcion').textContent.toLowerCase();
                    if (!titulo.includes(keyword) && !descripcion.includes(keyword)) {
                        visible = false;
                    }
                }

                card.style.display = visible ? 'block' : 'none';
                if (visible) visibleCount++;
            });

            document.getElementById('count-results').textContent = visibleCount;
            
            if (visibleCount === 0) {
                mostrarEstadoVacio();
            } else {
                eliminarEstadoVacio();
            }
        }

        function limpiarFiltros() {
            document.getElementById('filter-categoria').value = '';
            document.getElementById('filter-presupuesto').value = '';
            document.getElementById('filter-urgencia').value = '';
            document.getElementById('filter-keyword').value = '';
            
            const cards = document.querySelectorAll('.solicitud-card');
            cards.forEach(card => card.style.display = 'block');
            
            document.getElementById('count-results').textContent = cards.length;
            eliminarEstadoVacio();
        }

        function ordenarSolicitudes(criterio) {
            const grid = document.getElementById('solicitudes-list');
            const cards = Array.from(document.querySelectorAll('.solicitud-card'));

            cards.sort((a, b) => {
                if (criterio === 'presupuesto-alto') {
                    return parseInt(b.getAttribute('data-presupuesto')) - parseInt(a.getAttribute('data-presupuesto'));
                } else if (criterio === 'presupuesto-bajo') {
                    return parseInt(a.getAttribute('data-presupuesto')) - parseInt(b.getAttribute('data-presupuesto'));
                }
                return 0;
            });

            grid.innerHTML = '';
            cards.forEach(card => grid.appendChild(card));
        }

        function verDetalleSolicitud(id) {
            solicitudActual = id;
            document.getElementById('modal-detalle').classList.add('active');
        }

        function closeModal() {
            document.getElementById('modal-detalle').classList.remove('active');
        }

        function abrirModalPropuesta() {
            closeModal();
            document.getElementById('modal-propuesta').classList.add('active');
        }

        function closeModalPropuesta() {
            document.getElementById('modal-propuesta').classList.remove('active');
            document.getElementById('propuesta-monto').value = '';
            document.getElementById('propuesta-tiempo').value = '';
            document.getElementById('propuesta-mensaje').value = '';
            document.getElementById('terminos-propuesta').checked = false;
        }

        function enviarPropuesta(id) {
            solicitudActual = id;
            document.getElementById('modal-propuesta').classList.add('active');
        }

        function enviarPropuestaFinal() {
            const monto = document.getElementById('propuesta-monto').value;
            const tiempo = document.getElementById('propuesta-tiempo').value;
            const mensaje = document.getElementById('propuesta-mensaje').value;
            const terminos = document.getElementById('terminos-propuesta').checked;

            if (!monto || !tiempo || !mensaje) {
                alert('⚠️ Por favor completa todos los campos requeridos');
                return;
            }

            if (!terminos) {
                alert('⚠️ Debes aceptar los términos y condiciones');
                return;
            }

            closeModalPropuesta();
            
            // Notificación de éxito
            mostrarNotificacion('✅ Propuesta enviada exitosamente. El cliente la recibirá y podrá contactarte.', 'success');
            
            // Redirigir a "Mis Propuestas" después de 2 segundos
            setTimeout(() => {
                mostrarNotificacion('📨 Puedes ver el estado de tu propuesta en "Mis Propuestas"', 'info');
            }, 2000);
        }

        function mostrarNotificacion(mensaje, tipo) {
            const notif = document.createElement('div');
            notif.style.cssText = `
                position: fixed;
                top: 20px;
                right: 20px;
                color: white;
                padding: 1rem 1.5rem;
                border-radius: 10px;
                box-shadow: 0 5px 20px rgba(0,0,0,0.3);
                z-index: 3000;
                max-width: 400px;
                animation: slideIn 0.3s ease;
            `;
            notif.textContent = mensaje;
            
            document.body.appendChild(notif);
            
            setTimeout(() => {
                notif.style.animation = 'slideOut 0.3s ease';
                setTimeout(() => notif.remove(), 300);
            }, 4000);
        }

        function mostrarEstadoVacio() {
            eliminarEstadoVacio();
            const grid = document.getElementById('solicitudes-list');
            const empty = document.createElement('div');
            empty.className = 'empty-state';
            empty.id = 'empty-state';
            empty.innerHTML = `
                <div class="empty-icon">🔍</div>
                <h3 class="empty-title">No se encontraron solicitudes</h3>
                <p class="empty-text">Intenta ajustar los filtros para ver más resultados</p>
                <button class="btn btn-primary" onclick="limpiarFiltros()">Limpiar Filtros</button>
            `;
            grid.appendChild(empty);
        }

        function eliminarEstadoVacio() {
            const empty = document.getElementById('empty-state');
            if (empty) empty.remove();
        }

        // Cerrar modales al hacer clic fuera
        window.onclick = function(event) {
            const modalDetalle = document.getElementById('modal-detalle');
            const modalPropuesta = document.getElementById('modal-propuesta');
            
            if (event.target === modalDetalle) {
                closeModal();
            }
            if (event.target === modalPropuesta) {
                closeModalPropuesta();
            }
        }

        // Animaciones CSS
        const style = document.createElement('style');
        style.textContent = `
            @keyframes slideIn {
                from {
                    transform: translateX(400px);
                    opacity: 0;
                }
                to {
                    transform: translateX(0);
                    opacity: 1;
                }
            }
            
            @keyframes slideOut {
                from {
                    transform: translateX(0);
                    opacity: 1;
                }
                to {
                    transform: translateX(400px);
                    opacity: 0;
                }
            }
        `;
        document.head.appendChild(style);
    </script>
        <%@include  file="WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
