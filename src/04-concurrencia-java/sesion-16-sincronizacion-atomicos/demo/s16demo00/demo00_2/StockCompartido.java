package s16demo00.demo00_2;

public final class StockCompartido {
    private int unidades = 100;

    // Accesos deliberadamente defectuosos para la primera parte de la demostracion.
    public int leerSinProteccion() {
        return unidades;
    }

    public void escribirSinProteccion(int unidades) {
        this.unidades = unidades;
    }

    // La segunda parte usa otra instancia y coordina las ventas con el mismo this.
    public synchronized boolean venderProtegido() {
        if (unidades <= 0) {
            return false;
        }
        unidades--;
        return true;
    }

    public synchronized int consultarProtegido() {
        return unidades;
    }
}
