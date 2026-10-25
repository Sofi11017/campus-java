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
    }
}
