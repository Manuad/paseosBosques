<%-- 
    Document   : guarda_residente
    Created on : 29/01/2020, 09:55:16 PM
    Author     : manue
--%>

<%@page import="modelo.Residente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Alta residente</title>
    </head>
    <%
        String tipo_residente = request.getParameter("tipo_residente");
        String id_casa = request.getParameter("cmbCasa");
        String nombre = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String curp = request.getParameter("curp");
        Residente re = new Residente();
        re.setTipo_residente(Integer.parseInt(tipo_residente));
        re.setId_casa(Integer.parseInt(id_casa));
        re.setNombre(nombre);
        re.setApellidos(apellidos);
        re.setCurp(curp);
        re.insertaResidente();
    %>
    <body>
        <h1>Residente <%=nombre %> dado de alta con éxito</h1>
    </body>
</html>
