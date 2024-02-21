<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.contactos.Contacto"%>
<%@include file= "templates/header.jsp" %>

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
    <div class="input-group mb-3">
        <div class="form-outline" data-mdb-input-init>
            <input id="search-focus" type="search" id="form1" class="form-control" />
        </div>
        <button type="button" class="btn btn-primary" data-mdb-ripple-init>
            <i class="fas fa-search"></i>
        </button>
    </div>
    <div class="table-responsive">
        <%
            ArrayList<Contacto> listaContactos = (ArrayList<Contacto>) request.getAttribute("listaContactos");
        %>
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
                    if (listaContactos != null) {
                        for (Contacto contacto : listaContactos) {
                %>
                <tr>
                    <td><%= contacto.getIdContacto()%></td>
                    <td><%= contacto.getNombre()%></td>
                    <td><%= contacto.getApellido()%></td>
                    <td><%= contacto.getDireccion()%></td>
                    <td><%= contacto.getCelular()%></td>
                    <td><%= contacto.geteMail()%></td>
                    <td>
                        <!-- Icono de ver -->
                        <a href="#" title="Ver" class="btn btn-primary"><i class="fas fa-eye"></i></a>

                        <!-- Icono de editar -->
                        <a href="#" title="Editar" class="btn btn-success"><i class="fas fa-edit"></i></a>

                        <!-- Icono de eliminar -->
                        <a href="#" title="Eliminar" class="btn btn-danger" onclick="confirmarEliminacion('<%= contacto.getNombre()%>')">
                            <i class="fas fa-trash"></i>
                        </a>
                    </td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="7">No hay contactos disponibles</td>
                </tr>
                <%
                    }
                %>
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
                <form action="SvContacto" method="POST">
                    <div class="mb-3">
                        <label for="id" class="col-form-label">ID:</label>
                        <input type="text" class="form-control" id="id" name="id" placeholder="Ingresa su ID" required>
                    </div>
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
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                        <button type="submit" class="btn btn-primary">Guardar</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>

<script>
    function confirmarEliminacion(contactName) {
        if (confirm("Are you sure you want to delete contact " + contactName + "?")) {
            // User clicked OK, proceed with the deletion
            $.ajax({
                type: "GET",
                url: "SvAgregarContacto", // Replace with the actual URL of your servlet
                data: {action: "deleteContact", nombre: contactName},
                success: function (data) {
                    // Handle success if needed
                    // You may want to refresh the contact list or update the UI
                    console.log("Contact deleted successfully");

                    // Reload the page after a short delay (e.g., 500 milliseconds)
                    setTimeout(function () {
                        location.reload();
                    }, 500);
                },
                error: function (error) {
                    // Handle error if needed
                    console.error("Error deleting contact", error);
                }
            });

        } else {
            // User clicked Cancel, do nothing or handle accordingly
        }
    }
</script>



<%@include file= "templates/footer.jsp" %>