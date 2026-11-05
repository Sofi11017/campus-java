package s17demo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * This class demonstrates how to read and validate order data from a text file.
 * It implements file handling, data validation, and error management during file reading.
 * <p>
 * The application:
 * - Prepares a sample file if it does not exist (based on the prepararMuestra flag).
 * - Reads a file containing order data line by line.
 * - Validates each line, checking for proper formatting and expected data values.
 * - Creates instances of the {@link Pedido} class for valid records.
 * - Reports the number of valid and invalid records in the file.
 * <p>
 * Key concepts demonstrated:
 * - Use of {@link Path}, {@link Files}, and file I/O operations.
 * - Handling of exceptions such as {@link IOException} and {@link IllegalArgumentException}.
 * - Try-with-resources to manage the {@link BufferedReader} resource and ensure proper cleanup.
 * - Splitting and validating delimited text data using {@code String.split()}.
 * <p>
 * Constraints and behaviors:
 * - The input file is expected to contain order records in a semicolon-delimited format
 * (e.g., "P-001;Ana;PENDIENTE"). Lines with missing or invalid fields are treated as errors.
 * - Supported order statuses are "PENDIENTE" and "ENTREGADO".
 * - Lines that do not meet the requirements are skipped, with details printed to the console.
 * - Empty lines in the file are ignored.
 * - If the file does not exist when running without sample data preparation, an {@link IOException} is thrown.
 * <p>
 * Note: This implementation is specific to the format and requirements described and does not
 * serve as a generic CSV parser.
 */
public class S17Demo02LecturaMain {
    public static void main(String[] args) throws IOException {
        Path base = Path.of("src", "05-persistencia-datos", "sesion-17-manejo-archivos", "demo", "s17demo02", "datos");

        System.out.println("Datos: " + base.toAbsolutePath());
        Files.createDirectories(base);
        Path archivo = base.resolve("pedidos.txt");
        // Cambia a false para probar la lectura sin crear la muestra.
        boolean prepararMuestra = true;
        if (prepararMuestra) {
            try {
                // CREATE_NEW: crea el archivo solo si NO existe; falla con FileAlreadyExistsException si ya existe.
                // CREATE: crea el archivo si NO existe; si existe, lo abre sin error (puede sobrescribirlo).
                Files.writeString(archivo, "P-001;Ana;PENDIENTE\nP-002;Luis;ENTREGADO\nP-003;María\nP-004;Sara;OTRO\n", StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
            } catch (FileAlreadyExistsException error) {
                System.out.println("Entrada existente conservada");
            }
        }
//        Un archivo regular es un archivo normal que contiene datos (texto, imágenes, binarios, etc.)
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
