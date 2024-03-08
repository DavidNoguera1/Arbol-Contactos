<footer class="fixed-bottom py-3 bg-dark text-white text-center">
        <div class="container">
            <p class="m-0">Copyright &copy;Contactos (Arevalo,Noguera, Bolaños) 2024</p>
        </div>
</footer>
<script>
    // Función para cargar los contactos utilizando una petición AJAX
    function cargarContactos() {
        $.ajax({
            url: "SvContacto?action=cargarContactos", // La URL del servlet y el parámetro de acción
            type: "GET",
                dataType: "json", // Especifica el tipo de datos que esperas recibir
            success: function(response) {
                // Maneja la respuesta exitosa
                if (response && response.length > 0) {
                    // Vaciar el tbody para cargar los nuevos contactos
                    $('#contactosTableBody').empty();

                    // Recorre la lista de contactos y crea las filas de la tabla dinámicamente
                    response.forEach(function(contacto) {
                        var row = '<tr id="' + contacto.nombre + '">' +
                            '<td>' + contacto.idContacto + '</td>' +
                            '<td>' + contacto.nombre + '</td>' +
                            '<td>' + contacto.apellido + '</td>' +
                            '<td>' + contacto.direccion + '</td>' +
                            '<td>' + contacto.celular + '</td>' +
                            '<td>' + contacto.eMail + '</td>' +
                            '<td>' +
                            // Iconos de ver, editar y eliminar (tendrías que reemplazar con tu lógica)
                            '</td>' +
                            '</tr>';
                        $('#contactosTableBody').append(row);
                    });
                } else {
                    // Si no hay contactos, mostrar un mensaje en una fila de la tabla
                    var emptyRow = '<tr><td colspan="7">No hay contactos disponibles</td></tr>';
                    $('#contactosTableBody').append(emptyRow);
                }
            },
            error: function(xhr, status, error) {
                // Maneja los errores de la petición
                console.error("Error al cargar los contactos:", error);
            }
        });
    }

    // Llama a la función para cargar los contactos cuando la página se carga completamente
    $(document).ready(function() {
        cargarContactos();
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>