package s16demo02;

import java.util.concurrent.atomic.AtomicInteger;

public class S16Demo02ContadoresMain {
    public static int contar(Contador contador, int hilos, int incrementos)
            throws InterruptedException {
        if (hilos < 1 || hilos > 16) {
            throw new IllegalArgumentException("Hilos entre 1 y 16");
        }
        Runnable[] tareas = new Runnable[hilos];
        for (int indice = 0; indice < hilos; indice++) {
            tareas[indice] = new TrabajadorContador(contador, incrementos);
        }
        EjecutorPrueba.ejecutar(tareas);
        return contador.consultar();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int intento = 1; intento <= 3; intento++) {
            int inseguro = contar(new ContadorVolatile(), 10, 100);
            int seguro = contar(new ContadorAtomico(), 10, 100);
            System.out.println("Prueba " + intento + ": esperado=1000 volatile=" + inseguro
                    + " atomico=" + seguro);
            if (seguro != 1000) {
                throw new IllegalStateException("Contador atomico incorrecto");
            }
        }
        AtomicInteger ejemplo = new AtomicInteger(0);
        System.out.println("incrementAndGet devuelve: " + ejemplo.incrementAndGet());
        System.out.println("getAndIncrement devuelve: " + ejemplo.getAndIncrement());
        System.out.println("Valor actual: " + ejemplo.get());
        System.out.println("addAndGet(3) devuelve: " + ejemplo.addAndGet(3));
    }
}
