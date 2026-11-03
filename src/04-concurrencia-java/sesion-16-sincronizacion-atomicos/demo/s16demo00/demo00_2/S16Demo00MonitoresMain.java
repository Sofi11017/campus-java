package s16demo00.demo00_2;

import java.util.concurrent.CountDownLatch;

public class S16Demo00MonitoresMain {
    public static void main(String[] args) throws InterruptedException {
        StockCompartido defectuoso = new StockCompartido();
        CountDownLatch leidos = new CountDownLatch(2);
        VentaConMonitorPropio primera = new VentaConMonitorPropio(defectuoso, leidos);
        VentaConMonitorPropio segunda = new VentaConMonitorPropio(defectuoso, leidos);
        System.out.println("Mismo monitor: " + primera.usaMismoMonitor(segunda));
        ejecutarPareja(primera, segunda);
        System.out.println("Intercalacion dirigida: esperado=98 observado="
                + defectuoso.leerSinProteccion());
        if (defectuoso.leerSinProteccion() != 99) {
            throw new IllegalStateException("La reproduccion dirigida no coincide");
        }

        // Instancia nueva: en esta parte todas las ventas usan el monitor del stock.
        final StockCompartido protegido = new StockCompartido();
        Runnable ventaProtegida = new Runnable() {
            @Override
            public void run() {
                protegido.venderProtegido();
            }
        };
        ejecutarPareja(ventaProtegida, ventaProtegida);
        System.out.println("Monitor compartido: esperado=98 observado="
                + protegido.consultarProtegido());
        if (protegido.consultarProtegido() != 98) {
            throw new IllegalStateException("El stock protegido es incorrecto");
        }
    }

    private static void ejecutarPareja(Runnable primera, Runnable segunda)
            throws InterruptedException {
        Thread hiloUno = new Thread(primera, "vendedor-1");
        Thread hiloDos = new Thread(segunda, "vendedor-2");
        try {
            hiloUno.start();
            hiloDos.start();
            hiloUno.join(5_000);
            hiloDos.join(5_000);
            if (hiloUno.isAlive() || hiloDos.isAlive()) {
                throw new IllegalStateException("Un vendedor no termino");
            }
        } finally {
            hiloUno.interrupt();
            hiloDos.interrupt();
            hiloUno.join(1_000);
            hiloDos.join(1_000);
        }
    }
}
