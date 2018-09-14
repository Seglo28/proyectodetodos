<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Fromulario de actualización de compras </title>
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
    </head>
    <body class="bg">
        
        <div class="container" style="margin-top: 20px">
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
                        <a class="dropdown-item" href=""><html:link page="/formProveedores.jsp" styleClass="btn btn-outline-info">Ingresar Proveedor</html:link></a>
                        <a class="dropdown-item" href=""><html:form action="/proveedores">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar">Lista de Proveedores</html:submit> 
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
                    
        <div class="container" style="margin-top: 20px">
            
            <br>
            <div class="row">
                <div class="col-12">
                    <h1> </h1>
                </div>
            </div>
             <div class="row">
                <div class="col-10 text-center">
                    <div class="alert alert-danger" role="alert">
                        <h6 class="alert-heading"> </h6>

                        <p class="mb-0"> ¿Se encuentra seguro de querer eliminar el registro seleccionado?</p>
                    </div>
                </div>  
            </div> 
            <div class="row">
                <div class="col-12 text-center">
                    <h3> </h3>  
                </div>  
            </div> 

            <div class="row">
                <div class="col-10">
                    <html:form action="/compras">
                         <div class="card">
                            <div class="card bg-info text-white">
                                <div class="card-header">Eliminar Compras</div>
                            </div>
                            <div class="card-body">
                                   <td>
                                       <div hidden="hidden"><html:text property="idCompras"></html:text></div> 
                                    <label form="id_producto">ID PRODUCTO</label><br>
                                    <html:select property="idProducto">
                                        <html:option value="--Seleccionar--"></html:option>
                                        <logic:notEmpty name="ActionFormCompras" property="listaProd">
                                            <logic:iterate id="prod" name="ActionFormCompras" property="listaProd">
                                                <html:option value="${prod.idProducto}">${prod.producto}</html:option>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </html:select>
                                    <br>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label form="id_proveedor">ID PROVEEDOR</label><br>
                                    <html:select property="idProveedor">
                                        <html:option value="--Seleccionar--"></html:option>
                                        <logic:notEmpty name="ActionFormCompras" property="listaProv">
                                            <logic:iterate id="prov" name="ActionFormCompras" property="listaProv">
                                                <html:option value="${prov.idProveedor}">${prov.proveedor}</html:option>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </html:select>
                                    <br>
                                </td>
                            </tr>                         
                            <tbody style="margin: 5px;">

                                <tr  style="padding: 10px;">
                                    <td>Cantidad: <br>
                                        <html:text property="cantidad" size="95" maxlength="10" ></html:text>
                                        </td>
                                    </tr>
                                    <tr  style="padding: 10px;">
                                    <td>Monto de la compra<br>
                                        <html:text property="monto" size="95" maxlength="" ></html:text>
                                        </td>
                                    </tr>
                                    <tr  style="padding: 10px;">
                                    <td>Fecha de la compra realizada: <br>
                                        <html:text property="fechaCompras" size="95" maxlength="25" ></html:text>
                                        </td>
                                    </tr>
                                    
                                <br>
                                <br>
                                <br>
                                
                                 <html:submit styleClass="btn btn-primary" property="action" value="Borrar" />
                          <html:submit styleClass="btn btn-primary" property="action" value="Volver"/>
                        <br><br>
                        <bean:write name="ActionFormCompras" property="error" filter="false"/>
                    </html:form>
                </div>
            </div>
      
        </div>
                <br>
                <br>
                <br>
         ${mensaje}
    </body>
</html>

