package s17demo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class S17Demo01EscrituraMain {
    /**
     * Main method for demonstrating file operations using the Java NIO API.
     * It performs tasks such as creating directories, writing data to files,
     * and appending or replacing file content as specified.
     *
     * @param args Command-line arguments (not used in this implementation).
     * @throws IOException If an I/O error occurs during file operations.
     *                     <p>
     *                     CREATE: crea el archivo si no existe.
     *                     APPEND: escribe al final y conserva el contenido anterior.
     *                     Sin opciones: Vacía el archivo y escribe el contenido nuevo.
     */
    public static void main(String[] args) throws IOException {
        Path base = Path.of("src", "05-persistencia-datos", "sesion-17-manejo-archivos", "demo", "s17demo01", "datos");

        System.out.println("Datos: " + base.toAbsolutePath());
        Files.createDirectories(base);
        Path historial = base.resolve("historial.txt");
        int antes = Files.exists(historial) ? Files.readAllLines(historial, StandardCharsets.UTF_8).size() : 0;

        try (BufferedWriter escritor = Files.newBufferedWriter(historial, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            escritor.write("Pedido P-001: María");
            escritor.newLine();
            escritor.write("Pedido P-002: Andrés");
            escritor.newLine();
        }
        System.out.println("Lineas antes: " + antes);
        System.out.println("Lineas despues: " + Files.readAllLines(historial, StandardCharsets.UTF_8).size());
        System.out.print(Files.readString(historial, StandardCharsets.UTF_8));
        // Archivo de ejemplo separado: aqui si elegimos reemplazar contenido.
        Path resumen = base.resolve("resumen-reemplazable.txt");
        Files.writeString(resumen, "Resumen de pedidos" + System.lineSeparator(), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        Files.writeString(resumen, "Nueva línea: " + System.currentTimeMillis() + System.lineSeparator(), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        System.out.println("Resumen reemplazado; historial conservado");
    }
}
