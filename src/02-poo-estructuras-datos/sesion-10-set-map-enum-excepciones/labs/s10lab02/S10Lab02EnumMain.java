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
    }
}
