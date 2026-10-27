package s10lab03;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RegistroTemperaturas {
    private final List<Integer> lecturas = new ArrayList<>();
    private int rechazadas;

    public boolean registrar(String texto) {
        if (texto == null || texto.isBlank()) {
            rechazadas++;
            System.out.println("Rechazada: dato obligatorio");
            return false;
        }
        int valor;
        try {
            valor = Integer.parseInt(texto.strip());
        } catch (NumberFormatException error) {
            rechazadas++;
            System.out.println("Rechazada: no es entero [" + texto + "]");
            return false;
        }
        if (valor < -10 || valor > 50) {
            rechazadas++;
            System.out.println("Rechazada: fuera de rango [" + texto + "]");
            return false;
        }
        lecturas.add(valor);
        return true;
    }

    public int aceptadas() {
        return lecturas.size();
    }

    public int rechazadas() {
        return rechazadas;
    }

    public String lecturasComoTexto() {
        return lecturas.toString();
    }

    public String promedioComoTexto() {
        if (lecturas.isEmpty()) {
            return "Sin datos";
        }
        long suma = 0;
        for (int valor : lecturas) {
            suma += valor;
        }
        return String.format(Locale.ROOT, "%.4f", (double) suma / lecturas.size());
    }
}
