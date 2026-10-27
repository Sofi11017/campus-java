package s10lab01;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class RecuentoVotos {
    private final Map<String, Integer> votos = new TreeMap<>();

    public RecuentoVotos() {
        votos.put("A", 0);
        votos.put("B", 0);
        votos.put("C", 0);
    }

    public boolean votar(String entrada) {
        if (entrada == null) {
            return false;
        }
        String opcion = entrada.strip().toUpperCase(Locale.ROOT);
        if (!votos.containsKey(opcion)) {
            return false;
        }
        votos.put(opcion, votos.get(opcion) + 1);
        return true;
    }

    public int consultar(String opcion) {
        if (opcion == null) {
            return 0;
        }
        return votos.getOrDefault(opcion.strip().toUpperCase(Locale.ROOT), 0);
    }

    public int total() {
        int suma = 0;
        for (int cantidad : votos.values()) {
            suma += cantidad;
        }
        return suma;
    }

    public String reporte() {
        return votos.toString();
    }
}
