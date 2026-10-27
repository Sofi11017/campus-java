package reto03;

import java.util.Locale;

/**
 * Clase base abstracta que representa una entrega de material reciclable.
 * Aplica el principio de encapsulamiento protegiendo el ID y el peso en gramos.
 */
public abstract class EntregaReciclaje implements Comprobable {
    private final String id;
    private final int pesoGramos;

    public EntregaReciclaje(String id, int pesoGramos) {
        if (id == null || id.strip().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede ser nulo ni estar en blanco.");
        }
        if (pesoGramos < 100 || pesoGramos > 10000) {
            throw new IllegalArgumentException("El peso debe estar entre 100 y 10000 gramos. Recibido: " + pesoGramos);
        }
        this.id = id.strip().toUpperCase(Locale.ROOT);
        this.pesoGramos = pesoGramos;
    }

    public String getId() {
        return id;
    }

    public int getPesoGramos() {
        return pesoGramos;
    }

    /**
     * Retorna el tipo de material reciclable (por ejemplo, "Papel" o "Plástico").
     */
    public abstract String getMaterial();

    /**
     * Calcula los puntos otorgados por la entrega según el material concreto.
     */
    public abstract int calcularPuntos();

    @Override
    public String generarComprobante() {
        return String.format(Locale.ROOT, "Comprobante [ID: %s, Material: %s, Gramos: %d g, Puntos: %d]",
                id, getMaterial(), pesoGramos, calcularPuntos());
    }
}
