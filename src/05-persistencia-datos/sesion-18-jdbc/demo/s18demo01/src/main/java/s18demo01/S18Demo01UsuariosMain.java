package s18demo01;

import java.util.Scanner;

public class S18Demo01UsuariosMain {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            VistaConsola vista = new VistaConsola(entrada);
            UsuarioDAO dao = new UsuarioDAO(new ConexionFactory());
            new UsuarioController(vista, dao).iniciar();
        }
    }
}
