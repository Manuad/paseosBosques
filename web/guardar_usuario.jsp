<%-- 
    Document   : guardar_usuario
    Created on : 28/01/2020, 10:39:34 PM
    Author     : manue
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/estilo_menu.css">
        <title>Editar usuarios</title>
    </head>
    <%
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String curp = request.getParameter("curp");
        String contra1 = request.getParameter("contra1");
        String contra2 = request.getParameter("contra2");
        Usuario u = new Usuario();
        u.setNombres(nombres);
        u.setApellidos(apellidos);
        u.setCurp(curp);
        u.setContra(contra1);
        if (!contra1.isEmpty() && !contra2.isEmpty()) {
            if (!contra1.equals(contra2)) {
                System.out.print("Las contraseñas no coinciden");
            } else {
                u.insertaUsuario();
            }
        } else {
            System.out.println("Ingrese contraseñas");
        }
    %>
    <body>
        <h1>Usuario: 
            <%=u.getNombres()%> &nbsp;
            <%=u.getApellidos()%> &nbsp; dado de alta con éxito
        </h1>
        <form name="uform" action="alta_residente.jsp" method="POST">
            <label >¿Desea agregar un nuevo residente? </label> &nbsp; <button class="btn-primary" name="agregar" type="submit" a="alta_residente.jsp">Agregar</button>
            <label >¿Desea editar datos de algún usuario? </label> &nbsp; <button class="btn-primary" name="agregar" type="submit" >Aceptar</button>
        </form>
    </body>
</html>
