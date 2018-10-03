
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="img/logo.png">
        <title>Control Inventario - Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <style>
            .bg {
                /* Imagen de Fondo */
                background-image: url("img/wallpaper1.jpg");

                /* Tamaño del Fondo */
                height: 100%;

                /* Configuraciones */
                background-position: initial;
                background-repeat: repeat;
                background-size: cover;
            }

            .ml-auto .dropdown-menu {
                left: auto !important;
                right: 0px;
            }

            .dropdown-menu {
                background-color: #343a40
            }
        </style>
    </head>
    <body class="bg">

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">

            <a class="nav navbar-brand" href="/InventarioStruts/login.jsp">
                <img src="img/inicio.jpg" alt="Logo" style="width:40px;">
            </a>

            <ul class="nav navbar-nav">
                <li class="nav-item dropdown">
                    <div class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Iniciar
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" style="background-color: #343a40">
                            <html:link page="/login.jsp" styleClass="btn btn-outline-info">Iniciar Sesión</html:link>
                        </div>
                    </div>
                </li>
        </nav>
                
        <div class="container">
            <br>
            <div class="row">
                <div class="col-4"></div>
                <div class="col-4">
                    <html:form action="/user">
                        <div class="card">
                            <div class="card bg-success text-white">
                                <div class="card-header">Inicio de Sesión</div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-12 text-center">
                                        <img src="img/user.png" width="100" height="100">
                                    </div>
                                </div>
                                <br>
                                <label>Correo</label><br>
                                <html:text property="correo" styleClass="form-control"></html:text>
                                <label>Contraseña</label><br>
                                <html:password property="contra" styleClass="form-control"></html:password>
                                <br>
                                <div class="row">
                                    <div class="col-md-12 text-center">
                                        <html:submit styleClass="btn btn-outline-success btn-block" property="action" value="Entrar">Entrar</html:submit>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </html:form>
                </div>
                <div class="col-4"></div>
            </div>
            <div id="error" hidden="hidden">${error}</div>
            <div id="mensaje" hidden="hidden">${mensaje}</div>
            <div id="info" hidden="hidden">${info}</div>
        </div>
        
        <script>
            toastr.options = {
                "debug": false,
                "positionClass": "toast-bottom-right",
                "onclick": null,
                "fadeIn": 300,
                "fadeOut": 100,
                "timeOut": 5000,
                "extendedTimeOut": 1000
            }

            var showToastrs = false;

            function error() {
                if (!showToastrs) {
                    toastr.error($("#error").text(), 'Error!');
                }
            }

            function mensaje() {
                if (!showToastrs) {
                    toastr.success($("#mensaje").text(), 'Éxito!');
                }
            }
            function info() {
                if (!showToastrs) {
                    toastr.info($("#info").text(), 'Info!');
                }
            }

            window.onload = function () {
                if ($("#error").text() != "") {
                    error();
                }
                if ($("#mensaje").text() != "") {
                    mensaje();
                }
                if ($("#info").text() != "") {
                    info();
                }
            }
        </script>
        
    </body>
</html>
