package s16lab00;

public final class PruebaReservas {
    private PruebaReservas() {
    }

    public static String ejecutar(Cupos cupos, int participantes, int intentos,
                                  boolean exigirCoherencia) throws InterruptedException {
        if (participantes < 1 || participantes > 16) {
            throw new IllegalArgumentException("Participantes entre 1 y 16");
        }
        int inicial = cupos.consultarDisponibles();
        Participante[] tareas = new Participante[participantes];
        for (int indice = 0; indice < participantes; indice++) {
            tareas[indice] = new Participante(cupos, intentos);
        }
        EjecutorPrueba.ejecutar(tareas);
        int reservas = 0;
        for (Participante participante : tareas) {
            reservas += participante.consultarReservas();
        }
        int finalDisponibles = cupos.consultarDisponibles();
        int totalIntentos = participantes * intentos;
        boolean coherente = finalDisponibles >= 0 && reservas <= inicial
                && inicial == reservas + finalDisponibles
                && reservas == Math.min(inicial, totalIntentos);
        if (exigirCoherencia && !coherente) {
            throw new IllegalStateException("Cupos incoherente");
        }
        return "disponibles=" + finalDisponibles + " reservas=" + reservas
                + " rechazos=" + (totalIntentos - reservas) + " coherente=" + coherente;
    }
}
