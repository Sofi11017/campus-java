package s15lab00;

public class S15Lab00BibliotecaMain {
    public static void main(String[] args) throws InterruptedException {
        TareaBiblioteca directa = new TareaBiblioteca("Consulta directa");
        directa.run();

        Thread prestamo = new Thread(
                new TareaBiblioteca("Validar datos del prestamo"), "prestamos");
        Thread aviso = new Thread(
                new TareaBiblioteca("Preparar borrador de aviso"), "avisos");
        try {
            prestamo.start();
            aviso.start();
            prestamo.join();
            aviso.join();
            System.out.println("Fin: tareas de biblioteca terminadas");
        } finally {
            if (prestamo.isAlive()) {
                prestamo.interrupt();
            }
            if (aviso.isAlive()) {
                aviso.interrupt();
            }
        }
    }
}
