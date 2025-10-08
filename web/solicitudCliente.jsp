
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Comportamiento responsivo -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <%@include  file="WEB-INF/jspfCss/solicitudClienteCss.jspf" %>
        <%@include  file="WEB-INF/jspfCss/styles.jspf" %>
    </head>
    <body>
        
        <!-- Header -->
        <%@include  file="WEB-INF/jspf/header.jspf" %>
        <div class="main-container">
            <div class="page-header">
                <h1 class="page-title">Mis Solicitudes</h1>
                <button class="btn btn-primary" onclick="openModal()">+ Nueva Solicitud</button>
            </div>

            <div class="tabs">
                <button class="tab active" onclick="filterSolicitudes('todas')">Todas (5)</button>
                <button class="tab" onclick="filterSolicitudes('pendiente')">Pendientes (2)</button>
                <button class="tab" onclick="filterSolicitudes('proceso')">En Proceso (1)</button>
                <button class="tab" onclick="filterSolicitudes('completado')">Completadas (1)</button>
                <button class="tab" onclick="filterSolicitudes('cancelado')">Canceladas (1)</button>
            </div>

            <div class="solicitudes-grid" id="solicitudes-list">
                <!-- Solicitud Pendiente 1 -->
                <div class="solicitud-card" data-estado="pendiente">
                    <div class="solicitud-header">
                        <div class="solicitud-info">
                            <div class="solicitud-numero">#SOL-2024-001</div>
                            <h3 class="solicitud-titulo">Desarrollo de Sitio Web E-commerce</h3>
                            <span class="solicitud-categoria">Tecnología</span>
                        </div>
                        <span class="solicitud-estado estado-pendiente">Pendiente</span>
                    </div>

                    <div class="solicitud-body">
                        <p class="solicitud-descripcion">
                            Necesito desarrollar un sitio web de e-commerce para mi tienda de ropa. 
                            Debe incluir catálogo de productos, carrito de compras, pasarela de pagos y panel de administración.
                        </p>

                        <div class="solicitud-detalles">
                            <div class="detalle-item">
                                <span class="detalle-icon">📅</span>
                                <span>Fecha: 15/10/2024</span>
                            </div>
                            <div class="detalle-item">
                                <span class="detalle-icon">💰</span>
                                <span>Presupuesto: $1,500 - $2,500</span>
                            </div>
                            <div class="detalle-item">
                                <span class="detalle-icon">⏱️</span>
                                <span>Urgencia: Media</span>
                            </div>
                        </div>
                    </div>

                    <div class="solicitud-footer">
                        <div class="solicitud-profesional">
                            <span style="color: #666;">Esperando respuestas...</span>
                        </div>
                        <div class="solicitud-actions">
                            <button class="btn btn-secondary btn-sm">Ver Detalles</button>
                            <button class="btn btn-danger btn-sm" onclick="cancelarSolicitud(this)">Cancelar</button>
                        </div>
                    </div>
                </div>

                <!-- Solicitud En Proceso -->
                <div class="solicitud-card" data-estado="proceso">
                    <div class="solicitud-header">
                        <div class="solicitud-info">
                            <div class="solicitud-numero">#SOL-2024-002</div>
                            <h3 class="solicitud-titulo">Consulta Médica - Dolor de Espalda</h3>
                            <span class="solicitud-categoria">Salud</span>
                        </div>
                        <span class="solicitud-estado estado-proceso">En Proceso</span>
                    </div>

                    <div class="solicitud-body">
                        <p class="solicitud-descripcion">
                            Necesito consulta médica por dolor persistente en la espalda baja. 
                            El dolor ha estado presente por más de 2 semanas y afecta mis actividades diarias.
                        </p>

                        <div class="solicitud-detalles">
                            <div class="detalle-item">
                                <span class="detalle-icon">📅</span>
                                <span>Fecha: 14/10/2024</span>
                            </div>
                            <div class="detalle-item">
                                <span class="detalle-icon">💰</span>
                                <span>Presupuesto: $50 - $100</span>
                            </div>
                            <div class="detalle-item">
                                <span class="detalle-icon">⏱️</span>
                                <span>Urgencia: Alta</span>
                            </div>
                        </div>
                    </div>

                    <div class="solicitud-footer">
                        <div class="solicitud-profesional">
                            <div class="prof-avatar">DR</div>
                            <div class="prof-info">
                                <span class="prof-nombre">Dr. Roberto Méndez</span>
                                <span class="prof-especialidad">Traumatología</span>
                            </div>
                        </div>
                        <div class="solicitud-actions">
                            <button class="btn btn-primary btn-sm">Contactar</button>
                            <button class="btn btn-success btn-sm" onclick="completarSolicitud(this)">Completar</button>
                        </div>
                    </div>
                </div>

                <!-- Solicitud Pendiente 2 -->
                <div class="solicitud-card" data-estado="pendiente">
                    <div class="solicitud-header">
                        <div class="solicitud-info">
                            <div class="solicitud-numero">#SOL-2024-003</div>
                            <h3 class="solicitud-titulo">Clases de Matemáticas - Cálculo Diferencial</h3>
                            <span class="solicitud-categoria">Educación</span>
                        </div>
                        <span class="solicitud-estado estado-pendiente">Pendiente</span>
                    </div>

                    <div class="solicitud-body">
                        <p class="solicitud-descripcion">
                            Busco profesor particular para clases de cálculo diferencial. 
                            Necesito reforzar conceptos de límites, derivadas y aplicaciones.
                        </p>

                        <div class="solicitud-detalles">
                            <div class="detalle-item">
                                <span class="detalle-icon">📅</span>
                                <span>Fecha: 13/10/2024</span>
                            </div>
                            <div class="detalle-item">
                                <span class="detalle-icon">💰</span>
                                <span>Presupuesto: $25/hora</span>
                            </div>
                            <div class="detalle-item">
                                <span class="detalle-icon">⏱️</span>
                                <span>Urgencia: Media</span>
                            </div>
                        </div>
                    </div>

                    <div class="solicitud-footer">
                        <div class="solicitud-profesional">
                            <span style="color: #666;">Esperando respuestas...</span>
                        </div>
                        <div class="solicitud-actions">
                            <button class="btn btn-secondary btn-sm">Ver Detalles</button>
                            <button class="btn btn-danger btn-sm" onclick="cancelarSolicitud(this)">Cancelar</button>
                        </div>
                    </div>
                </div>

                <!-- Solicitud Completada -->
                <div class="solicitud-card" data-estado="completado">
                    <div class="solicitud-header">
                        <div class="solicitud-info">
                            <div class="solicitud-numero">#SOL-2024-004</div>
                            <h3 class="solicitud-titulo">Reparación de Instalación Eléctrica</h3>
                            <span class="solicitud-categoria">Hogar</span>
                        </div>
                        <span class="solicitud-estado estado-completado">Completado</span>
                    </div>

                    <div class="solicitud-body">
                        <p class="solicitud-descripcion">
                            Reparación de circuitos eléctricos en cocina y sala. 
                            Instalación de nuevos tomacorrientes y revisión general del sistema eléctrico.
                        </p>

                        <div class="solicitud-detalles">
                            <div class="detalle-item">
                                <span class="detalle-icon">📅</span>
                                <span>Fecha: 10/10/2024</span>
                            </div>
                            <div class="detalle-item">
                                <span class="detalle-icon">💰</span>
                                <span>Presupuesto: $200</span>
                            </div>
                            <div class="detalle-item">
                                <span class="detalle-icon">✅</span>
                                <span>Finalizado: 12/10/2024</span>
                            </div>
                        </div>
                    </div>

                    <div class="solicitud-footer">
                        <div class="solicitud-profesional">
                            <div class="prof-avatar">CP</div>
                            <div class="prof-info">
                                <span class="prof-nombre">Carlos Pérez</span>
                                <span class="prof-especialidad">Electricista</span>
                            </div>
                        </div>
                        <div class="solicitud-actions">
                            <button class="btn btn-warning btn-sm">⭐ Calificar</button>
                            <button class="btn btn-secondary btn-sm">Ver Detalles</button>
                        </div>
                    </div>
                </div>

                <!-- Solicitud Cancelada -->
                <div class="solicitud-card" data-estado="cancelado">
                    <div class="solicitud-header">
                        <div class="solicitud-info">
                            <div class="solicitud-numero">#SOL-2024-005</div>
                            <h3 class="solicitud-titulo">Diseño de Logo Empresarial</h3>
                            <span class="solicitud-categoria">Diseño</span>
                        </div>
                        <span class="solicitud-estado estado-cancelado">Cancelado</span>
                    </div>

                    <div class="solicitud-body">
                        <p class="solicitud-descripcion">
                            Necesitaba diseño de logo para nueva empresa de consultoría. 
                            Buscaba estilo moderno y minimalista con colores corporativos.
                        </p>

                        <div class="solicitud-detalles">
                            <div class="detalle-item">
                                <span class="detalle-icon">📅</span>
                                <span>Fecha: 08/10/2024</span>
                            </div>
                            <div class="detalle-item">
                                <span class="detalle-icon">💰</span>
                                <span>Presupuesto: $300 - $500</span>
                            </div>
                            <div class="detalle-item">
                                <span class="detalle-icon">❌</span>
                                <span>Cancelado: 11/10/2024</span>
                            </div>
                        </div>
                    </div>

                    <div class="solicitud-footer">
                        <div class="solicitud-profesional">
                            <span style="color: #999;">Solicitud cancelada por el usuario</span>
                        </div>
                        <div class="solicitud-actions">
                            <button class="btn btn-secondary btn-sm">Ver Detalles</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal Nueva Solicitud -->
        <div class="modal" id="modal-nueva-solicitud">
            <div class="modal-content">
                <div class="modal-header">
                    <h2>Nueva Solicitud de Servicio</h2>
                </div>
                <div class="modal-body">
                    <form id="form-solicitud">
                        <div class="form-group">
                            <label for="titulo">Título de la Solicitud</label>
                            <input type="text" id="titulo" required placeholder="Ej: Desarrollo de aplicación móvil">
                        </div>

                        <div class="form-group">
                            <label for="categoria">Categoría</label>
                            <select id="categoria" required>
                                <option value="">Selecciona una categoría</option>
                                <option value="Tecnología">Tecnología</option>
                                <option value="Salud">Salud</option>
                                <option value="Educación">Educación</option>
                                <option value="Hogar">Hogar</option>
                                <option value="Diseño">Diseño</option>
                                <option value="Legal">Legal</option>
                                <option value="Consultoría">Consultoría</option>
                                <option value="Otros">Otros</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="descripcion">Descripción Detallada</label>
                            <textarea id="descripcion" required placeholder="Describe tu solicitud con el mayor detalle posible..."></textarea>
                        </div>

                        <div class="form-group">
                            <label for="presupuesto">Presupuesto Estimado ($)</label>
                            <input type="text" id="presupuesto" placeholder="Ej: 500 - 1000 o 50/hora">
                        </div>

                        <div class="form-group">
                            <label for="urgencia">Nivel de Urgencia</label>
                            <select id="urgencia" required>
                                <option value="">Selecciona la urgencia</option>
                                <option value="Baja">Baja - Puedo esperar</option>
                                <option value="Media">Media - En 1-2 semanas</option>
                                <option value="Alta">Alta - Lo antes posible</option>
                                <option value="Urgente">Urgente - Inmediato</option>
                            </select>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" onclick="closeModal()">Cancelar</button>
                    <button class="btn btn-primary" onclick="crearSolicitud()">Crear Solicitud</button>
                </div>
            </div>
        </div>

        <script>
            function openModal() {
                document.getElementById('modal-nueva-solicitud').classList.add('active');
            }

            function closeModal() {
                document.getElementById('modal-nueva-solicitud').classList.remove('active');
                document.getElementById('form-solicitud').reset();
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

            function crearSolicitud() {
                const titulo = document.getElementById('titulo').value;
                const categoria = document.getElementById('categoria').value;
                const descripcion = document.getElementById('descripcion').value;
                const presupuesto = document.getElementById('presupuesto').value;
                const urgencia = document.getElementById('urgencia').value;

                if (!titulo || !categoria || !descripcion || !urgencia) {
                    alert('Por favor completa todos los campos requeridos');
                    return;
                }

                const numero = '#SOL-2024-' + String(Math.floor(Math.random() * 900) + 100);
                const fecha = new Date().toLocaleDateString('es-ES');

                const solicitudHTML = `
                    <div class="solicitud-card" data-estado="pendiente">
                        <div class="solicitud-header">
                            <div class="solicitud-info">
                                <div class="solicitud-numero">${numero}</div>
                                <h3 class="solicitud-titulo">${titulo}</h3>
                                <span class="solicitud-categoria">${categoria}</span>
                            </div>
                            <span class="solicitud-estado estado-pendiente">Pendiente</span>
                        </div>

                        <div class="solicitud-body">
                            <p class="solicitud-descripcion">${descripcion}</p>

                            <div class="solicitud-detalles">
                                <div class="detalle-item">
                                    <span class="detalle-icon">📅</span>
                                    <span>Fecha: ${fecha}</span>
                                </div>
                                <div class="detalle-item">
                                    <span class="detalle-icon">💰</span>
                                    <span>Presupuesto: ${presupuesto}</span>
                                </div>
                                <div class="detalle-item">
                                    <span class="detalle-icon">⏱️</span>
                                    <span>Urgencia: ${urgencia}</span>
                                </div>
                            </div>
                        </div>

                        <div class="solicitud-footer">
                            <div class="solicitud-profesional">
                                <span style="color: #666;">Esperando respuestas...</span>
                            </div>
                            <div class="solicitud-actions">
                                <button class="btn btn-secondary btn-sm">Ver Detalles</button>
                                <button class="btn btn-danger btn-sm" onclick="cancelarSolicitud(this)">Cancelar</button>
                            </div>
                        </div>
                    </div>
                `;

                const grid = document.getElementById('solicitudes-list');
                grid.insertAdjacentHTML('afterbegin', solicitudHTML);

                closeModal();

                // Mostrar notificación de éxito
                alert('✅ Solicitud creada exitosamente. Los profesionales podrán ver tu solicitud y contactarte.');

                // Actualizar contadores
                actualizarContadores();
            }

            function cancelarSolicitud(btn) {
                if (confirm('¿Estás seguro de que deseas cancelar esta solicitud?')) {
                    const card = btn.closest('.solicitud-card');
                    const estadoBadge = card.querySelector('.solicitud-estado');

                    card.setAttribute('data-estado', 'cancelado');
                    estadoBadge.className = 'solicitud-estado estado-cancelado';
                    estadoBadge.textContent = 'Cancelado';

                    const footer = card.querySelector('.solicitud-footer');
                    footer.innerHTML = `
                        <div class="solicitud-profesional">
                            <span style="color: #999;">Solicitud cancelada por el usuario</span>
                        </div>
                        <div class="solicitud-actions">
                            <button class="btn btn-secondary btn-sm">Ver Detalles</button>
                        </div>
                    `;

                    actualizarContadores();
                    alert('Solicitud cancelada correctamente');
                }
            }

            function completarSolicitud(btn) {
                if (confirm('¿Confirmas que el servicio ha sido completado satisfactoriamente?')) {
                    const card = btn.closest('.solicitud-card');
                    const estadoBadge = card.querySelector('.solicitud-estado');

                    card.setAttribute('data-estado', 'completado');
                    estadoBadge.className = 'solicitud-estado estado-completado';
                    estadoBadge.textContent = 'Completado';

                    const fecha = new Date().toLocaleDateString('es-ES');
                    const detalles = card.querySelector('.solicitud-detalles');
                    const ultimoDetalle = detalles.lastElementChild;
                    ultimoDetalle.innerHTML = `
                        <span class="detalle-icon">✅</span>
                        <span>Finalizado: ${fecha}</span>
                    `;

                    const actions = card.querySelector('.solicitud-actions');
                    actions.innerHTML = `
                        <button class="btn btn-warning btn-sm">⭐ Calificar</button>
                        <button class="btn btn-secondary btn-sm">Ver Detalles</button>
                    `;

                    actualizarContadores();
                    alert('¡Excelente! Por favor califica el servicio recibido');
                }
            }

            function actualizarContadores() {
                const cards = document.querySelectorAll('.solicitud-card');
                let contadores = {
                    todas: 0,
                    pendiente: 0,
                    proceso: 0,
                    completado: 0,
                    cancelado: 0
                };

                cards.forEach(card => {
                    const estado = card.getAttribute('data-estado');
                    contadores.todas++;
                    if (estado in contadores) {
                        contadores[estado]++;
                    }
                });

                const tabs = document.querySelectorAll('.tab');
                tabs[0].textContent = `Todas (${contadores.todas})`;
                tabs[1].textContent = `Pendientes (${contadores.pendiente})`;
                tabs[2].textContent = `En Proceso (${contadores.proceso})`;
                tabs[3].textContent = `Completadas (${contadores.completado})`;
                tabs[4].textContent = `Canceladas (${contadores.cancelado})`;
            }

            // Cerrar modal al hacer clic fuera
            window.onclick = function(event) {
                const modal = document.getElementById('modal-nueva-solicitud');
                if (event.target === modal) {
                    closeModal();
                }
            }

            // Inicializar contadores al cargar
            document.addEventListener('DOMContentLoaded', actualizarContadores);
        </script>
        <%@include  file="WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
