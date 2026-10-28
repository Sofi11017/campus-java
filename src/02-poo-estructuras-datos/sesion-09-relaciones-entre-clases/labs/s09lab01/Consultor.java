package s09lab01;

public class Consultor {
    private final String nombre;
    private Cliente cliente;

    public Consultor(String nombre) {
        this.nombre = nombre;
    }

    public boolean asignarCliente(Cliente cliente) {
        if (cliente == null) {
            return false;
        }
        this.cliente = cliente;
        return true;
    }

    public void liberarAsignacion() {
        cliente = null;
    }

    public String resumen() {
        if (cliente == null) {
            return nombre + ": sin cliente";
        }
        return nombre + ": " + cliente.getNombre();
    }
}