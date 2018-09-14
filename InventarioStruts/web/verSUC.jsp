<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agreagar Sucursal</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
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
                                <th>id</th>
                                <th>Sucursal</th>
                                <th>Dirección</th>
                                <th>Municipio</th>
                                <th>Departamento</th>
                                <th>Teléfono</th>
                                <th>Actualizar</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                        <logic:notEmpty name="ActionFormSucursales" property="listaSUC">
                            <logic:iterate id="sucursales" name="ActionFormSucursales" property="listaSUC">
                                <tr>
                                    <html:form action="/sucursales">
                                    <td><bean:write name="sucursales" property="idSucursal"/>
                                        <div hidden="hidden"><html:text  name="sucursales" property="idSucursal"></html:text></div> </td>
                                    <td><bean:write name="sucursales" property="sucursal"/></td>
                                    <td><bean:write name="sucursales" property="direccion"/></td>
                                    <td><bean:write name="sucursales" property="municipio"/></td>
                                    <td><bean:write name="sucursales" property="departamento"/></td>
                                    <td><bean:write name="sucursales" property="telefono"/></td>
                                    <td><html:submit styleClass="btn btn-success" property="action" value="Actualizar"/></td>
                                    <td><html:submit styleClass="btn btn-danger" property="action" value="Eliminar"/></td>
                                </html:form>
                                    </tr>
                            </logic:iterate>
                        </logic:notEmpty>
                        </tbody>
                    </table>
                </div>
                <div class="col-4">
                    ${error}
                    ${mensaje}
                </div>
            </div>
                </div>
    </body>
</html>
