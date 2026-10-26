package s12demo02;
import java.time.LocalDate;

public final class Solicitud {
    private final String solicitante;
    private final LocalDate fecha;
    private final Prioridad prioridad;
    private final String instrucciones;
    private final String direccionAlternativa;
    private final boolean seguro;

    Solicitud(String solicitante, LocalDate fecha, Prioridad prioridad,
            String instrucciones, String direccionAlternativa, boolean seguro) {
        this.solicitante = solicitante;
        this.fecha = fecha;
        this.prioridad = prioridad;
        this.instrucciones = instrucciones;
        this.direccionAlternativa = direccionAlternativa;
        this.seguro = seguro;
    }
    public Prioridad getPrioridad() {
        return prioridad;
    }
    public String resumen() {
        return solicitante + " | " + fecha + " | " + prioridad + " | seguro=" + seguro
                + " | instrucciones=[" + instrucciones + "] | direccion=[" + direccionAlternativa + "]";
    }
}
