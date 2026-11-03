package s15lab01;

public class S15Lab01CitasMain {
    public static void main(String[] args) throws InterruptedException {
        ejecutar("Consulta-A", false);
        boolean cancelarSegunda = true;
        ejecutar("Consulta-B", cancelarSegunda);
        System.out.println("Fin: consultas de citas terminadas");
    }

    private static void ejecutar(String nombre, boolean cancelar) throws InterruptedException {
        ConsultaDisponibilidad consulta = new ConsultaDisponibilidad(cancelar ? 5_000 : 50);
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
