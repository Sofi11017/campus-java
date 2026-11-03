package s16demo02;

public class S16Demo02IntercalacionMain {
    public static void main(String[] args) throws InterruptedException {
        final IncrementoVolatileDirigido contador = new IncrementoVolatileDirigido();
        Runnable[] tareas = new Runnable[2];
        for (int indice = 0; indice < tareas.length; indice++) {
            tareas[indice] = new Runnable() {
                @Override
                public void run() {
                    contador.incrementarDesglosado();
                }
            };
        }
        EjecutorPrueba.ejecutar(tareas);
        System.out.println("Incremento desglosado dirigido: esperado=2 observado=" + contador.consultar());
        if (contador.consultar() != 1) {
            throw new IllegalStateException("Intercalacion inesperada");
        }

        // Aunque valor sea volatile, eso no convierte lectura → cálculo → escritura en una sola operación atómica.
        // La segunda escritura utiliza el 0 que ese hilo ya había guardado en su variable local.
    }
}
