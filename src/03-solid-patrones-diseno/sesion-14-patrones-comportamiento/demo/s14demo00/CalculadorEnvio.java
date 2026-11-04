package s14demo00;

import java.util.Objects;

public class CalculadorEnvio {
    private EstrategiaEnvio estrategia;

    public CalculadorEnvio(EstrategiaEnvio estrategia) {
        this.estrategia = Objects.requireNonNull(estrategia);
    }

    public void cambiarEstrategia(EstrategiaEnvio estrategia) {
        this.estrategia = Objects.requireNonNull(estrategia);
    }

    public long calcular(int unidades) {
        return estrategia.calcular(unidades);
    }
}
