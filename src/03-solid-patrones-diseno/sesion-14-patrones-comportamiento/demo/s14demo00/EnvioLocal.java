package s14demo00;

public class EnvioLocal implements EstrategiaEnvio {
    @Override
    public long calcular(int unidades) {
        if (unidades < 1 || unidades > 100) {
            throw new IllegalArgumentException("Unidades entre 1 y 100");
        }
        return 5_000 + unidades * 1_000L;
    }
}
