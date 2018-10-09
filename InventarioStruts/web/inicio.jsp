 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control Inventario - Inicio</title>
        <link rel="icon" href="img/logo.png">
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script src="http://codeseven.github.com/toastr/toastr.js"></script>
        <link href="http://codeseven.github.com/toastr/toastr.css" rel="stylesheet"/>
        <link href="http://codeseven.github.com/toastr/toastr-responsive.css" rel="stylesheet"/>
        <link href="css/Style.css" rel="stylesheet">
        <style>
            .how-section1{
                margin-top:-15%;
                padding: 10%;
            }
            .how-section1 h4{
                color: #ffa500;
                font-weight: bold;
                font-size: 30px;
            }
            .how-section1 .subheading{
                color: #3931af;
                font-size: 20px;
            }
            .how-section1 .row
            {
                margin-top: 10%;
            }
            .how-img 
            {
                text-align: center;
            }
            .how-img img{
                width: 40%;
            }
            .p{
                color:#0b2e13;
            }
        </style>
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
                                <html:submit styleClass="btn btn-outline-info" property="action" value="Archivadas"></html:submit> 
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
                       Moneda
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" style="background-color: #343a40"><html:form action="/monedas">
                                <html:link page="/formMON.jsp" styleClass="btn btn-outline-info">Ingresar Moneda</html:link>
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

        <div class="container">
            <br>
            <div class="how-section1">
                <div class="row">
                    <div class="col-md-6 how-img">
                        <img src="https://image.ibb.co/dDW27U/Work_Section2_freelance_img1.png" class="rounded-circle img-fluid" alt=""/>
                    </div>
                    <div class="col-md-6">
                        <h4>Registre las personas para su acceso.</h4>
                        <h4 class="subheading">En usuarios puede registrar las personas encargadas del control de inventarios. </h4>
                        <p class="text-muted"> Tenga  en cuenta que solo el personal responsable puede tener acceso a la aplicación, por lo cual se recomienda otorgar un usuario para mejor control.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <h4> Accesibilidad garantizada.</h4>
                        <h4 class="subheading"> Con ayuda de  la barra navegadora en la parte superior puede dirigirse al menu, al cual desea ingresar.</h4>
                        <p class="text-muted">Al dar Click a uno de  los botones del menu sera redireccionado de forma inmediata.</p>
                    </div>
                    <div class="col-md-6 how-img">
                        <img src="https://image.ibb.co/cHgKnU/Work_Section2_freelance_img2.png" class="rounded-circle img-fluid" alt=""/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 how-img">
                        <img src="https://image.ibb.co/ctSLu9/Work_Section2_freelance_img3.png" class="rounded-circle img-fluid" alt=""/>
                    </div>
                    <div class="col-md-6">
                        <h4>Acciones seguras.</h4>
                        <h4 class="subheading">Cada formulario  y accion a realizar pueden ser verificadas antes de aceptar su ejecución. </h4>
                        <p class="text-muted">Mensajes de advertencia y botones de confirmación  según la opción a ejecutar.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <h4>Administracion de Inventarios y movimientos relacionados.</h4>
                        <h4 class="subheading">En  los menus de consulta puede actualizar o archivar sus movimientos</h4>
                        <p class="text-muted"> Con un click en   el menu de  inventarios  puede acceder a las opciones  desplagables que ofrece, verificando productos, stock, entradas y salidas de los mismos según sus movimientos</p>
                    </div>
                    <div class="col-md-6 how-img">
                        <img src="https://image.ibb.co/gQ9iE9/Work_Section2_freelance_img4.png" class="rounded-circle img-fluid" alt=""/>
                    </div>
                </div>
            </div>
                    
        </div>
    </body>
</html>
