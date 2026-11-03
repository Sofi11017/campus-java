package s14demo08;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HistorialCotizacion {
    private final Cotizacion cotizacion;
    private final List<Cotizacion.Instantanea> versiones = new ArrayList<>();
    private int posicion;

    public HistorialCotizacion(Cotizacion cotizacion) {
        this.cotizacion = Objects.requireNonNull(cotizacion);
        versiones.add(cotizacion.guardar());
    }

    public void editar(String descripcion) {
        cotizacion.editar(descripcion);
        while (versiones.size() > posicion + 1) {
            versiones.remove(versiones.size() - 1);
        }
        versiones.add(cotizacion.guardar());
        posicion++;
    }

    public boolean deshacer() {
        if (posicion == 0) {
            return false;
        }
        posicion--;
        cotizacion.restaurar(versiones.get(posicion));
        return true;
    }

    public boolean rehacer() {
        if (posicion + 1 >= versiones.size()) {
            return false;
        }
        posicion++;
        cotizacion.restaurar(versiones.get(posicion));
        return true;
    }
}
