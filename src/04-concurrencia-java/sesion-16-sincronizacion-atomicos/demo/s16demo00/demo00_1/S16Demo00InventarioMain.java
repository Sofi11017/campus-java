package s16demo00.demo00_1;

public class S16Demo00InventarioMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Caso pequeno: esperado stock=98, ventas=2");
        System.out.println("Sin proteger: " + ejecutarPrueba(new InventarioSinSincronizar(100), 2, 1, false));
        System.out.println("Metodo: " + ejecutarPrueba(new InventarioMetodo(100), 2, 1, true));
        System.out.println("Bloque: " + ejecutarPrueba(new InventarioBloque(100), 2, 1, true));

        for (int intento = 1; intento <= 3; intento++) {
            System.out.println("Prueba " + intento + ": esperado stock=6000, ventas=4000");
            System.out.println("Sin proteger: " + ejecutarPrueba(new InventarioSinSincronizar(10_000), 4, 1_000, false));
            System.out.println("Metodo: " + ejecutarPrueba(new InventarioMetodo(10_000), 4, 1_000, true));
            System.out.println("Bloque: " + ejecutarPrueba(new InventarioBloque(10_000), 4, 1_000, true));
        }
        System.out.println("Agotamiento metodo: " + ejecutarPrueba(new InventarioMetodo(100), 2, 80, true));
        System.out.println("Agotamiento bloque: " + ejecutarPrueba(new InventarioBloque(100), 2, 80, true));
    }

    public static String ejecutarPrueba(Inventario inventario, int vendedores, int intentos, boolean exigirCoherencia) throws InterruptedException {
        if (vendedores < 1 || vendedores > 16) {
            throw new IllegalArgumentException("Vendedores entre 1 y 16");
        }
        int inicial = inventario.consultarStock();
        Vendedor[] tareas = new Vendedor[vendedores];
        Thread[] hilos = new Thread[vendedores];
        for (int indice = 0; indice < vendedores; indice++) {
            tareas[indice] = new Vendedor(inventario, intentos);
            hilos[indice] = new Thread(tareas[indice], "vendedor-" + (indice + 1));
        }
        try {
            // Iniciar todos antes de esperar: start y join quedan visibles en el Main.
            for (Thread hilo : hilos) {
                hilo.start();
            }
            for (Thread hilo : hilos) {
                hilo.join(5_000);
                if (hilo.isAlive()) {
                    throw new IllegalStateException("Un vendedor no termino en plazo");
                }
            }
            int ventas = 0;
            for (Vendedor tarea : tareas) {
                if (!tarea.completoIntentos()) {
                    throw new IllegalStateException("Un vendedor no completo su trabajo");
                }
                ventas += tarea.consultarVentas();
            }
            int stockFinal = inventario.consultarStock();
            int totalIntentos = vendedores * intentos;
            boolean coherente = stockFinal >= 0 && ventas <= inicial && inicial == ventas + stockFinal && ventas == Math.min(inicial, totalIntentos);
            if (exigirCoherencia && !coherente) {
                throw new IllegalStateException("Inventario incoherente");
            }
            return "stock=" + stockFinal + " ventas=" + ventas + " rechazos=" + (totalIntentos - ventas) + " coherente=" + coherente;
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
