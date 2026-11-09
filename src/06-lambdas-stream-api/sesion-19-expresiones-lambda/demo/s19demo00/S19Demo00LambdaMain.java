package s19demo00;

public class S19Demo00LambdaMain {
    public static void main(String[] args) {
        int minimo = 100_000;
        ReglaMonto explicita = new ReglaMontoMinimo(minimo);
        ReglaMonto lambda = monto -> monto >= minimo;

        // Si descomentas esta reasignacion, minimo deja de ser effectively final.
        // minimo = 200_000;

        int[] montos = {150_000, 99_999, 100_000};
        for (int monto : montos) {
            System.out.println(monto + " | clase=" + evaluar(monto, explicita)
                    + " | lambda=" + evaluar(monto, lambda));
        }

        ReglaMonto positiva = monto -> {
            return monto > 0;
        };
        System.out.println("Positivo 25: " + positiva.cumple(25));
        System.out.println("Positivo -3: " + positiva.cumple(-3));
    }

    public static boolean evaluar(int monto, ReglaMonto regla) {
        return regla.cumple(monto);
    }
}
