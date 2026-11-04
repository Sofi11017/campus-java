package s13demo04;

import java.util.Objects;

public abstract class Reporte {
    protected final Exportador exportador;

    protected Reporte(Exportador exportador) {
        this.exportador = Objects.requireNonNull(exportador);
    }

    public abstract void generar();
}
