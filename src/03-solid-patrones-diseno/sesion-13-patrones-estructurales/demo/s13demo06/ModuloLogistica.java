package s13demo06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModuloLogistica {
    private final List<Paquete> paquetes = new ArrayList<>();

    public void registrar(Paquete paquete) {
        paquetes.add(Objects.requireNonNull(paquete));
    }

    public int consultarCantidad() {
        return paquetes.size();
    }
}
