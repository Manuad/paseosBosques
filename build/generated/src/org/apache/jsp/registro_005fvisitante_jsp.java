package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Visitante;
import modelo.Casa;

public final class registro_005fvisitante_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estilo_altas.css\">\n");
      out.write("        <title>Registro visitante</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <main>\n");
      out.write("            <div class=\"content-all\">\n");
      out.write("                <header></header>\n");
      out.write("                <input type=\"checkbox\" id=\"check\">\n");
      out.write("                <label for=\"check\" class=\"icon-menu\">Menu</label>\n");
      out.write("                <h2>Sistema Integral de Administración de Fraccionamientos</h2>\n");
      out.write("                <nav class=\"menu\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li ><a href=\"alta_usuario.html\">Alta de administrador</a></li>\n");
      out.write("                        <li><a href=\"modificar_datos_usuario.jsp\">Actualizar datos de usuario</a></li>\n");
      out.write("                        <li><a href=\"alta_residente.jsp\">Alta de residente</a></li>\n");
      out.write("                        <li><a href=\"alta_vehiculo.jsp\">Alta de vehiculo</a></li>\n");
      out.write("                        <li><a href=\"pago_servicio.jsp\">Pago de mantenimiento</a></li>\n");
      out.write("                        <li><a href=\"consulta_visitantes.jsp\"></a>Consulta visitantes</li>\n");
      out.write("                        <li><a href=\"\"></a></li>\n");
      out.write("                        <li><a href=\"\"></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("                <article>\n");
      out.write("                    <h1>Registro de visitantes Paseos del Bosque I</h1>\n");
      out.write("                    <p class=\"parrafo1\">Ubicado en los Héroes Tecámac Edo. México</p>\n");
      out.write("                </article>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"content-all\">\n");
      out.write("                <form name=\"registro_visitantes\" method=\"POST\" action=\"registro_visitante.jsp\" >\n");
      out.write("                    <article>\n");
      out.write("                        <p>Indique el identificador de la residencia: \n");
      out.write("                            <select name=\"cmbCasa\">\n");
      out.write("                                ");
for (int elem : new Casa().obtenerCasas()) {
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(elem);
      out.write('"');
      out.write('>');
      out.print(elem);
      out.write("</option>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </p>\n");
      out.write("                        <p>\n");
      out.write("                            <input type=\"text\" name=\"nombres\" placeholder=\"Nombre visitante\"><br>\n");
      out.write("                        </p>\n");
      out.write("                        <p>\n");
      out.write("                            <input type=\"text\" name=\"apellidos\" placeholder=\"Apellidos visitante\"><br>\n");
      out.write("                        </p>\n");
      out.write("                        <p>\n");
      out.write("                            <input type=\"text\" name=\"documento\" placeholder=\"Tipo de documento\"><br>\n");
      out.write("                        </p>\n");
      out.write("                        <p>\n");
      out.write("                            <input type=\"text\" name=\"descripcion\" placeholder=\"¿Cuantas personas ingresan?\"><br>\n");
      out.write("                        </p>\n");
      out.write("                        <p>\n");
      out.write("                            <input type=\"text\" name=\"medio\" placeholder=\"Auto, modelo y placas\"><br>\n");
      out.write("                        </p>\n");
      out.write("                        <input class=\"btn-primary\" name=\"btn_guardar\" value=\"Guardar\" type=\"submit\"><br>\n");
      out.write("                    </article>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </main>\n");
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
