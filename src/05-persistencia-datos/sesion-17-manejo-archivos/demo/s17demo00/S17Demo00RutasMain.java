package s17demo00;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class S17Demo00RutasMain {
    public static void main(String[] args) throws IOException {
        Path base = Path.of("src", "05-persistencia-datos", "sesion-17-manejo-archivos", "demo", "s17demo00", "datos");

        System.out.println("Datos: " + base.toAbsolutePath());
        Files.createDirectories(base);
        // resolve: construye la dirección de un archivo dentro de la carpeta base
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
