package s13lab02;

public class SeguroEmpaque extends DecoradorEmpaque {
    public SeguroEmpaque(Empaque empaque) {
        super(empaque);
    }

    @Override
    public long calcularCosto() {
        return Math.addExact(empaque.calcularCosto(), 3_000);
    }
}
