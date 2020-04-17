package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Usuario;

public final class modificar_005fdatos_005fusuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");


    if(request.getParameter("btn_editar")!=null){
        Usuario u=new Usuario();
        u.setNombres(request.getParameter("nombres"));
        u.setApellidos(request.getParameter("apellidos"));
        u.setCurp(request.getParameter("curp"));
        u.setContra(request.getParameter("contra1"));
        u.setIdu(Long.parseLong(request.getParameter("id_us")));
        u.actualizarUsuario();
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Modificar Usuarios</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Sistema Integral de Administración de Fraccionamientos</h1>\n");
      out.write("        <form name=\"form_datos_usuario\" method=\"POST\" action=\"modificar_datos_usuario.jsp\">\n");
      out.write("            ");

                if (request.getParameter("a") != null) {
                    Usuario u4 = new Usuario();
                    u4.setIdu(Long.parseLong(request.getParameter("a")));
                    for (Usuario u5 : u4.obtenerUsuario2()) {

            
      out.write("\n");
      out.write("            <label>Nombre:   </label> &nbsp;&nbsp;&nbsp; <input type=\"text\" name=\"nombres\" value=\"");
      out.print(u5.getNombres());
      out.write("\"> <br><br>\n");
      out.write("            <label>Apellidos: </label> &nbsp; <input type=\"text\" name=\"apellidos\" value=\"");
      out.print(u5.getApellidos());
      out.write("\"> <br><br>\n");
      out.write("            <label>C.U.R.P.: </label> &nbsp;&nbsp; <input type=\"text\" name=\"curp\" value=\"");
      out.print(u5.getCurp());
      out.write("\"> <br><br>\n");
      out.write("            <label>Constraseña: </label> &nbsp; <input type=\"password\" name=\"contra1\" value=\"");
      out.print(u5.getContra());
      out.write("\"> <br><br>\n");
      out.write("            <label>Constraseña: </label> &nbsp; <input type=\"password\" name=\"contra2\" value=\"");
      out.print(u5.getContra());
      out.write("\"> <br><br>\n");
      out.write("            <input type=\"hidden\" name=\"id_us\" value=\"");
      out.print(u5.getIdu());
      out.write("\">\n");
      out.write("            <button class=\"btn-primary\" name=\"btn_editar\" type=\"submit\">Actualizar</button>\n");
      out.write("            \n");
      out.write("            ");
}
            } else {
      out.write("\n");
      out.write("\n");
      out.write("            <label>Nombre:   \n");
      out.write("            </label> &nbsp;&nbsp;&nbsp; <input type=\"text\" name=\"nombres\" placeholder=\"Ingresa el nombre\"> <br><br>\n");
      out.write("            <label>Apellidos: </label> &nbsp; <input type=\"text\" name=\"apellidos\" placeholder=\"Ingresa los apellidos\"> <br><br>\n");
      out.write("            <label>C.U.R.P.: </label> &nbsp;&nbsp; <input type=\"text\" name=\"curp\" placeholder=\"Ingresa el curp\"> <br><br>\n");
      out.write("            <label>Constraseña: </label> &nbsp; <input type=\"password1\" name=\"contra1\" placeholder=\"Ingrese la contraseña\"> <br><br>\n");
      out.write("            <label>Constraseña: </label> &nbsp; <input type=\"password2\" name=\"contra2\" placeholder=\"Repita la contraseña\"> <br><br>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </form>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <td>Nombres</td>\n");
      out.write("                <td>Apellidos</td>\n");
      out.write("                <td>CURP</td>\n");
      out.write("                <td>Fecha de alta</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                Usuario u2 = new Usuario();
                for (Usuario u3 : u2.obtenerUsuario()) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(u3.getNombres());
      out.write("</td> \n");
      out.write("                <td>");
      out.print(u3.getApellidos());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(u3.getCurp());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(u3.getFecha_alta());
      out.write("</td>\n");
      out.write("                <td><a href=\"modificar_datos_usuario.jsp?a=");
      out.print(u3.getIdu());
      out.write("\">Editar</a></td>\n");
      out.write("            </tr>");
}
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
