package s14demo01;

import java.util.Objects;

public final class EventoPedido {
    private final String codigo;

    public EventoPedido(String codigo) {
        this.codigo = Objects.requireNonNull(codigo);
        if (codigo.isBlank()) {
            throw new IllegalArgumentException("Codigo vacio");
        }
    }

    public String getCodigo() {
        return codigo;
    }
}
