package s13demo00;

import java.math.BigDecimal;
import java.util.Objects;

public class AdaptadorProveedorEnvios implements TarifadorEnvios {
    private final ProveedorLogistico proveedor;

    public AdaptadorProveedorEnvios(ProveedorLogistico proveedor) {
        this.proveedor = Objects.requireNonNull(proveedor);
    }

    static long convertirGramos(double pesoKg) {
        if (!Double.isFinite(pesoKg) || pesoKg <= 0 || pesoKg > 100) {
            throw new IllegalArgumentException("Peso entre 0.001 y 100 kg, en gramos enteros");
        }
        try {
            return BigDecimal.valueOf(pesoKg).movePointRight(3).longValueExact();
        } catch (ArithmeticException error) {
            throw new IllegalArgumentException("No se admiten fracciones de gramo", error);
        }
    }

    @Override
    public long calcularTarifa(double pesoKg) {
        return proveedor.cotizarEnGramos(convertirGramos(pesoKg));
    }
}
