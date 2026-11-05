package s18demo01;

import java.sql.SQLException;

public class UsuarioController {
    private final VistaConsola vista;
    private final UsuarioDAO dao;

    public UsuarioController(VistaConsola vista, UsuarioDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    public void iniciar() {
        while (true) {
            String opcion = vista.pedirOpcion();
            try {
                switch (opcion) {
                    case "1":
                        String nombre = vista.leerTexto("Nombre: ");
                        String correo = vista.leerTexto("Correo: ");
                        Usuario nuevo = new Usuario(0, nombre, correo);
                        vista.mostrar("Filas insertadas: " + dao.registrar(nuevo));
                        break;
                    case "2":
                        vista.mostrarListado(dao.listar());
                        break;
                    case "3":
                        int id = leerId();
                        // Reutilizamos las mismas reglas del modelo antes de enviar el cambio.
                        String nombreValidado = Usuario.validarNombre(vista.leerTexto("Nuevo nombre: "));
                        informarCambio(dao.actualizarNombre(id, nombreValidado));
                        break;
                    case "4":
                        int idEliminar = leerId();
                        if (vista.leerTexto("Escribe SI para eliminar: ").equals("SI")) {
                            informarCambio(dao.eliminar(idEliminar));
                        } else {
                            vista.mostrar("Eliminacion cancelada.");
                        }
                        break;
                    case "0":
                        return;
                    default:
                        vista.mostrar("Opcion no valida.");
                }
            } catch (SQLException error) {
                vista.mostrar("Operacion JDBC no completada. SQLState: " + error.getSQLState()
                        + "; codigo: " + error.getErrorCode());
            } catch (IllegalArgumentException error) {
                vista.mostrar(error.getMessage());
            }
        }
    }

    private int leerId() {
        int id = vista.leerEntero("Id: ");
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser positivo.");
        }
        return id;
    }

    private void informarCambio(int filas) {
        vista.mostrar(filas == 0 ? "Sin coincidencias para ese id." : "Filas afectadas: " + filas);
    }
}
