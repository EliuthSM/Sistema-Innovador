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
                
                <!-- CORRECCIÓN: Se añade / para ruta absoluta -->
              <%@include file="/WEB-INF/jspfCss/styles.jspf"%>
        <body>
                <!-- Header -->
                <%@include file="/WEB-INF/jspf/header.jspf" %>
                <%@include file="/WEB-INF/jspf/navbar.jspf" %>
                <section>
                        <div class="container-fluid">
                                <div class="row">
                                        <div class="col-lg-8 offset-lg-2">
                                                <div class="card">
                                                        <div class="card-header">
                                                                Resultado de Operación
                                                            </div>
                                                        <div class="card-body">
                                                                <h5 class="card-title">Ha ocurrido un error en la aplicación.</h5>
                                                                <div class="alert alert-danger" role="alert">
                                                                        Mensaje de error: <%= (mensaje != null) ? mensaje : "Error desconocido."%> 
                                                                    </div>
                                                                <a href="index.jsp" class="btn btn-primary">Volver al Inicio</a>
                                                            </div>
                                                    </div>
                                            </div>
                                    </div>
                            </div>
                    </section>
                <%@include file="/WEB-INF/jspf/footer.jspf" %>
                <%@include file="/WEB-INF/jspf/scripts.jspf" %>
            </body>
</html>
