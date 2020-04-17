package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Usuario;

public final class guardar_005fusuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estilo_menu.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    ");

        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String curp = request.getParameter("curp");
        String contra1 = request.getParameter("contra1");
        String contra2 = request.getParameter("contra2");
        Usuario u = new Usuario();
        u.setNombres(nombres);
        u.setApellidos(apellidos);
        u.setCurp(curp);
        u.setContra(contra1);
        if (!contra1.isEmpty() && !contra2.isEmpty()) {
            if (!contra1.equals(contra2)) {
                System.out.print("Las contraseñas no coinciden");
            } else {
                u.insertaUsuario();
            }
        } else {
            System.out.println("Ingrese contraseñas");
        }

    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <h1>Usuario: \n");
      out.write("            ");
      out.print(u.getNombres());
      out.write(" &nbsp;\n");
      out.write("            ");
      out.print(u.getApellidos());
      out.write(" &nbsp; dado de alta con éxito\n");
      out.write("        </h1>\n");
      out.write("        <form name=\"uform\" action=\"alta_residente.jsp\" method=\"POST\">\n");
      out.write("            <label >¿Desea agregar un nuevo residente? </label> &nbsp; <button class=\"btn-primary\" name=\"agregar\" type=\"submit\" a=\"alta_residente.jsp\">Agregar</button>\n");
      out.write("            <label >¿Desea editar datos de algún usuario? </label> &nbsp; <button class=\"btn-primary\" name=\"agregar\" type=\"submit\" >Aceptar</button>\n");
      out.write("        </form>\n");
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
