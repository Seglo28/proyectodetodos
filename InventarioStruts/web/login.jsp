
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
    </head>
    <body style="background-image: url('img/login.jpg'); background-repeat: no-repeat; background-size: cover;">
        <div class="container" style="margin-top: 20px">
            <div class="row">
                <div class="col-12">
                    <html:form action="/user">
                        <div class="card">
                            <div class="card bg-success text-white">
                                <div class="card-header">Inicio de Sesión</div>
                            </div>
                            <div class="card-body">
                                <label>Correo:</label><br>
                                <html:text property="correo" size="120" maxlength="25" value=""></html:text><br>
                                    <label>Contraseña:</label><br>
                                <html:password property="contra" size="120" maxlength="25" value=""></html:password>
                                    <br><br>
                                <html:submit styleClass="btn btn-outline-success" property="action" value="Entrar">Entrar</html:submit>
                            </div>
                        </div>
                        <br>
                        <bean:write name="ActionFormUser" property="error" filter="false"/>
                    </html:form>
                </div>
            </div>
        </div>
    </body>
</html>
