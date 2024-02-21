/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.mycompany.contactos.Contacto;
import com.mycompany.contactos.Directorio;
import com.mycompany.contactos.Guardado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MrNoguera
 */
@WebServlet(name = "SvContacto", urlPatterns = {"/SvContacto"})
public class SvContacto extends HttpServlet {

    Directorio arbolLista = new Directorio();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener el contexto del servlet
        ServletContext context = getServletContext();
        
        // Data del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String celular = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("correo");
        String id = request.getParameter("id");

        // Crea un nuevo objeto contacto
        Contacto nuevoContacto = new Contacto(id, nombre, apellido, celular, direccion, email, null, null);

        // Carga de la data serializada anterior
        Directorio directorioContactos = null;
        try {
            directorioContactos = Guardado.cargarContactos(getServletContext());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SvContacto.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Añade el nuevo contacto al arbol
        directorioContactos.agregarContacto(id, nombre, apellido, celular, direccion, email);

        // Guarda la data
        Guardado.guardarContacto(directorioContactos, getServletContext());

        // Redireccion a la pagina
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
