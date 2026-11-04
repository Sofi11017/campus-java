package s14lab03;

import java.util.ArrayList;
import java.util.List;

public class GestorBiblioteca {
    private final List<Boolean> resultados = new ArrayList<>();

    public boolean ejecutar(ComandoBiblioteca comando) {
        boolean resultado = java.util.Objects.requireNonNull(comando).ejecutar();
        resultados.add(resultado);
        return resultado;
    }

    public List<Boolean> consultarResultados() {
        return List.copyOf(resultados);
    }
}
