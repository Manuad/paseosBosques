package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Auto;

public final class modifica_005fauto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
        Auto a  = new Auto();
        a.setId_casa(Long.parseLong(request.getParameter("id_casa")));
        a.setPlaca(request.getParameter("placa"));
        a.setFolio(request.getParameter("folio"));
        a.setTipo(request.getParameter("tipo"));
        a.setId_auto(Long.parseLong(request.getParameter("id_automovil")));
        a.updateAuto();
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Modificar registro de automoviles</h1>\n");
      out.write("        <form name=\"form_datos_auto\" method=\"POST\" action=\"modifica_auto.jsp\">\n");
      out.write("            ");

                if (request.getParameter("a") != null) {
                    Auto a4 = new Auto();
                    a4.setId_auto(Long.parseLong(request.getParameter("a")));
                    for (Auto a5 : a4.visualizarAuto()) {
            
      out.write("\n");
      out.write("            <label>Id casa:</label>&nbsp; <input type=\"text\" name=\"id_casa\" value=\"");
      out.print(a5.getId_casa());
      out.write("\"><br><br>\n");
      out.write("            <label>Placas: </label>&nbsp; <input type=\"text\" name=\"placas\" value=\"");
      out.print(a5.getPlaca());
      out.write("\"><br><br>\n");
      out.write("            <label>Folio: </label>&nbsp; <input type=\"text\" name=\"folio\" value=\"");
      out.print(a5.getFolio());
      out.write("\"><br><br>\n");
      out.write("            <label>Tipo: </label>&nbsp; <input type=\"text\" name=\"tipo\" value=\"");
      out.print(a5.getTipo());
      out.write("\"><br><br>\n");
      out.write("            <input type=\"hidden\" name=\"id_automovil\" value=\"");
      out.print(a5.getId_auto());
      out.write("\">\n");
      out.write("            <button class=\"btn-primary\" name=\"btn_editar\" type=\"submit\">Actualizar</button>\n");
      out.write("            ");

                }
            } else {
            
      out.write("\n");
      out.write("            <label>Id casa: </label> &nbsp; <input type=\"text\" name=\"id_casa\" placeholder=\"Ingresa el identificador de la casa:\"><br><br>\n");
      out.write("            <label>Placas: </label> &nbsp; <input type=\"text\" name=\"placa\" placeholder=\"Placas del automóvil\"><br><br>\n");
      out.write("            <label>Folio: </label> &nbsp; <input type=\"text\" name=\"folio\" placeholder=\"Folio del corbatin\"><br><br>\n");
      out.write("            <label>Tipo: </label> &nbsp; <input type=\"text\" name=\"tipo\" placeholder=\"Tipo de auto\">\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </form>\n");
      out.write("        <table border=\"0\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Id casa:</th>\n");
      out.write("                    <th>Placas: </th>\n");
      out.write("                    <th>Folio: </th>\n");
      out.write("                    <th>Tipo: </th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    Auto a2 = new Auto();
                    for(Auto a3 : a2.obtenerAuto()){
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(a3.getId_casa());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(a3.getPlaca());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(a3.getFolio());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(a3.getTipo());
      out.write("</td>\n");
      out.write("                    <td><a href=\"modifica_auto.jsp?a=");
      out.print(a3.getId_auto());
      out.write("\">Editar</a></td>\n");
      out.write("                </tr>");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("\n");
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
