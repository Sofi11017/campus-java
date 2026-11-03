package s14demo06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CatalogoDocumentos implements Iterable<String> {
    private final List<String> documentos = new ArrayList<>();

    public void agregar(String titulo) {
        if (Objects.requireNonNull(titulo).isBlank()) {
            throw new IllegalArgumentException("Titulo vacio");
        }
        documentos.add(titulo);
    }

    @Override
    public Iterator<String> iterator() {
        // Instantanea de lectura: no expone la lista y no admite remove.
        return List.copyOf(documentos).iterator();
    }
}
