package s13lab02;

public class EmpaqueEcologico extends DecoradorEmpaque {
    public EmpaqueEcologico(Empaque empaque) {
        super(empaque);
    }

    @Override
    public long calcularCosto() {
        return Math.addExact(empaque.calcularCosto(), 2_000);
    }
}
