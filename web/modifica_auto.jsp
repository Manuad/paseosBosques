<%
    if(request.getParameter("btn_editar")!=null){
        Auto a  = new Auto();
        a.setId_casa(Long.parseLong(request.getParameter("id_casa")));
        a.setPlaca(request.getParameter("placa"));
        a.setFolio(request.getParameter("folio"));
        a.setTipo(request.getParameter("tipo"));
        a.setId_auto(Long.parseLong(request.getParameter("id_automovil")));
        a.updateAuto();
    }
%>
<%@page import="modelo.Auto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar registro de automoviles</h1>
        <form name="form_datos_auto" method="POST" action="modifica_auto.jsp">
            <%
                if (request.getParameter("a") != null) {
                    Auto a4 = new Auto();
                    a4.setId_auto(Long.parseLong(request.getParameter("a")));
                    for (Auto a5 : a4.visualizarAuto()) {
            %>
            <label>Id casa:</label>&nbsp; <input type="text" name="id_casa" value="<%=a5.getId_casa()%>"><br><br>
            <label>Placas: </label>&nbsp; <input type="text" name="placas" value="<%=a5.getPlaca()%>"><br><br>
            <label>Folio: </label>&nbsp; <input type="text" name="folio" value="<%=a5.getFolio()%>"><br><br>
            <label>Tipo: </label>&nbsp; <input type="text" name="tipo" value="<%=a5.getTipo()%>"><br><br>
            <input type="hidden" name="id_automovil" value="<%=a5.getId_auto()%>">
            <button class="btn-primary" name="btn_editar" type="submit">Actualizar</button>
            <%
                }
            } else {
            %>
            <label>Id casa: </label> &nbsp; <input type="text" name="id_casa" placeholder="Ingresa el identificador de la casa:"><br><br>
            <label>Placas: </label> &nbsp; <input type="text" name="placa" placeholder="Placas del automóvil"><br><br>
            <label>Folio: </label> &nbsp; <input type="text" name="folio" placeholder="Folio del corbatin"><br><br>
            <label>Tipo: </label> &nbsp; <input type="text" name="tipo" placeholder="Tipo de auto">
            <%}%>
        </form>
        <table border="0">
            <thead>
                <tr>
                    <th>Id casa:</th>
                    <th>Placas: </th>
                    <th>Folio: </th>
                    <th>Tipo: </th>
                </tr>
            </thead>
            <tbody>
                <%
                    Auto a2 = new Auto();
                    for(Auto a3 : a2.obtenerAuto()){
                %>
                <tr>
                    <td><%=a3.getId_casa()%></td>
                    <td><%=a3.getPlaca()%></td>
                    <td><%=a3.getFolio()%></td>
                    <td><%=a3.getTipo()%></td>
                    <td><a href="modifica_auto.jsp?a=<%=a3.getId_auto()%>">Editar</a></td>
                </tr><%}%>
            </tbody>
        </table>

    </body>
</html>
