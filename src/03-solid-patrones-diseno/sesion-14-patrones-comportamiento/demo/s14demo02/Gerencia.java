package s14demo02;

public class Gerencia extends ManejadorCompra {
    public Gerencia(ManejadorCompra siguiente) {
        super(siguiente);
    }

    @Override
    protected long limite() {
        return 500000L;
    }

    @Override
    protected String responsable() {
        return "Gerencia";
    }
}
