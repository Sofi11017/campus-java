package s12lab03;
import java.util.ArrayList;
import java.util.List;

public class Rutina {
    private final String nombre;
    private final List<Ejercicio> ejercicios = new ArrayList<>();

    public Rutina(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre obligatorio");
        }
        this.nombre = nombre.strip();
    }
    public boolean agregar(String nombreEjercicio, int repeticiones) {
        if (nombreEjercicio == null || nombreEjercicio.isBlank()
                || repeticiones < 1 || repeticiones > 100) {
            return false;
        }
        ejercicios.add(new Ejercicio(nombreEjercicio.strip(), repeticiones));
        return true;
    }
    public boolean cambiarRepeticiones(int indice, int nuevas) {
        if (indice < 0 || indice >= ejercicios.size()) {
            return false;
        }
        return ejercicios.get(indice).cambiarRepeticiones(nuevas);
    }
    public Rutina copiar(String nuevoNombre) {
        Rutina copia = new Rutina(nuevoNombre);
        for (Ejercicio ejercicio : ejercicios) {
            // Cada elemento mutable también se copia.
            copia.ejercicios.add(ejercicio.copiar());
        }
        return copia;
    }
    public int cantidad() {
        return ejercicios.size();
    }
    public String resumen() {
        String texto = nombre + " (" + cantidad() + "):";
        for (Ejercicio ejercicio : ejercicios) {
            texto += " [" + ejercicio.resumen() + "]";
        }
        return texto;
    }
}
