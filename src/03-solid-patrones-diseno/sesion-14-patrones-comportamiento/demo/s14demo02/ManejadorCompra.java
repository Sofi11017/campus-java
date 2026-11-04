package s14demo02;

import java.util.Objects;

public abstract class ManejadorCompra {
    private final ManejadorCompra siguiente;

    protected ManejadorCompra(ManejadorCompra siguiente) {
        this.siguiente = siguiente;
    }

    protected abstract long limite();

    protected abstract String responsable();

    public final String resolver(SolicitudCompra solicitud) {
        Objects.requireNonNull(solicitud);
        if (solicitud.getMonto() <= limite()) {
            return responsable();
        }
        if (siguiente != null) {
            return siguiente.resolver(solicitud);
        }
        return "Rechazada";
    }
}
