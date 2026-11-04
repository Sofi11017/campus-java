package s14demo08;

import java.util.Objects;

public class Cotizacion {
    private String descripcion = "Inicial";

    public void editar(String descripcion) {
        if (Objects.requireNonNull(descripcion).isBlank()) {
            throw new IllegalArgumentException("Descripcion vacia");
        }
        this.descripcion = descripcion;
    }

    public String consultar() {
        return descripcion;
    }

    public Instantanea guardar() {
        return new Instantanea(this, descripcion);
    }

    public void restaurar(Instantanea instantanea) {
        if (Objects.requireNonNull(instantanea).origen != this) {
            throw new IllegalArgumentException("Instantanea de otra cotizacion");
        }
        descripcion = instantanea.descripcion;
    }

    public static final class Instantanea {
        private final Cotizacion origen;
        private final String descripcion;

        private Instantanea(Cotizacion origen, String descripcion) {
            this.origen = origen;
            this.descripcion = descripcion;
        }
    }
}
