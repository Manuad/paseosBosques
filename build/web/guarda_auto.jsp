<%-- 
    Document   : guarda_auto
    Created on : 31/01/2020, 08:04:00 PM
    Author     : manue
--%>

<%@page import="modelo.Auto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/estilo_menu.css">
        <title>Alta vehículo</title>
    </head>
    <%
        String id_casa = request.getParameter("cmbCasa");
        String placa = request.getParameter("placa");
        String folio = request.getParameter("folio");
        String descripcion = request.getParameter("description");
        Auto auto = new Auto();
        auto.setId_casa(Integer.parseInt(id_casa));
        auto.setPlaca(placa);
        auto.setFolio(folio);
        auto.setTipo(descripcion);
        auto.insertAuto();
        
    %>
    <body>
        <h1>Se ha dado de alta el automóvil <%=descripcion%> con placas <%=placa%> exitosamente</h1>
    </body>
</html>
