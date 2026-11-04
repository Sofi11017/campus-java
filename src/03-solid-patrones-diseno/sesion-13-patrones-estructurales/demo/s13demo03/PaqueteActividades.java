package s13demo03;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PaqueteActividades implements Actividad {
    private final List<Actividad> actividades = new ArrayList<>();

    public void agregarActividad(Actividad actividad) {
        Objects.requireNonNull(actividad);
        if (actividad == this || actividad instanceof PaqueteActividades
                && ((PaqueteActividades) actividad).contiene(this)) {
            throw new IllegalArgumentException("La insercion genera un ciclo");
        }
        actividades.add(actividad);
    }

    private boolean contiene(Actividad buscada) {
        for (Actividad actividad : actividades) {
            if (actividad == buscada || actividad instanceof PaqueteActividades
                    && ((PaqueteActividades) actividad).contiene(buscada)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public long calcularCosto() {
        long total = 0;
        for (Actividad actividad : actividades) {
            total = Math.addExact(total, actividad.calcularCosto());
        }
        return total;
    }
}
