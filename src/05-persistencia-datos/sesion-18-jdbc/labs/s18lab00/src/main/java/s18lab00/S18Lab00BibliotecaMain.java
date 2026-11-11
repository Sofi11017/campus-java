package s18lab00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class S18Lab00BibliotecaMain {
    private static final String URL = "jdbc:mysql://localhost:3306/campus_java_s18";
    private static final String DB_USER = System.getenv("DB_USER") != null && !System.getenv("DB_USER").isBlank()
            ? System.getenv("DB_USER") : "root";
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD") != null
            ? System.getenv("DB_PASSWORD") : "Campus2023!";

    public static void main(String[] args) {
        try {
            try (Connection conexion = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
                 Scanner entrada = new Scanner(System.in)) {
                if (!conexion.isValid(5)) {
                    throw new SQLException("Conexion no valida.");
                }
                System.out.println("Conexion comprobada a la biblioteca.");
                ejecutarMenu(conexion, entrada);
            }
        } catch (SQLException error) {
            mostrarError(error);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }

    private static void ejecutarMenu(Connection conexion, Scanner entrada) {
        while (true) {
            System.out.println("1 Registrar | 2 Listar | 3 Buscar ISBN | 0 Salir");
            if (!entrada.hasNextLine()) {
                return;
            }
            String opcion = entrada.nextLine().strip();
            try {
                switch (opcion) {
                    case "1":
                        registrar(conexion, entrada);
                        break;
                    case "2":
                        listar(conexion);
                        break;
                    case "3":
                        buscarPorIsbn(conexion, entrada);
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Opcion no valida.");
                }
            } catch (SQLException error) {
                mostrarError(error);
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private static void registrar(Connection conexion, Scanner entrada) throws SQLException {
        String titulo = obligatorio(leer(entrada, "Titulo: "), 150);
        String isbn = obligatorio(leer(entrada, "ISBN: "), 20);

        String sql = "INSERT INTO libros (titulo, isbn) VALUES (?, ?)";
        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, titulo);
            sentencia.setString(2, isbn);
            int filas = sentencia.executeUpdate();
            System.out.println("Filas insertadas: " + filas);
        }
    }

    private static void listar(Connection conexion) throws SQLException {
        String sql = "SELECT id, titulo, isbn FROM libros ORDER BY id";
        try (PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet filas = sentencia.executeQuery()) {
            boolean hayDatos = false;
            while (filas.next()) {
                hayDatos = true;
                System.out.println(filas.getInt("id") + " | "
                        + filas.getString("titulo") + " | "
                        + filas.getString("isbn"));
            }
            if (!hayDatos) {
                System.out.println("Sin libros.");
            }
        }
    }

    private static void buscarPorIsbn(Connection conexion, Scanner entrada) throws SQLException {
        String isbn = obligatorio(leer(entrada, "ISBN a buscar: "), 20);
        String sql = "SELECT id, titulo, isbn FROM libros WHERE isbn = ?";
        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, isbn);
            try (ResultSet filas = sentencia.executeQuery()) {
                if (filas.next()) {
                    System.out.println(filas.getInt("id") + " | "
                            + filas.getString("titulo") + " | "
                            + filas.getString("isbn"));
                } else {
                    System.out.println("Sin resultados.");
                }
            }
        }
    }

    private static String leer(Scanner entrada, String mensaje) {
        System.out.print(mensaje);
        if (!entrada.hasNextLine()) {
            throw new IllegalArgumentException("Entrada finalizada.");
        }
        return entrada.nextLine().strip();
    }

    private static String obligatorio(String valor, int maximo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("El campo es obligatorio y no puede estar vacio.");
        }
        if (valor.length() > maximo) {
            throw new IllegalArgumentException("El campo supera el limite de " + maximo + " caracteres.");
        }
        return valor;
    }

    private static void mostrarError(SQLException error) {
        if (error.getErrorCode() == 1062) {
            System.out.println("Error: El ISBN ya se encuentra registrado (debe ser unico).");
        } else {
            System.out.println("Operacion JDBC no completada. SQLState: " + error.getSQLState()
                    + "; codigo: " + error.getErrorCode() + "; mensaje: " + error.getMessage());
        }
    }
}

