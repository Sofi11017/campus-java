package reto03;

/**
 * Representa una entrega de plástico.
 * Otorga 2 puntos por cada bloque completo de 100 gramos.
 */
public class EntregaPlastico extends EntregaReciclaje {

    public EntregaPlastico(String id, int pesoGramos) {
        super(id, pesoGramos);
    }

    @Override
    public String getMaterial() {
        return "Plástico";
    }

    @Override
    public int calcularPuntos() {
        // 2 puntos por cada 100 gramos completos. El sobrante no otorga puntos.
        return (getPesoGramos() / 100) * 2;
    }
}
