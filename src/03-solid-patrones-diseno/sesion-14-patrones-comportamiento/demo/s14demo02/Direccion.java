package s14demo02;

public class Direccion extends ManejadorCompra {
    public Direccion(ManejadorCompra siguiente) {
        super(siguiente);
    }

    @Override
    protected long limite() {
        return 1000000L;
    }

    @Override
    protected String responsable() {
        return "Direccion";
    }
}
