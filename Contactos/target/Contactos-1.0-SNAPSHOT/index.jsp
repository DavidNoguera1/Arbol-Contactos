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
                <tr>
                    <th scope="row">1</th>
                    <td>Juan</td>
                    <td>Arevalo</td>
                    <td>Barrio La Florida</td>
                    <td>+57 3218061564</td>
                    <td>juan@gmail.com</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm">Ver</button>
                        <button type="button" class="btn btn-warning btn-sm">Editar</button>
                        <button type="button" class="btn btn-danger btn-sm">Borrar</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row">1</th>
                    <td>Juan</td>
                    <td>Arevalo</td>
                    <td>Barrio La Florida</td>
                    <td>+57 3218061564</td>
                    <td>juan@gmail.com</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm">Ver</button>
                        <button type="button" class="btn btn-warning btn-sm">Editar</button>
                        <button type="button" class="btn btn-danger btn-sm">Borrar</button>
                    </td>
                </tr>
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
        <form>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Nombre:</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="mb-3">
            <label for="recipient-lastname" class="col-form-label">Apellido:</label>
            <input type="text" class="form-control" id="recipient-lastname">
          </div>
          <div class="mb-3">
            <label for="recipient-address" class="col-form-label">Dirección:</label>
            <input type="text" class="form-control" id="recipient-address">
          </div>
          <div class="mb-3">
            <label for="recipient-phone" class="col-form-label">Teléfono:</label>
            <input type="tel" class="form-control" id="recipient-phone">
          </div>
          <div class="mb-3">
            <label for="recipient-email" class="col-form-label">Correo electrónico:</label>
            <input type="email" class="form-control" id="recipient-email">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        <button type="button" class="btn btn-primary">Guardar</button>
      </div>
    </div>
  </div>
</div>


<%@include file= "templates/footer.jsp" %>