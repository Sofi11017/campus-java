package s12demo02;
import java.time.LocalDate;

public class S12Demo02BuilderMain {
    public static void main(String[] args) {
        SolicitudBuilder builder = new SolicitudBuilder()
                .solicitante("Carlos")
                .fecha(LocalDate.of(2026, 1, 15))
                .prioridad(Prioridad.ALTA)
                .seguro(true);
        Solicitud primera = builder.build();
        Solicitud segunda = builder.prioridad(Prioridad.BAJA).build();
        System.out.println(primera.resumen());
        System.out.println("Primera conserva: " + primera.getPrioridad());
        System.out.println("Segunda usa: " + segunda.getPrioridad());
        System.out.println("Objetos distintos: " + (primera != segunda));
        try {
            new SolicitudBuilder().build();
        } catch (IllegalStateException error) {
            System.out.println("Construccion rechazada: " + error.getMessage());
        }
    }
}
