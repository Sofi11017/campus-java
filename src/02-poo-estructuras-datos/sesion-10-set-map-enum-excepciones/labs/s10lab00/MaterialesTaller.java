package s10lab00;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

public class MaterialesTaller {
    private final Set<String> requeridos = new LinkedHashSet<>();
    private final Set<String> disponibles = new LinkedHashSet<>();

    private String normalizar(String texto) {
        return texto == null ? "" : texto.strip().toUpperCase(Locale.ROOT);
    }

    public boolean requerir(String material) {
        String valor = normalizar(material);
        return !valor.isEmpty() && requeridos.add(valor);
    }

    public boolean disponer(String material) {
        String valor = normalizar(material);
        return !valor.isEmpty() && disponibles.add(valor);
    }

    public Set<String> faltantes() {
        Set<String> copia = new LinkedHashSet<>(requeridos);
        copia.removeAll(disponibles);
        return copia;
    }

    public int cantidadRequeridos() {
        return requeridos.size();
    }

    public int cantidadDisponibles() {
        return disponibles.size();
    }
}
