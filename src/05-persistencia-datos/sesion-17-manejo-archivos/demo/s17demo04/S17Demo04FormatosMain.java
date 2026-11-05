package s17demo04;

import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class S17Demo04FormatosMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path base = Path.of("src", "05-persistencia-datos", "sesion-17-manejo-archivos", "demo", "s17demo04", "datos");

        System.out.println("Datos: " + base.toAbsolutePath());
        Files.createDirectories(base);
        PedidoSerializable pedido = new PedidoSerializable("P-001", "María");
        Path texto = Files.createTempFile(base, "pedido-", ".txt");
        Path binario = Files.createTempFile(base, "pedido-", ".bin");
        Files.writeString(texto, pedido.comoTexto(), StandardCharsets.UTF_8);
        try (ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(binario))) {
            // serialización
            salida.writeObject(pedido);
        }
        // Solo se lee el binario propio que acabamos de generar, nunca una entrada externa.
        PedidoSerializable recuperado;
        try (ObjectInputStream entrada = new ObjectInputStream(Files.newInputStream(binario))) {
//            establece un filtro de seguridad antes de leer el objeto del archivo
            entrada.setObjectInputFilter(ObjectInputFilter.Config.createFilter("maxdepth=3;maxrefs=10;maxbytes=4096;maxarray=0;s17demo04.PedidoSerializable;!*"));
            // deserialización
            Object objeto = entrada.readObject();
            if (!(objeto instanceof PedidoSerializable)) {
                throw new IOException("Tipo no permitido");
            }
            recuperado = (PedidoSerializable) objeto;
            recuperado.validar();
        }
        System.out.println("Texto: " + Files.readString(texto, StandardCharsets.UTF_8));
        System.out.println("Binario recuperado: " + recuperado.comoTexto());
        System.out.println("Mismo contenido: " + pedido.comoTexto().equals(recuperado.comoTexto()));
        System.out.println("Archivos propios: " + texto.getFileName() + " / " + binario.getFileName());
    }
}
