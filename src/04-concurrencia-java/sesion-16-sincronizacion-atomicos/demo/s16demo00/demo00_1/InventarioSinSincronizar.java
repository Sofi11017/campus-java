package s16demo00.demo00_1;

public final class InventarioSinSincronizar implements Inventario {
    private int stock;

    public InventarioSinSincronizar(int stock) {
        if (stock < 0 || stock > 1_000_000) {
            throw new IllegalArgumentException("Stock entre 0 y 1000000");
        }
        this.stock = stock;
    }

    @Override
    public boolean venderUnaUnidad() {
        if (stock <= 0) {
            return false;
        }
        int observado = stock;
        stock = observado - 1;
        return true;
    }

    @Override
    public int consultarStock() {
        return stock;
    }
}
