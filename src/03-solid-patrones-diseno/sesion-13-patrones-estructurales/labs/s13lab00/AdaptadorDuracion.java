package s13lab00;

import java.util.Objects;

public class AdaptadorDuracion implements DuracionCita {
    private final BibliotecaSegundos biblioteca;

    public AdaptadorDuracion(BibliotecaSegundos biblioteca) {
        this.biblioteca = Objects.requireNonNull(biblioteca);
    }

    @Override
    public double consultarMinutos() {
        return biblioteca.obtenerSegundos() / 60.0;
    }
}
