package s13demo06;

import java.util.Objects;

public final class TipoEmbalaje {
    private final String tipo;
    private final String material;
    private final String dimensiones;

    public TipoEmbalaje(String tipo, String material, String dimensiones) {
        this.tipo = validar(tipo);
        this.material = validar(material);
        this.dimensiones = validar(dimensiones);
    }

    private static String validar(String texto) {
        if (Objects.requireNonNull(texto).isBlank()) {
            throw new IllegalArgumentException("Caracteristica vacia");
        }
        return texto.strip();
    }

    public String descripcion() {
        return tipo + " / " + material + " / " + dimensiones;
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) {
            return true;
        }
        if (!(otro instanceof TipoEmbalaje)) {
            return false;
        }
        TipoEmbalaje embalaje = (TipoEmbalaje) otro;
        return tipo.equals(embalaje.tipo) && material.equals(embalaje.material)
                && dimensiones.equals(embalaje.dimensiones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, material, dimensiones);
    }
}
