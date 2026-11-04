package s13demo00;

public class ProveedorLogistico {
    public long cotizarEnGramos(long gramos) {
        if (gramos < 1 || gramos > 100_000) {
            throw new IllegalArgumentException("Peso fuera de rango");
        }
        System.out.println("[ProveedorLogistico] Proveedor recibe: " + gramos + " g");
        return 5_000 + gramos * 2;
    }
}
