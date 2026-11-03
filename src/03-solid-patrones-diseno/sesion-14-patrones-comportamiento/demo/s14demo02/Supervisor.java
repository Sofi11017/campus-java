package s14demo02;

public class Supervisor extends ManejadorCompra {
    public Supervisor(ManejadorCompra siguiente) {
        super(siguiente);
    }

    @Override
    protected long limite() {
        return 100000L;
    }

    @Override
    protected String responsable() {
        return "Supervisor";
    }
}
