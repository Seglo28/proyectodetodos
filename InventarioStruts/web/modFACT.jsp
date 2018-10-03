<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="img/logo.png">
        <title>Control Inventario - Compras</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <style>
            .bg {
                /* Imagen de Fondo */
                background-image: url("img/wallpaper2.jpg");

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
                    <div class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Usuarios
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" style="background-color: #343a40">
                            <html:link page="/formUser.jsp" styleClass="btn btn-outline-info">Ingresar Usuario</html:link></div>
                        <div class="dropdown-item" style="background-color: #343a40"><html:form action="/user">
                            <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Usuarios</html:submit> 
                        </html:form></div>
                    </div>
                </li>
                
                <li class="nav-item dropdown">
                    <div class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Productos
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" style="background-color: #343a40"><html:form action="/productos">
                            <html:submit styleClass="btn btn-outline-info" property="action" value="Agregar Producto">Agregar</html:submit>
                        </div>
                        <div class="dropdown-item" style="background-color: #343a40">
                            <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Productos</html:submit> 
                        </html:form></div>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <div class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Compras
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" style="background-color: #343a40"><html:form action="/compras">
                            <html:submit styleClass="btn btn-outline-info" property="action" value="Agregar Compra">Agregar</html:submit>
                        </div>
                        <div class="dropdown-item" style="background-color: #343a40">
                            <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Compras</html:submit> 
                        </html:form></div>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <div class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Fabricantes
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" style="background-color: #343a40"><html:form action="/fabricantes">
                            <html:link page="/formFabricantes.jsp" styleClass="btn btn-outline-info">Ingresar Fabricantes</html:link>
                        </div>
                        <div class="dropdown-item" style="background-color: #343a40">
                            <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista deFabricantes</html:submit> 
                        </html:form></div>
                    </div>
                </li>
                
                  <li class="nav-item dropdown">
                    <div class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                       Facturas
                    </div>
                    <div class="dropdown-menu">
                       <html:form action="/facturas">
                        <div class="dropdown-item" style="background-color: #343a40">
                            <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar"></html:submit> 
                        </div>
                        <div class="dropdown-item" style="background-color: #343a40">
                            <html:submit styleClass="btn btn-outline-info" property="action" value="Archivo Facturas"></html:submit> 
                        </html:form></div>
                    </div>
                </li>
                
                <li class="nav-item dropdown">
                    <div class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Clientes
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" style="background-color: #343a40"><html:form action="/clientes">
                            <html:link page="/formClientes.jsp" styleClass="btn btn-outline-info">Ingresar Cliente</html:link>
                        </div>
                        <a class="dropdown-item" style="background-color: #343a40">
                            <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Clientes</html:submit> 
                        </html:form></a>
                    </div>
                </li>
                
                <li class="nav-item dropdown">
                    <div class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Sucursales
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" style="background-color: #343a40"><html:form action="/sucursales">
                            <html:link page="/formSucursales.jsp" styleClass="btn btn-outline-info">Ingresar Sucursal</html:link>
                        </div>
                        <div class="dropdown-item" style="background-color: #343a40">
                            <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Sucursales</html:submit> 
                        </html:form></div>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <div class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Proveedores
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" style="background-color: #343a40"><html:form action="/proveedores">
                            <html:link page="/formProveedores.jsp" styleClass="btn btn-outline-info">Ingresar Proveedor</html:link>
                        </div>
                        <div class="dropdown-item" style="background-color: #343a40">
                            <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Proveedores</html:submit> 
                        </html:form></div>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <div class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Inventarios
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" style="background-color: #343a40"><html:form action="/inventario">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Inventarios</html:submit> 
                        </html:form></div>
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
                    <html:form action="/facturas">
                        <div class="card">
                            <div class="card bg-info text-white">
                                <div class="card-header">Actualizar Factura</div>
                            </div>
                            <div class="card-body">
                                <html:hidden property="idFactura"></html:hidden>

                                    <div class="row">
                                        <div class="form-group col-md-3">
                                        <label form="n_documento">Numero de serie de factura:</label><br>
                                        <html:text property="NDocumento" styleClass="form-control"></html:text>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label form="id_sucursal">Producto</label><br>
                                        <html:select property="idSucursal" styleClass="form-control">
                                            <html:option value="--Seleccionar--"></html:option>
                                            <logic:notEmpty name="ActionFormFacturas" property="listaSuc">
                                                <logic:iterate id="ft" name="ActionFormFacturas" property="listaSuc">
                                                    <html:option value="${ft.idSucursal}">${ft.sucursal}</html:option>
                                                </logic:iterate>
                                            </logic:notEmpty>
                                        </html:select>
                                    </div>
                                    
                                    </div>

                                    
                            </html:form>
                                 <div hidden="hidden"><html:text property="fechaVenta"></html:text></div>
                                    </div>
                                      </table><br>
                           <html:submit styleClass="btn btn-primary" property="action" value="Modificar" />
                           <html:submit styleClass="btn btn-primary" property="action" value="Volver"/>
                        <br>
                        <bean:write name="ActionFormFacturas" property="error" filter="false"/>
                        </div>
                    </div>
                </div>
                <div id="error" hidden="hidden">${error}</div>
                <div id="mensaje" hidden="hidden">${mensaje}</div>
                <div id="info" hidden="hidden">${info}</div>
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

