package s17lab00;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class S17Lab00BibliotecaMain {
    public static boolean preparar(Path base, String seccion) throws IOException {
        if (!Set.of("infantil", "ciencia", "arte").contains(seccion)) {
            throw new IllegalArgumentException("Seccion permitida: infantil, ciencia o arte");
        }
        Path carpeta = base.resolve(seccion);
        Files.createDirectories(carpeta); // TODO 1: Crear carpeta y padres.
        Path archivo = carpeta.resolve("inventario.txt");
        try {
            if (Files.isDirectory(archivo)) {
                throw new FileAlreadyExistsException(archivo.toString());
            }
            Files.createFile(archivo); // TODO 2: Crear archivo sin reemplazar uno existente.
        } catch (FileAlreadyExistsException error) {
            if (!Files.isRegularFile(archivo)) {
                throw new IOException("La ruta del inventario no es archivo: " + archivo, error);
            }
        }
        return Files.isDirectory(carpeta) && Files.isRegularFile(archivo);
    }

    public static void main(String[] args) throws IOException {
        Path base = args.length == 0 ? Path.of(System.getProperty("java.io.tmpdir"), "campus-java-s17", "lab00") : Path.of(args[0]);
        base = base.toAbsolutePath().normalize();
        System.out.println("Datos: " + base);
        String seccion = "ciencia";
        boolean preparado = preparar(base, seccion);
        System.out.println(preparado ? "Seccion preparada: " + seccion : "PENDIENTE: completar TODO 1 y 2");
    }
}