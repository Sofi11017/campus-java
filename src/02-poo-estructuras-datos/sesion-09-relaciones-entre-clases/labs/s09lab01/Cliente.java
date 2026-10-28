package s09lab01;

public class Cliente {
    private final String nombre;

    // Los escenarios proporcionan nombres válidos y no vacíos.
    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}