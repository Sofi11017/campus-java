package s17demo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class S17Demo02LecturaMain {
    public static void main(String[] args) throws IOException {
        Path base = args.length == 0
                ? Path.of(System.getProperty("java.io.tmpdir"), "campus-java-s17", "demo02")
                : Path.of(args[0]);
        base = base.toAbsolutePath().normalize();
        System.out.println("Datos: " + base);
        Files.createDirectories(base);
        Path archivo = base.resolve("pedidos.txt");
        // El segundo argumento permite probar un archivo ausente sin preparar la muestra.
        if (args.length < 2 || !args[1].equals("solo-leer")) {
            try {
                Files.writeString(archivo,
                        "P-001;Ana;PENDIENTE\nP-002;Luis;ENTREGADO\nP-003;María\nP-004;Sara;OTRO\n",
                        StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
            } catch (FileAlreadyExistsException error) {
                System.out.println("Entrada existente conservada");
            }
        }
        if (!Files.isRegularFile(archivo)) {
            throw new IOException("No existe un archivo regular de pedidos: " + archivo);
        }
        int validos = 0;
        int invalidos = 0;
        int numero = 0;
        try (BufferedReader lector = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                numero++;
                if (linea.isBlank()) {
                    continue;
                }
                try {
                    String[] campos = linea.split(";", -1);
                    if (campos.length != 3) {
                        throw new IllegalArgumentException("Se requieren tres campos");
                    }
                    Pedido pedido = new Pedido(campos[0].strip(), campos[1].strip(), campos[2].strip());
                    System.out.println("Valido: " + pedido.descripcion());
                    validos++;
                } catch (IllegalArgumentException error) {
                    System.out.println("Linea " + numero + ": " + error.getMessage());
                    invalidos++;
                }
            }
        }
        System.out.println("Validos: " + validos + "; invalidos: " + invalidos);
    }
}
