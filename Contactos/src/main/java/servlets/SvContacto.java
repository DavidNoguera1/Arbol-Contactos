/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.mycompany.contactos.Contacto;
import com.mycompany.contactos.ContactoRepetidoException;
import com.mycompany.contactos.Directorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juand
 */
@WebServlet(name = "SvContacto", urlPatterns = {"/SvContacto"})
public class SvContacto extends HttpServlet {
    
    private ArrayList<Contacto> obtenerListaContactos(Directorio directorio) {
    return directorio.obtenerTodosLosContactos();
}


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvContacto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvContacto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener el contexto del servlet
        ServletContext context = getServletContext();
        
        Directorio directorio = (Directorio) context.getAttribute("directorio");
        
        if (directorio == null) {
            directorio = new Directorio();
            context.setAttribute("directorio", directorio);
        }
        
        // Data del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String celular = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("correo");
        String id = request.getParameter("id");
        
        try {
            directorio.agregarContacto(Integer.parseInt(id), nombre, apellido, celular, direccion, email);

            // Obtiene la lista de contactos
            ArrayList<Contacto> listaContactos = obtenerListaContactos(directorio);

            // Establece la lista de contactos como un atributo en el objeto request
            request.setAttribute("listaContactos", listaContactos);

            // Redirige a la página JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        } catch (ContactoRepetidoException e) {
            // Manejar la excepción si el contacto ya existe
            e.printStackTrace(); // Aquí podrías mostrar un mensaje de error al usuario
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
