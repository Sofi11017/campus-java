package s14demo03;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestorComandos {
    private final List<Boolean> resultados = new ArrayList<>();

    public boolean ejecutar(Comando comando) {
        boolean exitoso = Objects.requireNonNull(comando).ejecutar();
        resultados.add(exitoso);
        return exitoso;
    }

    public List<Boolean> consultarResultados() {
        return List.copyOf(resultados);
    }
}
