package reto03;

/**
 * Clase genérica propia con parámetro de tipo T.
 * Permite encapsular una descripción y un contenido tipado sin casts ni tipos raw.
 *
 * @param <T> Tipo del contenido almacenado.
 */
public class Evidencia<T> {
    private final String descripcion;
    private final T contenido;

    public Evidencia(String descripcion, T contenido) {
        if (descripcion == null || descripcion.strip().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede ser nula ni estar en blanco.");
        }
        if (contenido == null) {
            throw new IllegalArgumentException("El contenido de la evidencia no puede ser nulo.");
        }
        this.descripcion = descripcion.strip();
        this.contenido = contenido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public T getContenido() {
        return contenido;
    }

    public void mostrar() {
        System.out.println("[Evidencia] " + descripcion + ": " + contenido);
    }
}
