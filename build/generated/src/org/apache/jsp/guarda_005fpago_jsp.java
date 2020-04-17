package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Servicios;

public final class guarda_005fpago_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Guardar Pago de Servicios</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("    <form action=\"registro_visitante.jsp\" >\n");
      out.write("        <p class=\"container\">\n");
      out.write("        <input type=\"submit\" value=\"Ir a registrar visitante\">    \n");
      out.write("        </p>\n");
      out.write("        \n");
      out.write("    </form>\n");
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
