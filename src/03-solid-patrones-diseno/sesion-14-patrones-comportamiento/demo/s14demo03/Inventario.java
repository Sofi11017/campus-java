package s14demo03;

public class Inventario {
    private int unidades;

    public boolean ingresar(int cantidad) {
        if (cantidad < 1 || cantidad > 100 - unidades) {
            return false;
        }
        unidades += cantidad;
        return true;
    }

    public boolean retirar(int cantidad) {
        if (cantidad < 1 || cantidad > unidades) {
            return false;
        }
        unidades -= cantidad;
        return true;
    }

    public int consultar() {
        return unidades;
    }
}
