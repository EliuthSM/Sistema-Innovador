
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Comportamiento responsivo -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <%@include  file="WEB-INF/jspfCss/solicitudProfesionalCss.jspf" %>
        <%@include  file="WEB-INF/jspfCss/styles.jspf" %>
    </head>
    <body>
        
        <!-- Header -->
        <%@include  file="WEB-INF/jspf/header.jspf" %>
         <div class="main-container">
        <div class="dashboard-header">
            <div>
                <h1 class="page-title">Solicitudes Recibidas</h1>
                <p class="page-subtitle">Gestiona las solicitudes de tus clientes potenciales</p>
            </div>
        </div>

        <!-- Estadísticas -->
        <div class="stats-grid">
            <div class="stat-card">
                <div class="stat-icon">📬</div>
                <div class="stat-value">8</div>
                <div class="stat-label">Nuevas Solicitudes</div>
            </div>
            <div class="stat-card">
                <div class="stat-icon">👀</div>
                <div class="stat-value">3</div>
                <div class="stat-label">En Revisión</div>
            </div>
            <div class="stat-card">
                <div class="stat-icon">✅</div>
                <div class="stat-value">12</div>
                <div class="stat-label">Aceptadas</div>
            </div>
            <div class="stat-card">
                <div class="stat-icon">💰</div>
                <div class="stat-value">$4,850</div>
                <div class="stat-label">Potencial Este Mes</div>
            </div>
        </div>

        <!-- Tabs de Filtrado -->
        <div class="tabs">
            <button class="tab active" onclick="filterSolicitudes('todas')">Todas (23)</button>
            <button class="tab" onclick="filterSolicitudes('nueva')">
                Nuevas (8)<span class="badge-new">!</span>
            </button>
            <button class="tab" onclick="filterSolicitudes('revisando')">En Revisión (3)</button>
            <button class="tab" onclick="filterSolicitudes('aceptada')">Aceptadas (12)</button>
        </div>

        <!-- Grid de Solicitudes -->
        <div class="solicitudes-grid" id="solicitudes-list">
            <!-- Solicitud Nueva 1 -->
            <div class="solicitud-card nueva" data-estado="nueva">
                <div class="solicitud-header">
                    <div class="solicitud-info">
                        <div class="solicitud-numero">
                            #SOL-2024-156
                            <span class="nueva-badge">NUEVA</span>
                        </div>
                        <h3 class="solicitud-titulo">Desarrollo de App Móvil para Delivery</h3>
                        <span class="solicitud-categoria">Tecnología</span>
                    </div>
                    <span class="solicitud-estado estado-nueva">Nueva</span>
                </div>
                
                <div class="solicitud-body">
                    <p class="solicitud-descripcion">
                        Necesito desarrollar una aplicación móvil para iOS y Android que permita a los usuarios 
                        realizar pedidos de comida a domicilio. La app debe incluir: registro de usuarios, 
                        catálogo de productos, carrito de compras, seguimiento en tiempo real y pasarela de pagos.
                    </p>
                    
                    <div class="solicitud-detalles">
                        <div class="detalle-item">
                            <span class="detalle-icon">📅</span>
                            <span>Hace 2 horas</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">💰</span>
                            <span>$3,000 - $5,000</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">⏱️</span>
                            <span class="urgencia-alta">Urgencia: Alta</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">📍</span>
                            <span>Lima, Perú</span>
                        </div>
                    </div>
                </div>
                
                <div class="solicitud-footer">
                    <div class="cliente-info">
                        <div class="cliente-avatar">JD</div>
                        <div class="cliente-details">
                            <span class="cliente-nombre">Juan Díaz</span>
                            <span class="cliente-rating">⭐ 4.8 • 15 trabajos</span>
                        </div>
                    </div>
                    <div class="solicitud-actions">
                        <button class="btn btn-secondary btn-sm" onclick="verDetalle(1)">Ver Más</button>
                        <button class="btn btn-success btn-sm" onclick="aceptarSolicitud(this)">Aceptar</button>
                        <button class="btn btn-danger btn-sm" onclick="rechazarSolicitud(this)">Rechazar</button>
                    </div>
                </div>
            </div>

            <!-- Solicitud Nueva 2 -->
            <div class="solicitud-card nueva" data-estado="nueva">
                <div class="solicitud-header">
                    <div class="solicitud-info">
                        <div class="solicitud-numero">
                            #SOL-2024-155
                            <span class="nueva-badge">NUEVA</span>
                        </div>
                        <h3 class="solicitud-titulo">Consultoría SEO y Marketing Digital</h3>
                        <span class="solicitud-categoria">Marketing</span>
                    </div>
                    <span class="solicitud-estado estado-nueva">Nueva</span>
                </div>
                
                <div class="solicitud-body">
                    <p class="solicitud-descripcion">
                        Busco profesional en SEO para mejorar el posicionamiento de mi tienda online. 
                        Necesito auditoría completa, optimización on-page y off-page, y estrategia de contenidos 
                        para aumentar el tráfico orgánico en un 50% durante los próximos 3 meses.
                    </p>
                    
                    <div class="solicitud-detalles">
                        <div class="detalle-item">
                            <span class="detalle-icon">📅</span>
                            <span>Hace 5 horas</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">💰</span>
                            <span>$800 - $1,200/mes</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">⏱️</span>
                            <span class="urgencia-media">Urgencia: Media</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">📍</span>
                            <span>Remoto</span>
                        </div>
                    </div>
                </div>
                
                <div class="solicitud-footer">
                    <div class="cliente-info">
                        <div class="cliente-avatar">MP</div>
                        <div class="cliente-details">
                            <span class="cliente-nombre">María Pérez</span>
                            <span class="cliente-rating">⭐ 5.0 • 8 trabajos</span>
                        </div>
                    </div>
                    <div class="solicitud-actions">
                        <button class="btn btn-secondary btn-sm" onclick="verDetalle(2)">Ver Más</button>
                        <button class="btn btn-success btn-sm" onclick="aceptarSolicitud(this)">Aceptar</button>
                        <button class="btn btn-danger btn-sm" onclick="rechazarSolicitud(this)">Rechazar</button>
                    </div>
                </div>
            </div>

            <!-- Solicitud En Revisión -->
            <div class="solicitud-card" data-estado="revisando">
                <div class="solicitud-header">
                    <div class="solicitud-info">
                        <div class="solicitud-numero">#SOL-2024-150</div>
                        <h3 class="solicitud-titulo">Diseño de Identidad Corporativa Completa</h3>
                        <span class="solicitud-categoria">Diseño</span>
                    </div>
                    <span class="solicitud-estado estado-revisando">En Revisión</span>
                </div>
                
                <div class="solicitud-body">
                    <p class="solicitud-descripcion">
                        Startup tecnológica necesita identidad corporativa completa: logo, manual de marca, 
                        papelería, plantillas de redes sociales y diseño de presentación corporativa. 
                        Buscamos estilo moderno, minimalista y profesional.
                    </p>
                    
                    <div class="solicitud-detalles">
                        <div class="detalle-item">
                            <span class="detalle-icon">📅</span>
                            <span>Hace 1 día</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">💰</span>
                            <span>$1,500 - $2,000</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">⏱️</span>
                            <span class="urgencia-media">Urgencia: Media</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">👤</span>
                            <span>Propuesta enviada</span>
                        </div>
                    </div>
                </div>
                
                <div class="solicitud-footer">
                    <div class="cliente-info">
                        <div class="cliente-avatar">CA</div>
                        <div class="cliente-details">
                            <span class="cliente-nombre">Carlos Arias</span>
                            <span class="cliente-rating">⭐ 4.9 • 22 trabajos</span>
                        </div>
                    </div>
                    <div class="solicitud-actions">
                        <button class="btn btn-secondary btn-sm" onclick="verDetalle(3)">Ver Propuesta</button>
                        <button class="btn btn-primary btn-sm">Contactar</button>
                    </div>
                </div>
            </div>

            <!-- Solicitud Aceptada -->
            <div class="solicitud-card" data-estado="aceptada">
                <div class="solicitud-header">
                    <div class="solicitud-info">
                        <div class="solicitud-numero">#SOL-2024-145</div>
                        <h3 class="solicitud-titulo">Mantenimiento Web WordPress - 6 Meses</h3>
                        <span class="solicitud-categoria">Tecnología</span>
                    </div>
                    <span class="solicitud-estado estado-aceptada">Aceptada</span>
                </div>
                
                <div class="solicitud-body">
                    <p class="solicitud-descripcion">
                        Contrato de mantenimiento web por 6 meses: actualizaciones de WordPress y plugins, 
                        copias de seguridad semanales, optimización de velocidad, monitoreo de seguridad 
                        y soporte técnico prioritario.
                    </p>
                    
                    <div class="solicitud-detalles">
                        <div class="detalle-item">
                            <span class="detalle-icon">📅</span>
                            <span>Aceptada hace 3 días</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">💰</span>
                            <span>$400/mes</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">✅</span>
                            <span>Contrato firmado</span>
                        </div>
                        <div class="detalle-item">
                            <span class="detalle-icon">🚀</span>
                            <span>Inicio: 20/10/2024</span>
                        </div>
                    </div>
                </div>
                
                <div class="solicitud-footer">
                    <div class="cliente-info">
                        <div class="cliente-avatar">LG</div>
                        <div class="cliente-details">
                            <span class="cliente-nombre">Laura García</span>
                            <span class="cliente-rating">⭐ 5.0 • 12 trabajos</span>
                        </div>
                    </div>
                    <div class="solicitud-actions">
                        <button class="btn btn-primary btn-sm">Ir al Proyecto</button>
                        <button class="btn btn-secondary btn-sm">Contactar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Ver Detalle -->
    <div class="modal" id="modal-detalle">
        <div class="modal-content">
            <div class="modal-header">
                <h2>Detalle de Solicitud</h2>
                <p style="margin-top: 0.5rem; opacity: 0.9;">#SOL-2024-156</p>
            </div>
            <div class="modal-body">
                <div class="detalle-completo">
                    <h3>Título del Proyecto</h3>
                    <p>Desarrollo de App Móvil para Delivery</p>
                </div>

                <div class="detalle-completo">
                    <h3>Descripción Completa</h3>
                    <p>
                        Necesito desarrollar una aplicación móvil para iOS y Android que permita a los usuarios 
                        realizar pedidos de comida a domicilio. La app debe incluir: registro de usuarios, 
                        catálogo de productos, carrito de compras, seguimiento en tiempo real y pasarela de pagos.
                        <br><br>
                        Requisitos adicionales:
                        <br>- Diseño UI/UX profesional y atractivo
                        <br>- Integración con Google Maps para seguimiento
                        <br>- Sistema de notificaciones push
                        <br>- Panel administrativo web
                        <br>- Integración con MercadoPago y PayPal
                        <br>- Sistema de calificaciones y reseñas
                        <br>- Código limpio y documentado
                    </p>
                </div>

                <div class="info-adicional">
                    <div class="info-adicional-item">
                        <span class="info-label">Cliente:</span>
                        <span class="info-value">Juan Díaz</span>
                    </div>
                    <div class="info-adicional-item">
                        <span class="info-label">Categoría:</span>
                        <span class="info-value">Tecnología</span>
                    </div>
                    <div class="info-adicional-item">
                        <span class="info-label">Presupuesto:</span>
                        <span class="info-value">$3,000 - $5,000</span>
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
                        <span class="info-label">Fecha límite:</span>
                        <span class="info-value">30/11/2024</span>
                    </div>
                    <div class="info-adicional-item">
                        <span class="info-label">Recibida:</span>
                        <span class="info-value">Hace 2 horas</span>
                    </div>
                </div>

                <div class="detalle-completo" style="margin-top: 1.5rem;">
                    <h3>Sobre el Cliente</h3>
                    <p>
                        <strong>Calificación:</strong> ⭐ 4.8/5.0<br>
                        <strong>Proyectos completados:</strong> 15<br>
                        <strong>Tasa de respuesta:</strong> 95%<br>
                        <strong>Miembro desde:</strong> Enero 2023
                    </p>
                </div>

                <div class="form-group" style="margin-top: 1.5rem;">
                    <label for="propuesta">Enviar Propuesta (opcional)</label>
                    <textarea id="propuesta" placeholder="Escribe tu propuesta personalizada para este proyecto..."></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" onclick="closeModal()">Cerrar</button>
                <button class="btn btn-danger btn-sm" onclick="rechazarDesdeModal()">Rechazar</button>
                <button class="btn btn-success" onclick="aceptarDesdeModal()">Aceptar Solicitud</button>
            </div>
        </div>
    </div>

    <!-- Modal Confirmar Aceptación -->
    <div class="modal" id="modal-confirmar">
        <div class="modal-content" style="max-width: 500px;">
            <div class="modal-header">
                <h2>Confirmar Aceptación</h2>
            </div>
            <div class="modal-body">
                <p style="color: #555; line-height: 1.6;">
                    ¿Estás seguro de que deseas aceptar esta solicitud? 
                    <br><br>
                    Al aceptar, el cliente recibirá una notificación y podrá contactarte directamente 
                    para coordinar los detalles del proyecto.
                </p>
                
                <div class="form-group" style="margin-top: 1.5rem;">
                    <label for="mensaje-aceptacion">Mensaje para el cliente (opcional)</label>
                    <textarea id="mensaje-aceptacion" placeholder="Ej: Hola, me interesa mucho tu proyecto. Podemos coordinar una reunión para discutir los detalles..."></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" onclick="closeModalConfirmar()">Cancelar</button>
                <button class="btn btn-success" onclick="confirmarAceptacion()">Confirmar</button>
            </div>
        </div>
    </div>

    <script>
        let currentCard = null;
        let currentSolicitudId = null;

        function openModal() {
            document.getElementById('modal-detalle').classList.add('active');
        }

        function closeModal() {
            document.getElementById('modal-detalle').classList.remove('active');
        }

        function openModalConfirmar() {
            document.getElementById('modal-confirmar').classList.add('active');
        }

        function closeModalConfirmar() {
            document.getElementById('modal-confirmar').classList.remove('active');
        }

        function verDetalle(id) {
            currentSolicitudId = id;
            openModal();
        }

        function filterSolicitudes(estado) {
            const cards = document.querySelectorAll('.solicitud-card');
            const tabs = document.querySelectorAll('.tab');
            
            tabs.forEach(tab => tab.classList.remove('active'));
            event.target.classList.add('active');
            
            cards.forEach(card => {
                if (estado === 'todas') {
                    card.style.display = 'block';
                } else {
                    if (card.getAttribute('data-estado') === estado) {
                        card.style.display = 'block';
                    } else {
                        card.style.display = 'none';
                    }
                }
            });
        }

        function aceptarSolicitud(btn) {
            currentCard = btn.closest('.solicitud-card');
            closeModal();
            openModalConfirmar();
        }

        function aceptarDesdeModal() {
            closeModal();
            openModalConfirmar();
        }

        function confirmarAceptacion() {
            if (currentCard) {
                const estadoBadge = currentCard.querySelector('.solicitud-estado');
                const nuevaBadge = currentCard.querySelector('.nueva-badge');
                
                currentCard.setAttribute('data-estado', 'aceptada');
                currentCard.classList.remove('nueva');
                estadoBadge.className = 'solicitud-estado estado-aceptada';
                estadoBadge.textContent = 'Aceptada';
                
                if (nuevaBadge) {
                    nuevaBadge.remove();
                }
                
                const detalles = currentCard.querySelector('.solicitud-detalles');
                const items = detalles.querySelectorAll('.detalle-item');
                if (items.length >= 3) {
                    items[2].innerHTML = `
                        <span class="detalle-icon">✅</span>
                        <span>Aceptada ahora</span>
                    `;
                }
                
                const actions = currentCard.querySelector('.solicitud-actions');
                actions.innerHTML = `
                    <button class="btn btn-primary btn-sm">Ir al Proyecto</button>
                    <button class="btn btn-secondary btn-sm">Contactar</button>
                `;
                
                actualizarEstadisticas();
                closeModalConfirmar();
                
                // Notificación de éxito
                mostrarNotificacion('✅ Solicitud aceptada. El cliente ha sido notificado.', 'success');
            }
        }

        function rechazarSolicitud(btn) {
            if (confirm('¿Estás seguro de que deseas rechazar esta solicitud?')) {
                const card = btn.closest('.solicitud-card');
                card.style.opacity = '0.5';
                card.style.transform = 'scale(0.95)';
                
                setTimeout(() => {
                    card.remove();
                    actualizarEstadisticas();
                    mostrarNotificacion('Solicitud rechazada', 'info');
                }, 300);
            }
        }

        function rechazarDesdeModal() {
            if (confirm('¿Estás seguro de que deseas rechazar esta solicitud?')) {
                closeModal();
                mostrarNotificacion('Solicitud rechazada', 'info');
            }
        }

        function actualizarEstadisticas() {
            const cards = document.querySelectorAll('.solicitud-card');
            let contadores = {
                todas: 0,
                nueva: 0,
                revisando: 0,
                aceptada: 0
            };

            cards.forEach(card => {
                const estado = card.getAttribute('data-estado');
                contadores.todas++;
                if (estado in contadores) {
                    contadores[estado]++;
                }
            });

            // Actualizar tabs
            const tabs = document.querySelectorAll('.tab');
            tabs[0].innerHTML = `Todas (${contadores.todas})`;
            tabs[1].innerHTML = `Nuevas (${contadores.nueva})${contadores.nueva > 0 ? '<span class="badge-new">!</span>' : ''}`;
            tabs[2].innerHTML = `En Revisión (${contadores.revisando})`;
            tabs[3].innerHTML = `Aceptadas (${contadores.aceptada})`;

            // Actualizar cards de estadísticas
            const statCards = document.querySelectorAll('.stat-card');
            statCards[0].querySelector('.stat-value').textContent = contadores.nueva;
            statCards[1].querySelector('.stat-value').textContent = contadores.revisando;
            statCards[2].querySelector('.stat-value').textContent = contadores.aceptada;
        }

        function mostrarNotificacion(mensaje, tipo) {
            // Crear elemento de notificación
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
                animation: slideIn 0.3s ease;
            `;
            notif.textContent = mensaje;
            
            document.body.appendChild(notif);
            
            setTimeout(() => {
                notif.style.animation = 'slideOut 0.3s ease';
                setTimeout(() => notif.remove(), 300);
            }, 3000);
        }

        // Cerrar modales al hacer clic fuera
        window.onclick = function(event) {
            const modalDetalle = document.getElementById('modal-detalle');
            const modalConfirmar = document.getElementById('modal-confirmar');
            
            if (event.target === modalDetalle) {
                closeModal();
            }
            if (event.target === modalConfirmar) {
                closeModalConfirmar();
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

        // Inicializar
        document.addEventListener('DOMContentLoaded', actualizarEstadisticas);
    </script>
        <%@include  file="WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
