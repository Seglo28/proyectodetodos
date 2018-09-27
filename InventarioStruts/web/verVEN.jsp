
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-faces" prefix="faces" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de tabla Facturas</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script src="http://codeseven.github.com/toastr/toastr.js"></script>
	<link href="http://codeseven.github.com/toastr/toastr.css" rel="stylesheet"/>
	<link href="http://codeseven.github.com/toastr/toastr-responsive.css" rel="stylesheet"/>
        <style>
            .bg {
                /* Imagen de Fondo */
                background-image: url("img/login.jpg");

                /* Tamaño del Fondo */
                height: 100%;

                /* Configuraciones */
                background-position: initial;
                background-repeat: initial;
                background-size: cover;
            }

            .ml-auto .dropdown-menu {
                left: auto !important;
                right: 0px;
            }
        </style>
    </head>
    <body class="bg">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">

            <a class="nav navbar-brand" href="/InventarioStruts/inicio.jsp">
                <img src="img/inicio.jpg" alt="Logo" style="width:40px;">
            </a>
            <ul class="nav navbar-nav">


                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Usuarios
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href=""><html:link page="/formUser.jsp" styleClass="btn btn-outline-info">Ingresar Usuario</html:link></a>
                        <a class="dropdown-item" href=""><html:form action="/user">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Usuarios</html:submit> 
                            </html:form></a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Productos
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href=""><html:form action="/productos">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Agregar Producto">Agregar</html:submit>
                            </html:form></a>
                        <a class="dropdown-item" href=""><html:form action="/productos">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Productos</html:submit> 
                            </html:form></a>
                    </div>
                </li>
                <!-- esto es lo que deja ver las lista de ID-->

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Compras
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href=""><html:form action="/compras">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Agregar Compra">Agregar</html:submit>
                            </html:form></a>
                        <a class="dropdown-item" href=""><html:form action="/compras">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Compras</html:submit> 
                            </html:form></a>
                    </div>
                </li>
                <!--AQUI TERMINA.... esto es lo que deja ver las lista de ID-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Fabricantes
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href=""><html:link page="/formFabricantes.jsp" styleClass="btn btn-outline-info">Ingresar Fabricantes</html:link></a>
                        <a class="dropdown-item" href=""><html:form action="/fabricantes">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista deFabricantes</html:submit> 
                            </html:form></a>
                    </div>
                </li>
                <!-- INICIO FACTURAS-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Facturas
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href=""><html:form action="/facturas">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de facturas</html:submit> 
                            </html:form></a>
                    </div>
                </li>
                <!-- FINAL FACTURAS-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Clientes
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href=""><html:link page="/formClientes.jsp" styleClass="btn btn-outline-info">IngresarClientes</html:link></a>
                        <a class="dropdown-item" href=""><html:form action="/clientes">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Clientes</html:submit> 
                            </html:form></a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Sucursales
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href=""><html:link page="/formSucursales.jsp" styleClass="btn btn-outline-info">Ingresar Sucursal</html:link></a>
                        <a class="dropdown-item" href=""><html:form action="/sucursales">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Sucursales</html:submit> 
                            </html:form></a>
                    </div>
                </li>
                <!-- INICIO VENTAS-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Ventas
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href=""><html:form action="/ventas">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de facturas</html:submit> 
                            </html:form></a>
                    </div>
                </li>
                <!-- FINAL VENTAS-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Proveedores
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href=""><html:link page="/formProveedores.jsp" styleClass="btn btn-outline-info">Ingresar Sucursal</html:link></a>
                        <a class="dropdown-item" href=""><html:form action="/proveedores">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Sucursales</html:submit> 
                            </html:form></a>
                    </div>
                </li>
                


            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <html:link page="/login.jsp" styleClass="btn btn-outline-danger">Cerrar Sesión</html:link>
                    </li>
                </ul>
            </nav>

            <div class="container">
                <br>
                <div class="row">
                    <div class="col-12">
                        <table class="table table-hover">
                            <thead class="thead-dark">
                                <tr>
                                    <th>ID VENTA</th>
                                    <th>CLIENTE</th>
                                    <th>PRODUCTO</th>
                                    <th>USUARIO</th>
                                    <th>SUCURSAL</th>
                                    <th>CANTIDAD</th>
                                    <th>MONTO</th>
                                    <th>FECHA</th>
                                    <th>ACTUALIZAR</th>
                                    <th>ELIMINAR</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <logic:notEmpty name="ActionFormVentas" property="listaVen">
                                <logic:iterate id="a" name="ActionFormVentas" property="listaVen">
                                    <tr>
                                        <html:form action="/ventas">
                                            <td><bean:write name="a" property="idVenta"/>
                                                <div hidden="hidden"><html:text name="a" property="idVenta" /></div></td>
                                            <td><bean:write name="a" property="clientes.cliente"/></td>
                                            <td><bean:write name="a" property="productos.producto"/></td>
                                            <td><bean:write name="a" property="usuario.usuario"/></td>
                                            <td><bean:write name="a" property="sucursales.sucursal"/></td>
                                            <td><bean:write name="a" property="cantidad"/></td>
                                            <td><bean:write name="a" property="monto"/></td>
                                            <td><bean:write name="a" property="fechaVenta"/></td>
                                            <td><html:submit styleClass="btn btn-success" property="action" value="Actualizar"/></td>
                                    <td><html:submit styleClass="btn btn-danger" property="action" value="Eliminar"/></td>
                                        </html:form>
                                    </tr>
                                </logic:iterate>
                            </logic:notEmpty>
                        </tbody>
                    </table>
                </div>
                <div id="error" hidden="hidden">${error}</div>
                <div id="mensaje" hidden="hidden">${mensaje}</div>
                <div id="info" hidden="hidden">${info}</div>
                <div id="warning" hidden="hidden">${warning}</div>
            </div>
        
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
                if(!showToastrs){
                    toastr.error($("#error").text(), 'Error!');
                }
            }
            
            function mensaje() {
                if(!showToastrs){
                    toastr.success($("#mensaje").text(), 'Éxito!');
                }
            }
            function info() {
                if(!showToastrs){
                    toastr.info($("#info").text(), 'Info!');
                }
            }
            function warning() {
                if(!showToastrs){
                    toastr.warning($("#warning").text(), 'Advertencia!');
                }
            }
            
            window.onload = function(){
                if($("#error").text() != ""){
                    error();
                }
                if($("#mensaje").text() != ""){
                    mensaje();
                }
                if($("#info").text() != ""){
                    info();
                }
                if($("#warning").text() != ""){
                    warning();
                }
            }

        </script>
    </body>
</html>

