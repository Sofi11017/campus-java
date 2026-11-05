package s18demo01;

import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    private final Scanner entrada;

    public VistaConsola(Scanner entrada) {
        this.entrada = entrada;
    }

    public String pedirOpcion() {
        mostrar("1 Registrar | 2 Listar | 3 Actualizar nombre | 4 Eliminar | 0 Salir");
        if (!entrada.hasNextLine()) {
            return "0";
        }
        return entrada.nextLine().strip();
    }

    public String leerTexto(String etiqueta) {
        System.out.print(etiqueta);
        if (!entrada.hasNextLine()) {
            throw new IllegalArgumentException("Entrada finalizada.");
        }
        return entrada.nextLine().strip();
    }

    public int leerEntero(String etiqueta) {
        return Integer.parseInt(leerTexto(etiqueta));
    }

    public void mostrar(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarListado(List<Usuario> elementos) {
        if (elementos.isEmpty()) {
            mostrar("Sin usuarios.");
        }
        for (Usuario elemento : elementos) {
            mostrar(elemento.getId() + " | " + elemento.getNombre() + " | "
                    + elemento.getCorreo());
        }
    }
}
