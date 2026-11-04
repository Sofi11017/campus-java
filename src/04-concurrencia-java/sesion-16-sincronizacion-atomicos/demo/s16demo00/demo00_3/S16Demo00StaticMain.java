package s16demo00.demo00_3;

import java.util.HashSet;
import java.util.Set;

public class S16Demo00StaticMain {
    public static void main(String[] args) throws InterruptedException {
        int[] numeros = new int[2];
        Thread[] hilos = new Thread[2];
        for (int indice = 0; indice < hilos.length; indice++) {
            final int posicion = indice;
            hilos[indice] = new Thread(new Runnable() {
                @Override
                public void run() {
                    numeros[posicion] = Numerador.obtenerSiguiente();
                }
            }, "numerador-" + (indice + 1));
        }
        try {
            for (Thread hilo : hilos) {
                hilo.start();
            }
            for (Thread hilo : hilos) {
                hilo.join(5_000);
                if (hilo.isAlive()) {
                    throw new IllegalStateException("Un numerador no termino");
                }
            }
            Set<Integer> unicos = new HashSet<>();
            for (int numero : numeros) {
                unicos.add(numero);
            }
            System.out.println("Identificadores distintos: " + unicos.size());
            System.out.println("Monitor: Numerador.class");
            if (unicos.size() != 2 || unicos.contains(0)) {
                throw new IllegalStateException("Numeracion incorrecta");
            }
        } finally {
            for (Thread hilo : hilos) {
                if (hilo.isAlive()) {
                    hilo.interrupt();
                }
            }
            for (Thread hilo : hilos) {
                if (hilo.isAlive()) {
                    hilo.join(1_000);
                }
            }
        }
    }
}
