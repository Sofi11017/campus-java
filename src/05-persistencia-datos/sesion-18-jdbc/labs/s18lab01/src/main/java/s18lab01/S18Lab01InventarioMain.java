package s18lab01;

import java.util.Scanner;

public class S18Lab01InventarioMain {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            VistaInventario vista = new VistaInventario(entrada);
            ProductoDAO dao = new ProductoDAO(new ConexionFactory());
            new ProductoController(vista, dao).iniciar();
        }
    }
}
