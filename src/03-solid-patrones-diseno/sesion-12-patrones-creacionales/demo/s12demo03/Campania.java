package s12demo03;
import java.util.ArrayList;
import java.util.List;

public class Campania {
    private final String nombre;
    private final List<String> etiquetas = new ArrayList<>();
    private final List<String> segmentos = new ArrayList<>();

    public Campania(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre obligatorio");
        }
        this.nombre = nombre.strip();
    }
    public boolean agregarEtiqueta(String texto) {
        if (texto == null || texto.isBlank()) {
            return false;
        }
        etiquetas.add(texto.strip());
        return true;
    }
    public boolean agregarSegmento(String texto) {
        if (texto == null || texto.isBlank()) {
            return false;
        }
        segmentos.add(texto.strip());
        return true;
    }
    public Campania copiar(String nuevoNombre) {
        Campania copia = new Campania(nuevoNombre);
        // Listas independientes; sus elementos String son inmutables.
        copia.etiquetas.addAll(etiquetas);
        copia.segmentos.addAll(segmentos);
        return copia;
    }
    public String resumen() {
        return nombre + " etiquetas=" + etiquetas + " segmentos=" + segmentos;
    }
}
