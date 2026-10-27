package reto03;

/**
 * Representa una entrega de papel.
 * Otorga 1 punto por cada bloque completo de 100 gramos.
 */
public class EntregaPapel extends EntregaReciclaje {

    public EntregaPapel(String id, int pesoGramos) {
        super(id, pesoGramos);
    }

    @Override
    public String getMaterial() {
        return "Papel";
    }

    @Override
    public int calcularPuntos() {
        // 1 punto por cada 100 gramos completos. El sobrante no otorga puntos.
        return (getPesoGramos() / 100) * 1;
    }
}
