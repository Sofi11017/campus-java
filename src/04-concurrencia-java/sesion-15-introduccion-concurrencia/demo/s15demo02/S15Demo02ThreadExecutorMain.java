package s15demo02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class S15Demo02ThreadExecutorMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String[] nombres = {"Validar datos del prestamo", "Preparar borrador de aviso", "Consultar catalogo"};
        System.out.println("=== Thread: un hilo nuevo por tarea ===");
        ejecutarConThread(nombres);
        System.out.println("=== Executor: pool de 2 hilos ===");
        ejecutarConExecutor(nombres);
        System.out.println("Fin: todas las tareas terminaron");
    }

    private static void ejecutarConThread(String[] nombres) throws InterruptedException {
        List<Thread> hilos = new ArrayList<>();
        try {
            for (int indice = 0; indice < nombres.length; indice++) {
                Thread hilo = new Thread(new OperacionBiblioteca(nombres[indice]),
                        "manual-" + (indice + 1));
                hilos.add(hilo);
                hilo.start();
            }
            for (Thread hilo : hilos) {
                hilo.join();
            }
        } finally {
            for (Thread hilo : hilos) {
                if (hilo.isAlive()) {
                    hilo.interrupt();
                }
            }
        }
    }

    private static void ejecutarConExecutor(String[] nombres)
            throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<?>> pendientes = new ArrayList<>();
        try {
            for (String nombre : nombres) {
                pendientes.add(executor.submit(new OperacionBiblioteca(nombre)));
            }
            // No acepta nuevas tareas; las ya enviadas siguen ejecutandose.
            executor.shutdown();
            for (Future<?> pendiente : pendientes) {
                pendiente.get();
            }
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                throw new IllegalStateException("El ejecutor no termino en el plazo de cierre");
            }
        } finally {
            // Tambien solicita cierre si get o la espera fallan.
            executor.shutdownNow();
        }
    }
}
