
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Comportamiento responsivo -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <%@include  file="WEB-INF/jspfCss/loginCss.jspf" %>
        <%@include  file="WEB-INF/jspfCss/styles.jspf" %>
    </head>
    <body>
        <!-- Header -->
        <%@include  file="WEB-INF/jspf/header.jspf" %>
        <div class="main-content">
            <div class="login-container">
                <div class="login-header">
                    <h1>Bienvenido de vuelta</h1>
                    <p>Ingresa a tu cuenta de ProfiNet</p>
                </div>

                <form id="loginForm" method="POST">
                    <div class="form-group">
                        <label for="username">Nombre de Usuario o Correo</label>
                        <input type="text" id="username" name="username" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Contraseña</label>
                        <input type="password" id="password" name="password" required>
                    </div>

                    <div class="remember-forgot">
                        <label class="remember-me">
                            <input type="checkbox" name="remember">
                            <span>Recordarme</span>
                        </label>
                        <a href="recuperar-password.html" class="forgot-password">¿Olvidaste tu contraseña?</a>
                    </div>

                    <button type="submit" class="btn-login">Iniciar Sesión</button>
                </form>

                <div class="divider">
                    <span>o</span>
                </div>

                <div class="register-link">
                    ¿No tienes cuenta? <a href="registro.html">Regístrate aquí</a>
                </div>
            </div>
        </div>

        <%@include  file="WEB-INF/jspf/footer.jspf" %>
        <script>
            document.getElementById('loginForm').addEventListener('submit', function(e) {
                e.preventDefault();

                const username = document.getElementById('username').value;
                const password = document.getElementById('password').value;

                // Simulación de validación
                if (username && password) {
                    alert('Iniciando sesión...');
                    // Aquí iría la lógica de autenticación
                    window.location.href = 'mis-solicitudes.html';
                }
            });
        </script>
    </body>
</html>
