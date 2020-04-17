<%
    if(request.getParameter("btn_editar")!=null){
        Usuario u=new Usuario();
        u.setNombres(request.getParameter("nombres"));
        u.setApellidos(request.getParameter("apellidos"));
        u.setCurp(request.getParameter("curp"));
        u.setContra(request.getParameter("contra1"));
        u.setIdu(Long.parseLong(request.getParameter("id_us")));
        u.actualizarUsuario();
    }
%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Usuarios</title>
    </head>
    <body>
        <h1>Sistema Integral de Administración de Fraccionamientos</h1>
        <form name="form_datos_usuario" method="POST" action="modificar_datos_usuario.jsp">
            <%
                if (request.getParameter("a") != null) {
                    Usuario u4 = new Usuario();
                    u4.setIdu(Long.parseLong(request.getParameter("a")));
                    for (Usuario u5 : u4.obtenerUsuario2()) {

            %>
            <label>Nombre:   </label> &nbsp;&nbsp;&nbsp; <input type="text" name="nombres" value="<%=u5.getNombres()%>"> <br><br>
            <label>Apellidos: </label> &nbsp; <input type="text" name="apellidos" value="<%=u5.getApellidos()%>"> <br><br>
            <label>C.U.R.P.: </label> &nbsp;&nbsp; <input type="text" name="curp" value="<%=u5.getCurp()%>"> <br><br>
            <label>Constraseña: </label> &nbsp; <input type="password" name="contra1" value="<%=u5.getContra()%>"> <br><br>
            <label>Constraseña: </label> &nbsp; <input type="password" name="contra2" value="<%=u5.getContra()%>"> <br><br>
            <input type="hidden" name="id_us" value="<%=u5.getIdu()%>">
            <button class="btn-primary" name="btn_editar" type="submit">Actualizar</button>
            
            <%}
            } else {%>

            <label>Nombre:   
            </label> &nbsp;&nbsp;&nbsp; <input type="text" name="nombres" placeholder="Ingresa el nombre"> <br><br>
            <label>Apellidos: </label> &nbsp; <input type="text" name="apellidos" placeholder="Ingresa los apellidos"> <br><br>
            <label>C.U.R.P.: </label> &nbsp;&nbsp; <input type="text" name="curp" placeholder="Ingresa el curp"> <br><br>
            <label>Constraseña: </label> &nbsp; <input type="password1" name="contra1" placeholder="Ingrese la contraseña"> <br><br>
            <label>Constraseña: </label> &nbsp; <input type="password2" name="contra2" placeholder="Repita la contraseña"> <br><br>
            <%}%>
        </form>
        <table>
            <tr>
                <td>Nombres</td>
                <td>Apellidos</td>
                <td>CURP</td>
                <td>Fecha de alta</td>
            </tr>
            <%
                Usuario u2 = new Usuario();
                for (Usuario u3 : u2.obtenerUsuario()) {
            %>
            <tr>
                <td><%=u3.getNombres()%></td> 
                <td><%=u3.getApellidos()%></td>
                <td><%=u3.getCurp()%></td>
                <td><%=u3.getFecha_alta()%></td>
                <td><a href="modificar_datos_usuario.jsp?a=<%=u3.getIdu()%>">Editar</a></td>
            </tr><%}%>
        </table>
        
    </body>
</html>
