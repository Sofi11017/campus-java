package s17lab02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class S17Lab02AsistenciaMain {
    public enum Estado { ASISTIO, FALTO, TARDE }

    public static int[] importar(Path archivo) throws IOException {
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
                // TODO 1: Ignorar solo el encabezado exacto de la linea 1 y separar con split(";", -1).
                try {
                    // TODO 2: Validar tres campos no vacios, LocalDate.parse y Estado.valueOf.
                    // TODO 3: Incrementar validos tras validar; incrementar invalidos en el catch.
                } catch (DateTimeParseException | IllegalArgumentException error) {
                    System.out.println("Linea " + numero + ": " + error.getMessage());
                }
            }
        }
        return new int[]{validos, invalidos};
    }

    public static void main(String[] args) throws IOException {
        Path base = args.length == 0 ? Path.of(System.getProperty("java.io.tmpdir"), "campus-java-s17", "lab02") : Path.of(args[0]);
        base = base.toAbsolutePath().normalize();
        System.out.println("Datos: " + base);
        Files.createDirectories(base);
        Path archivo = base.resolve("asistencia.txt");
        if (args.length < 2 || !args[1].equals("solo-leer")) {
            try {
                Files.writeString(archivo, "estudiante;fecha;estado\n"
                        + "Ana;2026-11-02;ASISTIO\nJosé;2026-11-02;FALTO\n"
                        + "María;2026-11-02\nLuis;fecha;ASISTIO\nSara;2026-11-02;PENDIENTE\n",
                        StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
            } catch (FileAlreadyExistsException error) {
                System.out.println("Muestra existente conservada");
            }
        }
        int[] resultado = importar(archivo);
        System.out.println("Validos: " + resultado[0] + "; invalidos: " + resultado[1]);
        if (resultado[0] + resultado[1] == 0) {
            System.out.println("Sin registros contados: entrada vacia o TODO pendientes; revisar el archivo");
        }
    }
}