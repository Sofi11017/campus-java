package s16demo01;

public class S16Demo01VolatileMain {
    public static void main(String[] args) throws InterruptedException {
        TrabajadorCalculador tarea = new TrabajadorCalculador(256);
        Thread hilo = new Thread(tarea, "calculador");
        try {
            hilo.start();
            tarea.esperarPrimerLote();
            tarea.solicitarDetencion();
            hilo.join(5_000);
            if (hilo.isAlive()) {
                throw new IllegalStateException("No termino en plazo");
            }
            System.out.println("Resultado: " + tarea.consultarResultado());
            System.out.println("Lotes completos: " + tarea.consultarLotes());
            System.out.println("Resumen coherente: " + tarea.resumenCoherente());
            System.out.println("Hilo vivo: " + hilo.isAlive());
            if (!tarea.resumenCoherente()) {
                throw new IllegalStateException("Resumen incorrecto");
            }
            if (!tarea.consultarResultado().equals("DETENIDO_POR_BANDERA")) {
                System.out.println("No concluyente: se alcanzo un limite, repetir sin pausas de Debug");
            }
        } finally {
            tarea.solicitarDetencion();
            if (hilo.isAlive()) {
                hilo.interrupt();
                hilo.join(1_000);
            }
        }
    }
}
