/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.mycompany.arbol.Contacto;
import com.mycompany.arbol.ContactoRepetidoException;
import com.mycompany.arbol.Directorio;
import com.mycompany.arbol.Guardado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juand
 */
@WebServlet(name = "SvContacto", urlPatterns = {"/SvContacto"})
public class SvContacto extends HttpServlet implements Serializable {

    private ArrayList<Contacto> obtenerListaContactos(Directorio directorio) {
        return directorio.obtenerTodosLosContactos();
    }

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

            // Call guardarContacto to save the updated contact list
            Guardado.guardarContacto(directorio, context);

            // Load the updated contact list
            ArrayList<Contacto> listaContactos = obtenerListaContactos(directorio);

            // Set the updated contact list as a session attribute
            HttpSession session = request.getSession();
            session.setAttribute("listaContactos", listaContactos);

            // Set the success message as a session attribute
            session.setAttribute("successMessage", "Contacto agregado exitosamente");

            // Redirect to the "index.jsp" page
            response.sendRedirect(request.getContextPath() + "/index.jsp");

        } catch (ContactoRepetidoException e) {
            // Handle the exception if the contact already exists
            e.printStackTrace(); // Here you could show an error message to the user
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
