package s13lab01;

import java.util.Objects;

public class PrestamoFacade {
    private final Catalogo catalogo;
    private final RegistroPrestamos registro;
    private final EmisorRecibo recibos;

    public PrestamoFacade(Catalogo catalogo, RegistroPrestamos registro, EmisorRecibo recibos) {
        this.catalogo = Objects.requireNonNull(catalogo);
        this.registro = Objects.requireNonNull(registro);
        this.recibos = Objects.requireNonNull(recibos);
    }

    public String prestar(Membresia membresia) {
        if (membresia == null || !membresia.estaVigente()) {
            return "Membresia vencida o ausente";
        }
        if (!catalogo.reservar()) {
            return "Ejemplar no disponible";
        }
        registro.registrar();
        recibos.emitir();
        return "Prestamo registrado";
    }
}
