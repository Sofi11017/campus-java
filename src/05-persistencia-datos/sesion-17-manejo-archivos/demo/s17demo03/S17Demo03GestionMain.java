package s17demo03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class S17Demo03GestionMain {
    public static void main(String[] args) throws IOException {
        Path base = args.length == 0
                ? Path.of(System.getProperty("java.io.tmpdir"), "campus-java-s17", "demo03")
                : Path.of(args[0]);
        base = base.toAbsolutePath().normalize();
        System.out.println("Datos: " + base);
        Files.createDirectories(base);
        Path origen = base.resolve("pedido.txt");
        Path respaldo = base.resolve("respaldo.txt");
        Path historico = base.resolve("historico").resolve("pedido.txt");
        Files.createDirectories(historico.getParent());
        try {
            Files.writeString(origen, "P-001;Ana;ENTREGADO\n",
                    StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
        } catch (FileAlreadyExistsException error) {
            System.out.println("Origen existente conservado");
        }
        if (!Files.isRegularFile(origen)) {
            throw new IOException("El origen no es un archivo regular: " + origen);
        }
        boolean copiado = false;
        try {
            Files.copy(origen, respaldo);
            copiado = true;
            System.out.println("Copia creada; original conservado");
        } catch (FileAlreadyExistsException error) {
            System.out.println("Respaldo existente: no se reemplaza ni se mueve");
        }
        if (copiado) {
            try {
                Files.move(respaldo, historico);
                System.out.println("Copia movida a historico");
            } catch (FileAlreadyExistsException error) {
                System.out.println("Historico existente: copia y destino conservados");
            }
        }
        Path borrador = Files.createTempFile(base, "borrador-", ".tmp");
        System.out.println("Borrador propio eliminado: " + Files.deleteIfExists(borrador));
        System.out.println("Origen presente: " + Files.isRegularFile(origen));
        System.out.println("Respaldo presente: " + Files.exists(respaldo));
        System.out.println("Historico presente: " + Files.isRegularFile(historico));
    }
}
