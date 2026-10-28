package s07demo00.base;

public class Usuario {
    private final String nombre;

    public Usuario(String nombre) {
        // Los datos proporcionados por el demo son válidos.
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    protected String describirIdentidad() {

        return "Usuario: " + nombre;
    }
}
