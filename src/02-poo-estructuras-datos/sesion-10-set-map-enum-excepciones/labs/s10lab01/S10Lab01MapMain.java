package s10lab01;

public class S10Lab01MapMain {
    public static void main(String[] args) {
        RecuentoVotos recuento = new RecuentoVotos();
        String[] secuencia = {"A", "B", "A", "C", "B", "A"};
        for (String voto : secuencia) {
            recuento.votar(voto);
        }
        System.out.println("Recuento: " + recuento.reporte());
        System.out.println("Total: " + recuento.total());
        System.out.println("Votar X: " + recuento.votar("X"));
        System.out.println("Total conservado: " + recuento.total());

        // Comprobacion adicional (paso 4: secuencia alterada C, A, B, A, B, A)
        System.out.println("\n--- Comprobacion paso 4: secuencia distinta ---");
        RecuentoVotos recuentoOrden = new RecuentoVotos();
        String[] secuenciaOrden = {"C", "A", "B", "A", "B", "A"};
        for (String voto : secuenciaOrden) {
            recuentoOrden.votar(voto);
        }
        System.out.println("Recuento orden alternativo: " + recuentoOrden.reporte());
        System.out.println("Total orden alternativo: " + recuentoOrden.total());

        // Comprobacion adicional (paso 5: secuencia vacia y casos borde)
        System.out.println("\n--- Comprobacion paso 5: casos borde ---");
        RecuentoVotos recuentoBorde = new RecuentoVotos();
        System.out.println("Secuencia vacia reporte: " + recuentoBorde.reporte());
        System.out.println("Secuencia vacia total: " + recuentoBorde.total());
        System.out.println("Votar ' a ': " + recuentoBorde.votar(" a "));
        System.out.println("Votar null: " + recuentoBorde.votar(null));
        System.out.println("Votar X: " + recuentoBorde.votar("X"));
        System.out.println("Reporte final casos borde: " + recuentoBorde.reporte());
        System.out.println("Total final casos borde: " + recuentoBorde.total());
    }
}

