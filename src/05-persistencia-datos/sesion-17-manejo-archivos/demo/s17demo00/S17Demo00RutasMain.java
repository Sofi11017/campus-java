package s17demo00;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class S17Demo00RutasMain {
    public static void main(String[] args) throws IOException {
        Path relativa = Path.of("datos", "pedidos.txt");
        System.out.println("Directorio de trabajo: " + Path.of("").toAbsolutePath());
        System.out.println("Relativa: " + relativa);
        System.out.println("Resuelta: " + relativa.toAbsolutePath());
        Path base = args.length == 0
                ? Path.of(System.getProperty("java.io.tmpdir"), "campus-java-s17", "demo00")
                : Path.of(args[0]);
        base = base.toAbsolutePath().normalize();
        System.out.println("Datos: " + base);
        Files.createDirectories(base);
        Path archivo = base.resolve("pedidos.txt");
        try {
            Files.createFile(archivo);
            System.out.println("Archivo creado");
        } catch (FileAlreadyExistsException error) {
            if (!Files.isRegularFile(archivo)) {
                throw new IOException("Se esperaba un archivo regular: " + archivo, error);
            }
            System.out.println("Archivo existente conservado");
        }
        System.out.println("Es archivo: " + Files.isRegularFile(archivo));
        System.out.println("Bytes: " + Files.size(archivo));
    }
}
