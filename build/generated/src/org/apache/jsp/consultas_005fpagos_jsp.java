package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Casa;
import modelo.PagoServicio;

public final class consultas_005fpagos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/tablas.css\">\n");
      out.write("        <title>Consultar Pagos</title>\n");
      out.write("    </head>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        function ShowSelected()\n");
      out.write("        {\n");
      out.write("            alert(\"!\");\n");
      out.write("            var cod = document.getElementById(\"cmbCasa\").value;\n");
      out.write("            alert(cod);\n");
      out.write("            document.base.valorcmbCasa.value = cod;\n");
      out.write("            var combo = document.getElementById(\"cmbCasa\");\n");
      out.write("            var selected = combo.options[combo.selectedIndex].text;\n");
      out.write("\n");
      out.write("            alert(selected);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("    <body>\n");
      out.write("        <form name=\"base\" action=\"consultas_pagos.jsp\">\n");
      out.write("            <input type=\"hidden\" name=\"valorcmbCasa\"  value=\"10101\"/>\n");
      out.write("            <h1>Consulta de pagos realizados: </h1>\n");
      out.write("\n");
      out.write("            <p>\n");
      out.write("                Elija el Id de la casa a consultar:\n");
      out.write("            </p>\n");
      out.write("            <select id=\"cmbCasa\" name=\"cmbCasa\" onchange=\"submit();\">\n");
      out.write("                ");
for (int elem : new Casa().obtenerCasas()) {
      out.write("\n");
      out.write("                <option value=\"");
      out.print(elem);
      out.write('"');
      out.write('>');
      out.print(elem);
      out.write("</option>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </select>\n");
      out.write("\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Id servicio</th>\n");
      out.write("                        <th>id casa</th>\n");
      out.write("                        <th>Mes</th>\n");
      out.write("                        <th>Descripcion de pago</th>\n");
      out.write("                        <th>Fecha</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        if (request.getParameter("cmbCasa") != null) {
                            String id_casa = request.getParameter("cmbCasa");
                            //System.out.println(" Este es el id " + id_casa);
                            PagoServicio pago = new PagoServicio();
                            pago.setId_casa(Long.parseLong(id_casa));
                            // pago.setId_casa(Integer.parseInt(id_casa.trim()));
                            for (PagoServicio elem : pago.pagoCasa()) {

                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(elem.getId_servicio());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(elem.getId_casa());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(elem.getId_mes());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(elem.getDescripcion());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(elem.getFechaPago());
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                            }
                        }

                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
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
