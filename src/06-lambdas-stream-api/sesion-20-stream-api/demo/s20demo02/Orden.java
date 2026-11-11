package s20demo02;

import java.util.List;
import java.util.Objects;

public class Orden {
    private final String codigo;
    private final List<Item> items;

    public Orden(String codigo, List<Item> items) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Codigo obligatorio.");
        }
        this.codigo = codigo.strip();
        this.items = List.copyOf(Objects.requireNonNull(items, "La lista de items es obligatoria."));
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Item> getItems() {
        return items;
    }
}
