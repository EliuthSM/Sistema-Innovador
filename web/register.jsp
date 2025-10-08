
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Comportamiento responsivo -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <%@include  file="WEB-INF/jspfCss/registerCss.jspf" %>
        <%@include  file="WEB-INF/jspfCss/styles.jspf" %>
    </head>
    <body>
        <div class="registro-container">
        <div class="registro-header">
            <h1>Únete a ProfiNet</h1>
            <p>Crea tu cuenta y empieza a conectar con profesionales</p>
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
        
        <!-- Formulario para Cliente -->
        <form id="form-cliente" class="registro-form">
            <div class="success-message" id="success-cliente">
                ¡Registro exitoso! Redirigiendo...
            </div>
            
            <div class="form-section">
                <h3>Información Personal</h3>
                <div class="form-grid">
                    <div class="form-group">
                        <label for="nombre-cliente">Nombre *</label>
                        <input type="text" id="nombre-cliente" required>
                        <span class="error-message">Este campo es requerido</span>
                    </div>
                    <div class="form-group">
                        <label for="correo-cliente">Correo Electrónico *</label>
                        <input type="email" id="correo-cliente" required>
                        <span class="error-message">Ingrese un correo válido</span>
                    </div>
                    <div class="form-group">
                        <label for="telefono-cliente">Teléfono *</label>
                        <input type="tel" id="telefono-cliente" required>
                        <span class="error-message">Este campo es requerido</span>
                    </div>
                    <div class="form-group">
                        <label for="direccion-cliente">Dirección</label>
                        <input type="text" id="direccion-cliente">
                    </div>
                </div>
            </div>
            
            <div class="form-section">
                <h3>Datos de Acceso</h3>
                <div class="form-grid">
                    <div class="form-group">
                        <label for="usuario-cliente">Nombre de Usuario *</label>
                        <input type="text" id="usuario-cliente" required>
                        <span class="error-message">Este campo es requerido</span>
                    </div>
                    <div class="form-group">
                        <label for="password-cliente">Contraseña *</label>
                        <input type="password" id="password-cliente" required>
                        <span class="error-message">Mínimo 8 caracteres</span>
                    </div>
                </div>
            </div>
            
            <div class="form-actions">
                <button type="button" class="btn btn-secondary" onclick="location.href='index.html'">Cancelar</button>
                <button type="submit" class="btn btn-primary">Registrarse como Cliente</button>
            </div>
            
            <div class="login-link">
                ¿Ya tienes cuenta? <a href="login.html">Inicia sesión</a>
            </div>
        </form>
        
        <!-- Formulario para Profesional -->
        <form id="form-profesional" class="registro-form">
            <div class="success-message" id="success-profesional">
                ¡Registro exitoso! Redirigiendo...
            </div>
            
            <div class="form-section">
                <h3>Información Personal</h3>
                <div class="form-grid">
                    <div class="form-group">
                        <label for="nombre-profesional">Nombre Completo *</label>
                        <input type="text" id="nombre-profesional" required>
                        <span class="error-message">Este campo es requerido</span>
                    </div>
                    <div class="form-group">
                        <label for="correo-profesional">Correo Electrónico *</label>
                        <input type="email" id="correo-profesional" required>
                        <span class="error-message">Ingrese un correo válido</span>
                    </div>
                    <div class="form-group">
                        <label for="telefono-profesional">Teléfono *</label>
                        <input type="tel" id="telefono-profesional" required>
                        <span class="error-message">Este campo es requerido</span>
                    </div>
                    <div class="form-group">
                        <label for="ubicacion-profesional">Ubicación *</label>
                        <input type="text" id="ubicacion-profesional" required>
                        <span class="error-message">Este campo es requerido</span>
                    </div>
                </div>
            </div>
            
            <div class="form-section">
                <h3>Información Profesional</h3>
                <div class="form-grid">
                    <div class="form-group">
                        <label for="especialidad-profesional">Especialidad Principal *</label>
                        <select id="especialidad-profesional" required>
                            <option value="">Seleccione una especialidad</option>
                            <option value="medicina">Medicina</option>
                            <option value="programacion">Programación</option>
                            <option value="diseño">Diseño</option>
                            <option value="educacion">Educación</option>
                            <option value="legal">Legal</option>
                            <option value="contabilidad">Contabilidad</option>
                            <option value="arquitectura">Arquitectura</option>
                            <option value="psicologia">Psicología</option>
                            <option value="ingenieria">Ingeniería</option>
                            <option value="marketing">Marketing</option>
                        </select>
                        <span class="error-message">Seleccione una especialidad</span>
                    </div>
                    <div class="form-group">
                        <label for="experiencia-profesional">Años de Experiencia *</label>
                        <input type="number" id="experiencia-profesional" min="0" required>
                        <span class="error-message">Este campo es requerido</span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="descripcion-profesional">Descripción de sus servicios *</label>
                    <textarea id="descripcion-profesional" required placeholder="Describa sus servicios, experiencia y lo que lo diferencia..."></textarea>
                    <span class="error-message">Este campo es requerido</span>
                </div>
            </div>
            
            <div class="form-section">
                <h3>Especialidades Adicionales</h3>
                <div class="especialidades-container">
                    <div class="especialidad-item">
                        <input type="checkbox" id="esp-web" value="desarrollo-web">
                        <label for="esp-web">Desarrollo Web</label>
                    </div>
                    <div class="especialidad-item">
                        <input type="checkbox" id="esp-movil" value="desarrollo-movil">
                        <label for="esp-movil">Desarrollo Móvil</label>
                    </div>
                    <div class="especialidad-item">
                        <input type="checkbox" id="esp-ui" value="ui-ux">
                        <label for="esp-ui">UI/UX Design</label>
                    </div>
                    <div class="especialidad-item">
                        <input type="checkbox" id="esp-marketing" value="marketing-digital">
                        <label for="esp-marketing">Marketing Digital</label>
                    </div>
                    <div class="especialidad-item">
                        <input type="checkbox" id="esp-seo" value="seo">
                        <label for="esp-seo">SEO</label>
                    </div>
                    <div class="especialidad-item">
                        <input type="checkbox" id="esp-redes" value="redes-sociales">
                        <label for="esp-redes">Redes Sociales</label>
                    </div>
                    <div class="especialidad-item">
                        <input type="checkbox" id="esp-contabilidad" value="contabilidad">
                        <label for="esp-contabilidad">Contabilidad</label>
                    </div>
                    <div class="especialidad-item">
                        <input type="checkbox" id="esp-legal" value="asesoria-legal">
                        <label for="esp-legal">Asesoría Legal</label>
                    </div>
                </div>
            </div>
            
            <div class="form-section">
                <h3>Datos de Acceso</h3>
                <div class="form-grid">
                    <div class="form-group">
                        <label for="usuario-profesional">Nombre de Usuario *</label>
                        <input type="text" id="usuario-profesional" required>
                        <span class="error-message">Este campo es requerido</span>
                    </div>
                    <div class="form-group">
                        <label for="password-profesional">Contraseña *</label>
                        <input type="password" id="password-profesional" required>
                        <span class="error-message">Mínimo 8 caracteres</span>
                    </div>
                </div>
            </div>
            
            <div class="form-actions">
                <button type="button" class="btn btn-secondary" onclick="location.href='index.jsp'">Cancelar</button>
                <button type="submit" class="btn btn-primary">Registrarse como Profesional</button>
            </div>
            
            <div class="login-link">
                ¿Ya tienes cuenta? <a href="login.html">Inicia sesión</a>
            </div>
        </form>
    </div>
    
    <script>
        let selectedType = null;
        
        function selectUserType(type) {
            // Remover active de todos
            document.getElementById('cliente-card').classList.remove('active');
            document.getElementById('profesional-card').classList.remove('active');
            document.getElementById('form-cliente').classList.remove('active');
            document.getElementById('form-profesional').classList.remove('active');
            
            // Agregar active al seleccionado
            if (type === 'cliente') {
                document.getElementById('cliente-card').classList.add('active');
                document.getElementById('form-cliente').classList.add('active');
            } else if (type === 'profesional') {
                document.getElementById('profesional-card').classList.add('active');
                document.getElementById('form-profesional').classList.add('active');
            }
            
            selectedType = type;
        }
        
        // Validación del formulario de Cliente
        document.getElementById('form-cliente').addEventListener('submit', function(e) {
            e.preventDefault();
            
            // Validación básica
            const nombre = document.getElementById('nombre-cliente').value;
            const correo = document.getElementById('correo-cliente').value;
            const telefono = document.getElementById('telefono-cliente').value;
            const usuario = document.getElementById('usuario-cliente').value;
            const password = document.getElementById('password-cliente').value;
            
            if (!nombre || !correo || !telefono || !usuario || !password) {
                alert('Por favor complete todos los campos requeridos');
                return;
            }
            
            if (password.length < 8) {
                alert('La contraseña debe tener al menos 8 caracteres');
                return;
            }
            
            // Simular registro exitoso
            document.getElementById('success-cliente').style.display = 'block';
            setTimeout(() => {
                window.location.href = 'login.html';
            }, 2000);
        });
        
        // Validación del formulario de Profesional
        document.getElementById('form-profesional').addEventListener('submit', function(e) {
            e.preventDefault();
            
            // Validación básica
            const nombre = document.getElementById('nombre-profesional').value;
            const correo = document.getElementById('correo-profesional').value;
            const telefono = document.getElementById('telefono-profesional').value;
            const ubicacion = document.getElementById('ubicacion-profesional').value;
            const especialidad = document.getElementById('especialidad-profesional').value;
            const experiencia = document.getElementById('experiencia-profesional').value;
            const descripcion = document.getElementById('descripcion-profesional').value;
            const usuario = document.getElementById('usuario-profesional').value;
            const password = document.getElementById('password-profesional').value;
            
            if (!nombre || !correo || !telefono || !ubicacion || !especialidad || 
                !experiencia || !descripcion || !usuario || !password) {
                alert('Por favor complete todos los campos requeridos');
                return;
            }
            
            if (password.length < 8) {
                alert('La contraseña debe tener al menos 8 caracteres');
                return;
            }
            
            // Simular registro exitoso
            document.getElementById('success-profesional').style.display = 'block';
            setTimeout(() => {
                window.location.href = 'login.html';
            }, 2000);
        });
        
        // Seleccionar Cliente por defecto
        selectUserType('cliente');
    </script>
    </body>
</html>
