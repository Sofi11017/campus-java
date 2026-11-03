package s16lab02;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public final class EjecutorPrueba {
    private EjecutorPrueba() {
    }

    public static void ejecutar(Runnable[] tareas) throws InterruptedException {
        Objects.requireNonNull(tareas);
        if (tareas.length < 1 || tareas.length > 16) {
            throw new IllegalArgumentException("Entre 1 y 16 tareas");
        }
        for (Runnable tarea : tareas) {
            Objects.requireNonNull(tarea);
        }
        CountDownLatch inicio = new CountDownLatch(1);
        Thread[] hilos = new Thread[tareas.length];
        Throwable[] fallos = new Throwable[tareas.length];
        try {
            for (int indice = 0; indice < tareas.length; indice++) {
                final int posicion = indice;
                hilos[indice] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            inicio.await();
                            tareas[posicion].run();
                        } catch (InterruptedException error) {
                            Thread.currentThread().interrupt();
                            fallos[posicion] = error;
                        } catch (RuntimeException | Error error) {
                            // El resultado no debe confundirse con una carrera si una tarea fallo.
                            fallos[posicion] = error;
                        }
                    }
                }, "trabajador-" + (indice + 1));
                hilos[indice].start();
            }
            inicio.countDown();
            for (Thread hilo : hilos) {
                hilo.join(5_000);
                if (hilo.isAlive()) {
                    throw new IllegalStateException("La prueba excedio su plazo");
                }
            }
            for (Throwable fallo : fallos) {
                if (fallo != null) {
                    throw new IllegalStateException("Fallo de un trabajador", fallo);
                }
            }
        } finally {
            inicio.countDown();
            for (Thread hilo : hilos) {
                if (hilo != null && hilo.isAlive()) {
                    hilo.interrupt();
                }
            }
            for (Thread hilo : hilos) {
                if (hilo != null && hilo.isAlive()) {
                    hilo.join(1_000);
                }
            }
        }
    }
}
