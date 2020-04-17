<%-- 
    Document   : consultas_pagos
    Created on : 2/02/2020, 11:56:09 PM
    Author     : manue
--%>
<%@page import="modelo.Casa"%>
<%@page import="modelo.PagoServicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/tablas.css">
        <title>Consultar Pagos</title>
    </head>
    <script type="text/javascript">
        function ShowSelected()
        {
            alert("!");
            var cod = document.getElementById("cmbCasa").value;
            alert(cod);
            document.base.valorcmbCasa.value = cod;
            var combo = document.getElementById("cmbCasa");
            var selected = combo.options[combo.selectedIndex].text;
            alert(selected);
        }
    </script>
    <body>
        <form name="base" action="consultas_pagos.jsp">
            <input type="hidden" name="valorcmbCasa"  value="10101"/>
            <h1>Consulta de pagos realizados: </h1>

            <p>
                Elija el Id de la casa a consultar:
            </p>
            <select id="cmbCasa" name="cmbCasa" onchange="submit();">
                <%for (int elem : new Casa().obtenerCasas()) {%>
                <option value="<%=elem%>"><%=elem%></option>
                <%}%>
            </select>
            <table border="0">
                <thead>
                    <tr>
                        <th>Id servicio</th>
                        <th>id casa</th>
                        <th>Mes</th>
                        <th>Descripcion de pago</th>
                        <th>Fecha</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (request.getParameter("cmbCasa") != null) {
                            String id_casa = request.getParameter("cmbCasa");
                            //System.out.println(" Este es el id " + id_casa);
                            PagoServicio pago = new PagoServicio();
                            pago.setId_casa(Long.parseLong(id_casa));
                            // pago.setId_casa(Integer.parseInt(id_casa.trim()));
                            for (PagoServicio elem : pago.pagoCasa()) {

                    %>
                    <tr>
                        <td><%=elem.getId_servicio()%></td>
                        <td><%=elem.getId_casa()%></td>
                        <td><%=elem.getId_mes()%></td>
                        <td><%=elem.getDescripcion()%></td>
                        <td><%=elem.getFechaPago()%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </form>
    </body>
</html>