package s17lab01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class S17Lab01BitacoraMain {
    public static boolean registrar(Path archivo) throws IOException {
        Files.createDirectories(archivo.getParent());
        // TODO 1: Abrir BufferedWriter UTF-8 con CREATE y APPEND, en try-with-resources.
        // TODO 2: Escribir las dos tareas indicadas, cada una seguida de newLine().
        return false; // Sustituir por true solo despues del cierre correcto.
    }

    public static void main(String[] args) throws IOException {
        Path base = args.length == 0 ? Path.of(System.getProperty("java.io.tmpdir"), "campus-java-s17", "lab01") : Path.of(args[0]);
        base = base.toAbsolutePath().normalize();
        System.out.println("Datos: " + base);
        Path archivo = base.resolve("mantenimiento.txt");
        int antes = Files.exists(archivo)
                ? Files.readAllLines(archivo, StandardCharsets.UTF_8).size() : 0;
        if (!registrar(archivo)) {
            System.out.println("PENDIENTE: completar TODO 1 y 2");
            return;
        }
        System.out.println("Antes: " + antes);
        System.out.println("Despues: " + Files.readAllLines(archivo, StandardCharsets.UTF_8).size());
        System.out.print(Files.readString(archivo, StandardCharsets.UTF_8));
    }
}