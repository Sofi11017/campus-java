package s13demo06;

import java.util.HashMap;
import java.util.Map;

public class FabricaEmbalajes {
    private final Map<TipoEmbalaje, TipoEmbalaje> embalajes = new HashMap<>();

    public TipoEmbalaje obtenerEmbalaje(String tipo, String material, String dimensiones) {
        TipoEmbalaje clave = new TipoEmbalaje(tipo, material, dimensiones);
        TipoEmbalaje existente = embalajes.get(clave);
        if (existente == null) {
            embalajes.put(clave, clave);
            existente = clave;
        }
        return existente;
    }

    public int consultarCantidadTipos() {
        return embalajes.size();
    }
}
