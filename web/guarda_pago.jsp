<%-- 
    Document   : guarda_pago
    Created on : 2/02/2020, 10:06:06 PM
    Author     : manue
--%>

<%@page import="modelo.Servicios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guardar Pago de Servicios</title>
    </head>
    <body>
        <%
            String servicio = request.getParameter("cmbMantenimiento");
            String id_casa = request.getParameter("cmbCasa");
            String num_mes = request.getParameter("mes");
            String desc = request.getParameter("descripcion");
            Servicios pservicio = new Servicios();
            pservicio.setId_servicio(Integer.parseInt(servicio));
            pservicio.setId_casa(Integer.parseInt(id_casa));
            pservicio.setNum_mes(Integer.parseInt(num_mes));
            pservicio.setDescripcion(desc);
            pservicio.pagoServicios();
        %>
    </body>
    <form action="registro_visitante.jsp" >
        <p class="container">
            <input type="submit" value="Ir a registrar visitante"> 
        </p>
    </form>
</html>
