package s15demo01;

public class S15Demo01InterrupcionMain {
    public static void main(String[] args) throws InterruptedException {
        ejecutar("normal", false);
        ejecutar("cancelada", true);
        System.out.println("Fin: consultas terminadas");
    }

    private static void ejecutar(String nombre, boolean cancelar) throws InterruptedException {
        ConsultaStock consulta = new ConsultaStock(cancelar ? 5_000 : 50);
        Thread hilo = new Thread(consulta, nombre);
        try {
            hilo.start();
            consulta.esperarInicio();
            if (cancelar) {
                hilo.interrupt();
            }
            hilo.join();
            System.out.println(nombre + ": " + consulta.consultarResultado());
            System.out.println("Vivo tras join: " + hilo.isAlive());
        } finally {
            if (hilo.isAlive()) {
                hilo.interrupt();
            }
        }
    }
}
