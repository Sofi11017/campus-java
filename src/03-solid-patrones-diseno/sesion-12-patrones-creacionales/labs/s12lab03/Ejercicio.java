package s12lab03;
final class Ejercicio {
    private final String nombre;
    private int repeticiones;

    // Rutina comprueba los datos antes de crear los ejercicios.
    Ejercicio(String nombre, int repeticiones) {
        this.nombre = nombre;
        this.repeticiones = repeticiones;
    }
    boolean cambiarRepeticiones(int nuevas) {
        if (nuevas < 1 || nuevas > 100) {
            return false;
        }
        repeticiones = nuevas;
        return true;
    }
    Ejercicio copiar() {
        return new Ejercicio(nombre, repeticiones);
    }
    String resumen() {
        return nombre + "=" + repeticiones;
    }
}
