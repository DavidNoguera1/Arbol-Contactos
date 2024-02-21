<%@include file= "templates/header.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycompany.contactos.Contacto" %>
<%@ page import="com.mycompany.contactos.Directorio" %>
<%@ page import="com.mycompany.contactos.Guardado" %>

<div class="collapse" id="navbarToggleExternalContent" data-bs-theme="dark">
    <div class="bg-dark p-4">
        <h5 class="text-body-emphasis h4">Directorio de Contactos</h5>
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
            Agregar nuevo contacto
        </button>    
    </div>
</div>
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>

<div class="container mt-5">
    <h2>Lista de Contactos</h2>

    <div class="table-responsive">
        <table class="table table-striped table-bordered table-dark">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Dirección</th>
                    <th scope="col">Teléfono</th>
                    <th scope="col">Correo</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    Directorio directorioContactos = Guardado.cargarContactos(getServletContext());
                    for (Contacto contacto : directorioContactos.getContactos()) {
                %>
                <tr>
                    <td><%= contacto.getIdContacto() %></td>
                    <td><%= contacto.getNombre() %></td>
                    <td><%= contacto.getApellido() %></td>
                    <td><%= contacto.getDireccion() %></td>
                    <td><%= contacto.getCelular() %></td>
                    <td><%= contacto.geteMail() %></td>
                    <td>
                        <!-- Add any action buttons or links here -->
                    </td>
                </tr>
                <% } %>
            </tbody>

        </table>
    </div>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Agregar Nuevo contacto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="/SvContacto" method="POST">
                    <div class="mb-3">
                        <label for="nombre" class="col-form-label">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingresa su nombre" required>
                    </div>
                    <div class="mb-3">
                        <label for="apellido" class="col-form-label">Apellido:</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Ingresa su apellido" required>
                    </div>
                    <div class="mb-3">
                        <label for="direccion" class="col-form-label">Dirección:</label>
                        <input type="text" class="form-control" id="direccion" name="direccion" placeholder="Ingresa su direccion" required>
                    </div>
                    <div class="mb-3">
                        <label for="telefono" class="col-form-label">Teléfono:</label>
                        <input type="tel" class="form-control" id="telefono" name="telefono" placeholder="Ingresa su número celular" maxlength="10" required pattern="[0-9]+" title="Solo se permiten números">
                    </div>
                    <div class="mb-3">
                        <label for="correo" class="col-form-label">Correo electrónico:</label>
                        <input type="email" class="form-control" id="correo" name="correo" placeholder="Ingresa su correo" required>
                    </div>
                    <div class="mb-3">
                        <label for="id" class="col-form-label">ID:</label>
                        <input type="text" class="form-control" id="id" name="id" placeholder="Ingresa su ID" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                        <button type="submit" class="btn btn-primary">Guardar</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>


<%@include file= "templates/footer.jsp" %>