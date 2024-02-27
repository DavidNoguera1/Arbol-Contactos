<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.arbol.Contacto"%>
<%@include file= "templates/header.jsp" %>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<div class="collapse" id="navbarToggleExternalContent" data-bs-theme="dark">
    <div class="bg-dark p-4">
        <h5 class="text-body-emphasis h4">Directorio de Contactos </h5>
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
            <input id="search-focus" type="search" id="form1" class="form-control" 
                   placeholder="Buscar por nombre" />
        </div>

    </div>


    <%
    String alertType = (String) session.getAttribute("alertType");
    if (alertType != null) {
        if (alertType.equals("success")) {
    %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        Contacto agregado exitosamente, disfrute de la tabla :).
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
            } else if (alertType.equals("danger")) {
    %>
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        Error: Ya existe un contacto con el nombre proporcionado, por favor introduzca algún diferenciador :( .
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
            }
            // Limpiar el atributo de la sesión después de mostrar la alerta
            session.removeAttribute("alertType");
        }
    %>




    <div class="table-responsive">
        <%
            ArrayList<Contacto> listaContactos = (ArrayList<Contacto>) session.getAttribute("listaContactos");
        %>
        <table id="contactosTable" class="table table-striped table-bordered table-dark">
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
                    if (listaContactos != null && !listaContactos.isEmpty()) {
                        for (Contacto contacto : listaContactos) {
                %>
                <tr id="<%= contacto.getNombre() %>">
                    <td><%= contacto.getIdContacto()%></td>
                    <td><%= contacto.getNombre()%></td>
                    <td><%= contacto.getApellido()%></td>
                    <td><%= contacto.getDireccion()%></td>
                    <td><%= contacto.getCelular()%></td>
                    <td><%= contacto.geteMail()%></td>
                    <td>
                        <!-- Icono de ver -->
                        <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalV"
                           data-nombre="<%= contacto.getNombre()%>"
                           data-apellido="<%= contacto.getApellido()%>"
                           data-direccion="<%= contacto.getDireccion()%>"
                           data-telefono="<%= contacto.getCelular()%>"
                           data-correo="<%= contacto.geteMail()%>">
                            <i class="fas fa-eye"></i>
                        </a>

                        <!-- Icono de editar -->
                        <a href="#" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#editModal" title="Editar"
                           data-id="<%= contacto.getIdContacto()%>"
                           data-nombre="<%= contacto.getNombre()%>"
                           data-apellido="<%= contacto.getApellido()%>"
                           data-direccion="<%= contacto.getDireccion()%>"
                           data-telefono="<%= contacto.getCelular()%>"
                           data-correo="<%= contacto.geteMail()%>">
                            <i class="fas fa-edit"></i>
                        </a>

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

<!--- Script de filtrado de busqueda --->
<script>
    $(document).ready(function () {
        // Manejar el evento de entrada en la caja de búsqueda
        $('#search-focus').on('input', function () {
            var searchTerm = $(this).val().toLowerCase();

            // Filtrar las filas de la tabla basándonos en el término de búsqueda
            $('tbody tr').each(function () {
                var nombre = $(this).find('td:eq(1)').text().toLowerCase();

                // Mostrar u ocultar la fila según si coincide con el término de búsqueda
                if (nombre.includes(searchTerm)) {
                    $(this).show();
                } else {
                    $(this).hide();
                }
            });
        });
    });
</script>


<%@include file= "templates/modales.jsp" %>
<%@include file= "templates/footer.jsp" %>