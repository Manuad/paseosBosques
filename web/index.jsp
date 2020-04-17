<%-- 
    Document   : login
    Created on : 6/02/2020, 04:15:27 PM
    Author     : manue
--%>
<%@page import="modelo.Usuario"%>
<%
    Usuario us = new Usuario();
    if (request.getParameter("btn_entrar") != null) {
        us.setNombres(request.getParameter("usuario"));
        us.setContra(request.getParameter("contra"));
        if (us.loginUsuarios() == 1) {
            response.sendRedirect("registro_visitante.jsp");
        } else {
%>
<script>alert("Usuario no disponible");</script>
<%
        }
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/estilo_altas.css">
        <title>Iniciar Sesión</title>
    </head>
    <body>
        <main>
            <div class="content-all">
                <header></header>
                    
                <article>
                    <h1>Paseos del Bosque I</h1>
                    <p class="parrafo1">Ubicado en los Héroes Tecámac Edo. México</p>
                </article>
            </div>
            <div class="container">
                <header></header>
                <h2>Bienvenido al Sistema Integral de Administración de Fraccionamientos</h2>
                <form action="index.jsp" name="formlogin">
                    <p class="container">
                        <label >Usuario:</label> <input type="text" name="usuario"><br><br>
                        <label >Contraseña:</label> <input type="password" name="contra"><br><br>
                        <input type="submit" name="btn_entrar" value="Entrar">
                    </p>
                </form>
            </div>
        </main>
    </body>
</html>