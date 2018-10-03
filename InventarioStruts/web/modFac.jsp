
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link href="css/Style.css" rel="stylesheet">
    </head>
    <body class="bg ">
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
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Ingresar Producto"></html:submit>
                                </div>
                                <div class="dropdown-item" style="background-color: #343a40">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar"></html:submit> 
                            </html:form></div>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <div class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Compras
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" style="background-color: #343a40"><html:form action="/compras">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Ingresar Compra"></html:submit>
                                </div>
                                <div class="dropdown-item" style="background-color: #343a40">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar"></html:submit> 
                                </div>
                                <div class="dropdown-item" style="background-color: #343a40">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Todas las Compras"></html:submit> 
                            </html:form></div>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <div class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Ventas
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" style="background-color: #343a40"><html:form action="/ventas">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Agregar Ventas"></html:submit>
                                </div>
                                <div class="dropdown-item" style="background-color: #343a40">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar"></html:submit> 
                                </div>
                                <div class="dropdown-item" style="background-color: #343a40">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Archivo Ventas"></html:submit> 
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
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar"></html:submit> 
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
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar"></html:submit> 
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
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar"></html:submit> 
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
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar"></html:submit> 
                            </html:form></div>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <div class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        Inventarios
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" style="background-color: #343a40"><html:form action="/inventario">
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Consultar"></html:submit> 
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

            <div class="container" style="margin-top: 20px">


                <div class="row">
                    <div class="col-12 text-center">
                        <h3> Actualizar Fabricantes</h3>  
                    </div>  
                </div> 

                <div class="row">
                    <div class="col-8">
                    <html:form action="/fabricantes">
                        <div hidden="hidden"><html:text property="idFabricante"></html:text></div> 
                            <table border="0" class="table-striped">
                                <tbody style="margin: 5px;">


                                    <tr  style="padding: 10px;">
                                        <td>Nombre del fabricante
                                        <html:text property="fabricante" size="70" maxlength="50"></html:text></td>     
                                    </tr>
                                    <tr  style="padding: 10px;">
                                        <td>Direccion del Fabricante
                                        <html:text property="direccion" size="70" maxlength="50"></html:text></td>
                                    </tr>
                                    <tr  style="padding: 10px;">
                                        <td>Telefono del Fabricante:
                                        <html:text property="telefono" size="70" maxlength="15"></html:text>
                                    </tr>
                                <br>
                                <tr colspan="2">
                                </tr><br>
                                </tbody>
                            </table><br>
                        <html:submit styleClass="btn btn-primary" property="action" value="Modificar" />
                        <html:submit styleClass="btn btn-primary" property="action" value="Volver"/>
                        <br><br>
                        <bean:write name="ActionFormFabricantes" property="error" filter="false"/>
                    </html:form>
                </div>
            </div>
        </div>
        ${mensaje}
    </body>
</html>
