
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

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
    </head>
    <body style="background-image: url('img/gris.jpg'); background-repeat: no-repeat; background-size: cover;">

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
                        Sucursales
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href=""><html:link page="/AgregarSucursales.jsp" styleClass="btn btn-outline-info">Ingresar Sucursal</html:link></a>
                        <a class="dropdown-item" href=""><html:form action="/sucursales">
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

            <div class="container" style="margin-top: 20px">
                <div class="row">
                    <div class="col-12 text-center">
                        <div class="alert alert-success" role="alert">
                            <h4 class="alert-heading">Bienvenido</h4>

                            <p class="mb-0"> Porfavor, ingrese los datos  de los productos completos en el registro</p>
                        </div>
                    </div>  
                </div> 
                <br>
                <h1>ESTE ES EL METODO ACTUALIZAR</h1>
                <br>
                <div class="row">
                    <div class="col-12">
                    <html:form action="/sucursales">
                        <div hidden="hidden"><html:text property="idSucursal"></html:text></div>
                        <table border="0" class="table-striped">
                            <tbody style="margin: 5px;">
                                <tr  style="padding: 10px;">
                                    <td> Sucursal:</td>     
                                </tr>
                                <tr  style="padding: 10px;">
                                    <td><html:text property="sucursal" size="120" maxlength="25"></html:text></td>
                                    </tr>
                                    <tr  style="padding: 10px;">
                                        <td> Dirección:</td>     
                                    </tr>
                                    <tr  style="padding: 10px;">
                                        <td><html:text property="direccion" size="120" maxlength="25"></html:text></td>
                                    </tr>
                                    <tr  style="padding: 10px;">
                                        <td>Municipio:</td>
                                    </tr>
                                    <tr  style="padding: 10px;">
                                        <td><html:text property="municipio" size="120" maxlength="25"></html:text></td>
                                    </tr>
                                    <tr  style="padding: 10px;">
                                        <td>Departamento:</td>
                                    </tr>
                                    <tr  style="padding: 10px;">
                                        <td><html:text property="departamento" size="120" maxlength="25"></html:text></td>
                                    </tr>
                                    </tr>
                                    <tr  style="padding: 10px;">
                                        <td>Telefono:</td>
                                    </tr>
                                    <tr  style="padding: 10px;">
                                        <td><html:text property="telefono" size="120" maxlength="25"></html:text></td>
                                    </tr>
                                <br>
                                <tr colspan="2">
                                <bean:write name="SucursalesActionForm" property="error" filter="false"/>
                            </tr><br>
                            </tbody>
                        </table><br>
                        <html:submit styleClass="btn btn-primary" property="action" value="Modificar"/>
                        <html:submit styleClass="btn btn-primary" property="action" value="Volver"/>
                    </html:form>

                </div>
            </div>
        </div>
    </body>
</html>