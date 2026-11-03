package s13lab01;

public class RegistroPrestamos {
    private int cantidad;

    public void registrar() {
        cantidad++;
    }

    public int consultarCantidad() {
        return cantidad;
    }
}
