package s18lab01;

import java.util.List;
import java.util.Scanner;

public class VistaInventario {
    private final Scanner entrada;

    public VistaInventario(Scanner entrada) {
        this.entrada = entrada;
    }

    public String pedirOpcion() {
        mostrar("1 Registrar | 2 Listar | 3 Actualizar stock | 0 Salir");
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
        try {
            return Integer.parseInt(leerTexto(etiqueta));
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("Debes ingresar un numero entero valido.");
        }
    }

    public void mostrar(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarListado(List<Producto> productos) {
        if (productos.isEmpty()) {
            mostrar("Sin productos.");
            return;
        }
        for (Producto producto : productos) {
            mostrar(producto.getId() + " | " + producto.getNombre() + " | " + producto.getStock());
        }
    }
}

