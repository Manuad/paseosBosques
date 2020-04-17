<%-- 
    Document   : alta_residente
    Created on : 30/01/2020, 11:59:41 AM
    Author     : manue
--%>

<%@page import="modelo.Casa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/estilo_altas.css">
        <title>Alta residente</title>
    </head>
    <body>
        <main>
            <div class="content-all">
                <header></header>
                <input type="checkbox" id="check">
                <label for="check" class="icon-menu">Menu</label>
                <h2>Sistema Integral de Administración de Fraccionamientos</h2>
                <nav class="menu">
                    <ul>
                        <li ><a href="alta_usuario.html">Alta de administrador</a></li>
                        <li><a href="alta_residente.jsp">Alta de residente</a></li>
                        <li><a href="pago_servicio.jsp">Pago de servicios</a></li>
                        <li><a>Pago de servicios</a></li>
                        <li>Consultas</li>
                    </ul>
                </nav>
                <article>
                    <h1>Alta de residente Paseos del Bosque I</h1>
                    <p class="parrafo1">Ubicado en los Héroes Tecámac Edo. México</p>

                </article>
            </div>
            <div class="content-all">
                <form name="alta_residente" method="post" action="guarda_residente.jsp" onsubmit="" >
                    <article>
                    <p>Seleccione el tipo de residente:
                        <select name="tipo_residente"> 
                            <option value="1" >Dueño</option>
                            <option value="2">Habitante</option>
                            <option value="3">Inquilino</option>
                        </select>
                    </p>
                    <p>Indica el identidficador de la residencia: 
                        <select name="cmbCasa">
                            <%for (int elem : new Casa().obtenerCasas()) {
                            %>
                            <option value="<%=elem%>"><%=elem%></option>
                            <%}%>
                        </select>
                    </p>
                    <p>Nombre:<input type="text" name="nombres" placeholder="Ingrese el nombre"></p>
                    <p>Apellidos:<input type="text" name="apellidos" placeholder="Ingrese los apellidos"></p>
                    <p>C.U.R.P.:<input type="text" name="curp" placeholder="Ingrese el curp"></p>
                    <button class="btn-primary" name="btn_guardar" type="submit">Guardar</button>
                    </article>
                </form>
            </div>
        </main>
    </body>
</html>
