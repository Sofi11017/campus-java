package s10lab02;

public class S10Lab02EnumMain {
    public static void main(String[] args) {
        for (Prioridad prioridad : Prioridad.values()) {
            System.out.println(prioridad.name() + ": " + prioridad.getLimiteMinutos() + " min");
        }
        Incidencia alta = new Incidencia(Prioridad.ALTA);
        alta.registrarMinutos(15);
        System.out.println(alta.resumen());
        alta.registrarMinutos(16);
        System.out.println(alta.resumen());
        Incidencia media = new Incidencia(Prioridad.MEDIA);
        media.registrarMinutos(45);
        System.out.println(media.resumen());
        Incidencia baja = new Incidencia(Prioridad.BAJA);
        baja.registrarMinutos(121);
        System.out.println(baja.resumen());
        System.out.println("Minutos negativos: " + baja.registrarMinutos(-1));
        System.out.println(baja.resumen());

        // Comprobaciones adicionales (paso 5 de la actividad)
        System.out.println("\n--- Comprobaciones adicionales (paso 5) ---");
        Incidencia mediaPrueba = new Incidencia(Prioridad.MEDIA);
        mediaPrueba.registrarMinutos(60);
        System.out.println("MEDIA 60 min (limite exacto) vencida: " + mediaPrueba.estaVencida());
        mediaPrueba.registrarMinutos(61);
        System.out.println("MEDIA 61 min (supera limite) vencida: " + mediaPrueba.estaVencida());

        Incidencia bajaPrueba = new Incidencia(Prioridad.BAJA);
        bajaPrueba.registrarMinutos(120);
        System.out.println("BAJA 120 min (limite exacto) vencida: " + bajaPrueba.estaVencida());
    }
}

