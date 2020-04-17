<%-- 
    Document   : alta_servicio
    Created on : 2/02/2020, 07:59:48 PM
    Author     : manue
--%>
<%@page import="modelo.Casa"%>
<%@page import="modelo.Servicios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pago de servicios</title>
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
                        <li><a href="">Pago de servicios</a></li>
                        <li><a>Pago de servicios</a></li>
                        <li>Consultas</li>
                    </ul>
                </nav>
                <article>
                    <h1>Pago de Servicios Paseos del Bosque I</h1>
                    <p class="parrafo1">Ubicado en los Héroes Tecámac Edo. México</p>

                </article>
            </div>
            <div class="content-all">
                <form name="alta_residente" method="post" action="guarda_pago.jsp" onsubmit="" >
                    <article>
                    <p>Seleccione el servicio:
                        <select name="cmbMantenimiento"> 
                            <option value="1" >Mantenimiento</option>
                            <option value="2">Gimnasio</option>
                            <option value="3">Alberca</option>
                        </select>
                    </p>
                    <p>Indique el identificador de la residencia: 
                            <select name="cmbCasa">
                                <%for (int elem : new Casa().obtenerCasas()) {%>
                                <option value="<%=elem%>"><%=elem%></option>
                                <%}%>
                            </select>
                        </p>
                    <p>Número del mes:<input type="text" name="mes" placeholder="Ingrese el número del mes"></p>
                    <p>Descripción: <input type="text" name="descripcion" placeholder="Descripción"></p>
                    <button class="btn-primary" name="btn_guardar" type="submit">Guardar</button>
                    </article>
                </form>
            </div>
        </main>
    </body>
</html>
