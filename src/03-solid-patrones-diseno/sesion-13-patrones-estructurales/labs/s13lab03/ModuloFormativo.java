package s13lab03;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModuloFormativo implements ElementoFormativo {
    private final List<ElementoFormativo> elementos = new ArrayList<>();

    public void agregarElementoFormativo(ElementoFormativo elemento) {
        Objects.requireNonNull(elemento);
        if (elemento == this || elemento instanceof ModuloFormativo
                && ((ModuloFormativo) elemento).contiene(this)) {
            throw new IllegalArgumentException("La insercion genera un ciclo");
        }
        elementos.add(elemento);
    }

    private boolean contiene(ElementoFormativo buscado) {
        for (ElementoFormativo elemento : elementos) {
            if (elemento == buscado || elemento instanceof ModuloFormativo
                    && ((ModuloFormativo) elemento).contiene(buscado)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public long calcularMinutos() {
        long total = 0;
        for (ElementoFormativo elemento : elementos) {
            total = Math.addExact(total, elemento.calcularMinutos());
        }
        return total;
    }
}
