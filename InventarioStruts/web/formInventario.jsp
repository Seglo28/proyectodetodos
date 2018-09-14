
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Agregar Inventario</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
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
                    toastr.error('Usuario no Registrado', 'Error!');
                    toastr.success('Se guardaron los cambios satisfactoriamente', 'Todo en orden');
                    toastr.warning('La latencia del server esta aumentando.', 'Alerta!');
                } else {
                    toastr.error('no se puede!\'t.', 'Otro error crítico');
                }
            }

            // Definimos los callback cuando el TOAST le da un fade in/out:
            toastr.options.onFadeIn = function() {
                showToastrs = true;
            };
            toastr.options.onFadeOut = function() {
                showToastrs = false;
            };

            $(function() {
                $("#clear").on("click", function() {
                // Clears the current list of toasts
                toastr.clear();
            });
            $("#rewind").on("click", function() {
            // show toastrs :)
            toastrs();
            });
            });
        </script>
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
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Inventarios
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href=""><html:form action="/inventario">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Agregar Inventario">Agregar</html:submit>
                            </html:form></a>
                        <a class="dropdown-item" href=""><html:form action="/inventario">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Inventarios</html:submit> 
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
                <html:form action="/inventario">
                    <div class="card">
                        <div class="card bg-success text-white">
                            <div class="card-header">Ingresar Inventario</div>
                        </div>
                        <div class="card-body bg-light">
                            
                            <div class="row">
                                <div class="form-group col-md-4">
                                    <label>Producto</label><br>
                                    <html:select property="idProducto">
                                        <html:option value="">-- Seleccionar --</html:option>
                                        <logic:notEmpty name="ActionFormInventario" property="listProd">
                                            <logic:iterate id="prod" name="ActionFormInventario" property="listProd">
                                                <html:option value="${prod.idProducto}">${prod.producto}</html:option>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </html:select>
                                </div>
                                <div class="form-group col-md-4">
                                    <label>Cant</label><br>
                                    <html:text property="cant" size="25" maxlength="25"></html:text>
                                </div>
                                <div class="form-group col-md-4">
                                    <label>Stock</label><br>
                                    <html:text property="stock" size="25" maxlength="25"></html:text>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-4">
                                    <label>Estado</label><br>
                                    <html:select property="estado">
                                        <html:option value="Disponible">Disponible</html:option>
                                        <html:option value="Stock">Stock</html:option>
                                        <html:option value="Sin Existencias">Sin Existencias</html:option>
                                    </html:select>
                                </div>
                                <div class="form-group col-md-4">
                                    <label>Proveedor</label><br>
                                    <html:select property="idProveedor">
                                        <html:option value="-- Seleccionar --"></html:option>
                                        <logic:notEmpty name="ActionFormInventario" property="listProv">
                                            <logic:iterate id="prov" name="ActionFormInventario" property="listProv">
                                                <html:option value="${prov.idProveedor}">${prov.proveedor}</html:option>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </html:select>
                                </div>
                                <div class="form-group col-md-4">
                                    <label>Sucursal</label><br>
                                    <html:select property="idSucursal">
                                        <html:option value="-- Seleccionar --"></html:option>
                                        <logic:notEmpty name="ActionFormInventario" property="listSuc">
                                            <logic:iterate id="suc" name="ActionFormInventario" property="listSuc">
                                                <html:option value="${suc.idSucursal}">${suc.sucursal}</html:option>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </html:select>
                                </div>
                            </div>
                            <html:submit styleClass="btn btn-outline-success" property="action" value="Insertar">Insertar</html:submit>
                        </div>
                    </div><br>
                    <div id="info" hidden="hidden">${mensaje}</div>
                </html:form>
                </div>
            </div>

        </div>
    </body>
</html>
