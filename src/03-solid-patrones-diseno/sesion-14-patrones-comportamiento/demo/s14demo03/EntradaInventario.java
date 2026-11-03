package s14demo03;

import java.util.Objects;

public class EntradaInventario implements Comando {
    private final Inventario inventario;
    private final int cantidad;

    public EntradaInventario(Inventario inventario, int cantidad) {
        this.inventario = Objects.requireNonNull(inventario);
        this.cantidad = cantidad;
    }

    @Override
    public boolean ejecutar() {
        return inventario.ingresar(cantidad);
    }
}
