package s13demo06;

import java.util.Objects;

public final class Paquete {
    private final String codigo;
    private final String destinatario;
    private final double pesoKg;
    private final TipoEmbalaje embalaje;

    public Paquete(String codigo, String destinatario, double pesoKg, TipoEmbalaje embalaje) {
        this.codigo = Objects.requireNonNull(codigo);
        this.destinatario = Objects.requireNonNull(destinatario);
        if (!Double.isFinite(pesoKg) || pesoKg <= 0) {
            throw new IllegalArgumentException("Peso positivo y finito");
        }
        this.pesoKg = pesoKg;
        this.embalaje = Objects.requireNonNull(embalaje);
    }

    public TipoEmbalaje getEmbalaje() {
        return embalaje;
    }

    public String descripcion() {
        return codigo + " para " + destinatario + " (" + pesoKg + " kg): "
                + embalaje.descripcion();
    }
}
