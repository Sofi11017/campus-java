package s13demo00;

public class ProveedorLogisticoKg implements TarifadorEnvios {
    @Override
    public long calcularTarifa(double pesoKg) {
        long gramos = AdaptadorProveedorEnvios.convertirGramos(pesoKg);
        return 6_000 + gramos;
    }
}
