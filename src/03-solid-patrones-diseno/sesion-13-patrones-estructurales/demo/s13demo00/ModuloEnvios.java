package s13demo00;

import java.util.Objects;

public class ModuloEnvios {
    private final TarifadorEnvios tarifador;

    public ModuloEnvios(TarifadorEnvios tarifador) {
        this.tarifador = Objects.requireNonNull(tarifador);
    }

    public long consultarTarifa(double pesoKg) {
        return tarifador.calcularTarifa(pesoKg);
    }
}
