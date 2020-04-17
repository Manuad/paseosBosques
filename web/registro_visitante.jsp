<%
    Visitante visit = new Visitante();
    if (request.getParameter("btn_guardar") != null) {
        if (!request.getParameter("cmbCasa").isEmpty()
                && !request.getParameter("nombres").isEmpty()
                && !request.getParameter("apellidos").isEmpty()
                && !request.getParameter("documento").isEmpty()
                && !request.getParameter("descripcion").isEmpty()
                && !request.getParameter("medio").isEmpty()) {
            String id_casa = request.getParameter("cmbCasa");
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String documento = request.getParameter("documento");
            String descripcion = request.getParameter("descripcion");
            String medio = request.getParameter("medio");
            visit.setId_casa(Integer.parseInt(id_casa));
            visit.setNombres(nombres);
            visit.setApellidos(apellidos);
            visit.setId_casa(Integer.parseInt(id_casa));
            visit.setDocumento(documento);
            visit.setDescripcion(descripcion);
            visit.setMedio(medio);
            visit.regsitraVisitante();
            visit.registraPaseVisitante();
            if (visit.registraPaseVisitante() == 1) {
                out.print("<script>alert('Datos correctos');</script>");
                response.sendRedirect("guarda_reg_visitante.jsp");
            }
        } else {
            out.print("<script>alert('Datos incorrectos');</script>");
        }

    }
%><%@page import="modelo.Visitante"%>
<%@page import="modelo.Casa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/estilo_altas.css">
        <title>Registro visitante</title>
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
                        <li><a href="modificar_datos_usuario.jsp">Actualizar datos de usuario</a></li>
                        <li><a href="alta_residente.jsp">Alta de residente</a></li>
                        <li><a href="alta_vehiculo.jsp">Alta de vehiculo</a></li>
                        <li><a href="pago_servicio.jsp">Pago de mantenimiento</a></li>
                        <li><a href="consulta_visitantes.jsp"></a>Consulta visitantes</li>
                        <li><a href=""></a></li>
                        <li><a href=""></a></li>
                    </ul>
                </nav>
                <article>
                    <h1>Registro de visitantes Paseos del Bosque I</h1>
                    <p class="parrafo1">Ubicado en los Héroes Tecámac Edo. México</p>
                </article>
            </div>
            <div class="content-all">
                <form name="registro_visitantes" method="POST" action="registro_visitante.jsp" >
                    <article>
                        <p>Indique el identificador de la residencia: 
                            <select name="cmbCasa">
                                <%for (int elem : new Casa().obtenerCasas()) {%>
                                <option value="<%=elem%>"><%=elem%></option>
                                <%}%>
                            </select>
                        </p>
                        <p>
                            <input type="text" name="nombres" placeholder="Nombre visitante">
                        </p><br>
                        <p>
                            <input type="text" name="apellidos" placeholder="Apellidos visitante">
                        </p><br>
                        <p>
                            <input type="text" name="documento" placeholder="Tipo de documento">
                        </p><br>
                        <p>
                            <input type="text" name="descripcion" placeholder="¿Cuantas personas ingresan?"><br>
                        </p><br>
                        <p>
                            <input type="text" name="medio" placeholder="Auto, modelo y placas"><br>
                        </p><br>
                        <input class="btn-primary" name="btn_guardar" value="Guardar" type="submit"><br>
                    </article>
                </form>
            </div>
        </main>
    </body>
    <!-- The core Firebase JS SDK is always required and must be listed first -->
    <script src="/__/firebase/7.10.0/firebase-app.js"></script>

    <!-- TODO: Add SDKs for Firebase products that you want to use
         https://firebase.google.com/docs/web/setup#available-libraries -->
    <script src="/__/firebase/7.10.0/firebase-analytics.js"></script>

    <!-- Initialize Firebase -->
    <script src="/__/firebase/init.js"></script>
</html>
