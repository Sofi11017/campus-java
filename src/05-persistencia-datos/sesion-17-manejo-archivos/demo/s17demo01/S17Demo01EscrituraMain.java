package s17demo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class S17Demo01EscrituraMain {
    public static void main(String[] args) throws IOException {
        Path base = args.length == 0
                ? Path.of(System.getProperty("java.io.tmpdir"), "campus-java-s17", "demo01")
                : Path.of(args[0]);
        base = base.toAbsolutePath().normalize();
        System.out.println("Datos: " + base);
        Files.createDirectories(base);
        Path historial = base.resolve("historial.txt");
        int antes = Files.exists(historial)
                ? Files.readAllLines(historial, StandardCharsets.UTF_8).size() : 0;
        try (BufferedWriter escritor = Files.newBufferedWriter(historial,
                StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            escritor.write("Pedido P-001: María");
            escritor.newLine();
            escritor.write("Pedido P-002: Andrés");
            escritor.newLine();
        }
        System.out.println("Lineas antes: " + antes);
        System.out.println("Lineas despues: "
                + Files.readAllLines(historial, StandardCharsets.UTF_8).size());
        System.out.print(Files.readString(historial, StandardCharsets.UTF_8));
        // Archivo de ejemplo separado: aqui si elegimos reemplazar contenido.
        Path resumen = base.resolve("resumen-reemplazable.txt");
        Files.writeString(resumen, "Resumen de pedidos" + System.lineSeparator(),
                StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("Resumen reemplazado; historial conservado");
    }
}
