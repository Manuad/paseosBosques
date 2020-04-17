<%-- 
    Document   : alta_vehiculo
    Created on : 31/01/2020, 07:37:30 PM
    Author     : manue
--%>

<%@page import="modelo.Auto"%>
<%@page import="modelo.Casa"%>
<%
    Auto au = new Auto();
    if (request.getParameter("btn_guardar") != null) {
        au.setPlaca(request.getParameter("placa"));
        au.setFolio(request.getParameter("folio"));
        au.setTipo(request.getParameter("description"));
    } else {
%>
<script>alert("Alguno de los campos esta vacio");</script>
<%
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="txt/css" href="CSS/estilo_altas.css">
        <title>Alta vehículo</title>
    </head>
    <body>
        <h1>Alta de vehículo Paseos del Bosque I</h1>
        <div>
            <form name="alta_vehiculo" method="post" action="guarda_auto.jsp" onsubmit="" >
                <label >Seleccione el identificador de la casa: </label> &nbsp;
                <select name="cmbCasa">
                    <%for (int casa : new Casa().obtenerCasas()) {
                    %>
                    <option value="<%=casa%>"><%=casa%></option>
                    <%}%>
                </select><br><br>
                <label>Placa: </label> &nbsp;&nbsp;&nbsp; <input type="text" name="placa" placeholder="Ingresa la placa del autóvil"> <br><br>
                <label>Folio: </label> &nbsp; <input type="text" name="folio" placeholder="Ingresa el folio de entrada"> <br><br>
                <label>Descricpción: </label> &nbsp;&nbsp; <input type="text" name="description" placeholder="Descripción"> <br><br>
                <button class="btn-primary" name="btn_guardar" type="submit">Guardar</button>
            </form>
        </div>
    </body>
</html>
