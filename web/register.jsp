<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Comportamiento responsivo -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Registro de Usuario | ProfiNet</title>
        <%@include  file="/WEB-INF/jspfCss/registerCss.jspf" %>
        
        <%@include  file="/WEB-INF/jspfCss/styles.jspf" %>
    </head>
    <body>
        <div class="registro-container">
            <div class="registro-header">
                <h1>Únete a ProfiNet</h1>
                <p>Crea tu cuenta y empieza a conectar con profesionales</p>
                <!-- Mensaje de error/éxito si viene del servidor -->
                <%
                    String error = (String) request.getAttribute("error");
                    String registro = request.getParameter("registro");
                    if (error != null) {
                %>
                <div class="server-message error-message-box"><%= error%></div>
                <%
                } else if ("exitoso".equals(registro)) {
                %>
                <div class="server-message success-message-box">¡Registro exitoso! Por favor, inicia sesión.</div>
                <%
                    }
                %>
            </div>

            <div class="tipo-usuario-selector">
                <div class="tipo-card" onclick="selectUserType('cliente')" id="cliente-card">
                    <div class="tipo-icon">👤</div>
                    <h3>Cliente</h3>
                    <p>Busco contratar servicios profesionales</p>
                </div>
                <div class="tipo-card" onclick="selectUserType('profesional')" id="profesional-card">
                    <div class="tipo-icon">💼</div>
                    <h3>Profesional</h3>
                    <p>Ofrezco mis servicios profesionales</p>
                </div>
            </div>

            <!-- ========================================================= -->
            <!-- Formulario para Cliente: Asegura name y action (Servidor) -->
            <!-- ========================================================= -->
            <form id="form-cliente" class="registro-form" action="auth" method="POST">

                <!-- Campo oculto para indicar la operación al AuthController -->
                <input type="hidden" name="operacion" value="registrar_cliente">

                <div class="form-section">
                    <h3>Información Personal</h3>
                    <div class="form-grid">
                        <div class="form-group">
                            <label for="nombre-cliente">Nombre *</label>
                            <!-- NAME debe coincidir con RegistroClienteRequestDTO.nombreCompleto -->
                            <input type="text" id="nombre-cliente" name="nombreCompleto" required>
                            <span class="error-message">Este campo es requerido</span>
                        </div>
                        <div class="form-group">
                            <label for="correo-cliente">Correo Electrónico *</label>
                            <!-- NAME debe coincidir con RegistroClienteRequestDTO.correo -->
                            <input type="email" id="correo-cliente" name="correo" required>
                            <span class="error-message">Ingrese un correo válido</span>
                        </div>
                        <div class="form-group">
                            <label for="telefono-cliente">Teléfono *</label>
                            <!-- NAME debe coincidir con RegistroClienteRequestDTO.telefono -->
                            <input type="tel" id="telefono-cliente" name="telefono" required>
                            <span class="error-message">Este campo es requerido</span>
                        </div>
                        <!-- NOTA: El campo Direccion no está en el DTO de Cliente, lo quitamos o añadimos un hidden -->
                        <div class="form-group">
                            <label for="direccion-cliente">Dirección</label>
                            <!-- Ya que la BD no lo pide, lo dejamos sin name o lo quitamos para evitar confusión. -->
                            <input type="text" id="direccion-cliente">
                        </div>
                    </div>
                </div>

                <div class="form-section">
                    <h3>Datos de Acceso</h3>
                    <div class="form-grid">
                        <div class="form-group">
                            <label for="usuario-cliente">Nombre de Usuario *</label>
                            <!-- Nota: Asumimos que "Nombre de Usuario" es solo el "Nombre Completo" en tu DTO.
                                 Si tu DTO tiene campo 'nombreUsuario', deberías usar name="nombreUsuario" -->
                            <input type="text" id="usuario-cliente" required>
                            <span class="error-message">Este campo es requerido</span>
                        </div>
                        <div class="form-group">
                            <label for="password-cliente">Contraseña *</label>
                            <!-- NAME debe coincidir con RegistroClienteRequestDTO.contrasena -->
                            <input type="password" id="password-cliente" name="contrasena" required>
                            <span class="error-message">Mínimo 8 caracteres</span>
                        </div>
                    </div>
                </div>

                <div class="form-actions">
                    <button type="button" class="btn btn-secondary" onclick="window.location.href = 'index.jsp'">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Registrarse como Cliente</button>
                </div>

                <div class="login-link">
                    ¿Ya tienes cuenta? <a href="auth?operacion=login_view">Inicia sesión</a>
                </div>
            </form>

            <!-- ========================================================= -->
            <!-- Formulario para Profesional: Asegura name y action (Servidor) -->
            <!-- ========================================================= -->
            <form id="form-profesional" class="registro-form" action="auth" method="POST">

                <!-- Campo oculto para indicar la operación al AuthController -->
                <input type="hidden" name="operacion" value="registrar_profesional">
                <div class="form-section">
                    <h3>Información Personal</h3>
                    <div class="form-grid">
                        <div class="form-group">
                            <label for="nombre-profesional">Nombre Completo *</label>
                            <!-- NAME debe coincidir con RegistroProfesionalRequestDTO.nombreCompleto -->
                            <input type="text" id="nombre-profesional" name="nombreCompleto" required>
                            <span class="error-message">Este campo es requerido</span>
                        </div>
                        <div class="form-group">
                            <label for="correo-profesional">Correo Electrónico *</label>
                            <!-- NAME debe coincidir con RegistroProfesionalRequestDTO.correo -->
                            <input type="email" id="correo-profesional" name="correo" required>
                            <span class="error-message">Ingrese un correo válido</span>
                        </div>
                        <div class="form-group">
                            <label for="telefono-profesional">Teléfono *</label>
                            <!-- NAME debe coincidir con RegistroProfesionalRequestDTO.telefono -->
                            <input type="tel" id="telefono-profesional" name="telefono" required>
                            <span class="error-message">Este campo es requerido</span>
                        </div>
                        <div class="form-group">
                            <label for="ubicacion-profesional">Ubicación *</label>
                            <!-- NAME debe coincidir con RegistroProfesionalRequestDTO.ubicacion -->
                            <input type="text" id="ubicacion-profesional" name="ubicacion" required>
                            <span class="error-message">Este campo es requerido</span>
                        </div>
                    </div>
                </div>

                <div class="form-section">
                    <h3>Información Profesional</h3>
                    <div class="form-grid">
                        <div class="form-group">
                            <label for="especialidad-profesional">Especialidad Principal *</label>
                            <!-- NAME debe coincidir con RegistroProfesionalRequestDTO.categoriaPrincipalId. Usamos el valor del option. -->
                            <select id="especialidad-profesional" name="categoriaPrincipalId" required>
                                <option value="">Seleccione una especialidad</option>
                                <!-- Usaremos IDs numéricos ya que el DTO espera un INT (categoriaPrincipalId) -->
                                <option value="1">Medicina</option>
                                <option value="2">Programación</option>
                                <option value="3">Diseño</option>
                                <option value="4">Educación</option>
                                <option value="5">Legal</option>
                                <option value="6">Contabilidad</option>
                                <option value="7">Arquitectura</option>
                                <option value="8">Psicología</option>
                                <option value="9">Ingeniería</option>
                                <option value="10">Marketing</option>
                            </select>
                            <span class="error-message">Seleccione una especialidad</span>
                        </div>
                        <div class="form-group">
                            <label for="experiencia-profesional">Años de Experiencia *</label>
                            <!-- NAME debe coincidir con RegistroProfesionalRequestDTO.anosExperiencia -->
                            <input type="number" id="experiencia-profesional" name="anosExperiencia" min="0" required>
                            <span class="error-message">Este campo es requerido</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="descripcion-profesional">Descripción de sus servicios *</label>
                        <!-- NAME debe coincidir con RegistroProfesionalRequestDTO.descripcionServicios -->
                        <textarea id="descripcion-profesional" name="descripcionServicios" required placeholder="Describa sus servicios, experiencia y lo que lo diferencia..."></textarea>
                        <span class="error-message">Este campo es requerido</span>
                    </div>
                </div>

                <div class="form-section">
                    <h3>Especialidades Adicionales (Habilidades)</h3>
                    <!-- NOTA: El DTO espera List<Integer> habilidadesIds. Usamos el mismo NAME para que el Servlet recoja todos los valores. -->
                    <div class="especialidades-container">
                        <div class="especialidad-item">
                            <input type="checkbox" id="esp-web" name="habilidadesIds" value="101">
                            <label for="esp-web">Desarrollo Web</label>
                        </div>
                        <div class="especialidad-item">
                            <input type="checkbox" id="esp-movil" name="habilidadesIds" value="102">
                            <label for="esp-movil">Desarrollo Móvil</label>
                        </div>
                        <div class="especialidad-item">
                            <input type="checkbox" id="esp-ui" name="habilidadesIds" value="103">
                            <label for="esp-ui">UI/UX Design</label>
                        </div>
                        <div class="especialidad-item">
                            <input type="checkbox" id="esp-marketing" name="habilidadesIds" value="104">
                            <label for="esp-marketing">Marketing Digital</label>
                        </div>
                        <div class="especialidad-item">
                            <input type="checkbox" id="esp-seo" name="habilidadesIds" value="105">
                            <label for="esp-seo">SEO</label>
                        </div>
                        <div class="especialidad-item">
                            <input type="checkbox" id="esp-redes" name="habilidadesIds" value="106">
                            <label for="esp-redes">Redes Sociales</label>
                        </div>
                        <div class="especialidad-item">
                            <input type="checkbox" id="esp-contabilidad" name="habilidadesIds" value="107">
                            <label for="esp-contabilidad">Contabilidad</label>
                        </div>
                        <div class="especialidad-item">
                            <input type="checkbox" id="esp-legal" name="habilidadesIds" value="108">
                            <label for="esp-legal">Asesoría Legal</label>
                        </div>
                    </div>
                </div>

                <div class="form-section">
                    <h3>Datos de Acceso</h3>
                    <div class="form-grid">
                        <div class="form-group">
                            <label for="usuario-profesional">Nombre de Usuario *</label>
                            <!-- Nota: Asumimos que "Nombre de Usuario" es solo el "Nombre Completo" en tu DTO. -->
                            <input type="text" id="usuario-profesional" required>
                            <span class="error-message">Este campo es requerido</span>
                        </div>
                        <div class="form-group">
                            <label for="password-profesional">Contraseña *</label>
                            <!-- NAME debe coincidir con RegistroProfesionalRequestDTO.contrasena -->
                            <input type="password" id="password-profesional" name="contrasena" required>
                            <span class="error-message">Mínimo 8 caracteres</span>
                        </div>
                    </div>
                </div>

                <div class="form-actions">
                    <button type="button" class="btn btn-secondary" onclick="window.location.href = 'index.jsp'">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Registrarse como Profesional</button>
                </div>

                <div class="login-link">
                    ¿Ya tienes cuenta? <a href="auth?operacion=login_view">Inicia sesión</a>
                </div>
            </form>
        </div>

        <script>
            let selectedType = null;

            function selectUserType(type) {
                const clienteCard = document.getElementById('cliente-card');
                const profesionalCard = document.getElementById('profesional-card');
                const formCliente = document.getElementById('form-cliente');
                const formProfesional = document.getElementById('form-profesional');

                // 1. Ocultar ambos formularios explícitamente al inicio de la selección
                formCliente.style.display = 'none';
                formProfesional.style.display = 'none';

                // 2. Manejar el estilo de las tarjetas
                clienteCard.classList.remove('active');
                profesionalCard.classList.remove('active');

                // 3. Mostrar el formulario correcto de forma explícita
                if (type === 'cliente') {
                    clienteCard.classList.add('active');
                    formCliente.style.display = 'block'; // Muestra Cliente
                } else if (type === 'profesional') {
                    profesionalCard.classList.add('active');
                    formProfesional.style.display = 'block'; // Muestra Profesional
                }

                selectedType = type;
            }


            // --- LIMPIEZA DE LÓGICA DE REGISTRO JS ---
            // Eliminamos la lógica de simulación (e.preventDefault(), alert, setTimeout), 
            // ya que el formulario ahora se envía al Servidor (action="auth").

            document.getElementById('form-cliente').addEventListener('submit', function (e) {
                // Dejar que el formulario se envíe al servidor
            });

            document.getElementById('form-profesional').addEventListener('submit', function (e) {
                // Dejar que el formulario se envíe al servidor
            });

            // Seleccionar Cliente por defecto al cargar la página
            selectUserType('cliente');
        </script>
    </body>
</html>
