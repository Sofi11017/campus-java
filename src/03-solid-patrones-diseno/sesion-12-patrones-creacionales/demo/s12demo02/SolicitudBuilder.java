package s12demo02;
import java.time.LocalDate;

public class SolicitudBuilder {
    private String solicitante;
    private LocalDate fecha;
    private Prioridad prioridad;
    private String instrucciones = "";
    private String direccionAlternativa = "";
    private boolean seguro;

    public SolicitudBuilder solicitante(String valor) {
        solicitante = valor;
        return this;
    }
    public SolicitudBuilder fecha(LocalDate valor) {
        fecha = valor;
        return this;
    }
    public SolicitudBuilder prioridad(Prioridad valor) {
        prioridad = valor;
        return this;
    }
    public SolicitudBuilder instrucciones(String valor) {
        instrucciones = valor == null ? "" : valor.strip();
        return this;
    }
    public SolicitudBuilder direccionAlternativa(String valor) {
        direccionAlternativa = valor == null ? "" : valor.strip();
        return this;
    }
    public SolicitudBuilder seguro(boolean valor) {
        seguro = valor;
        return this;
    }
    public Solicitud build() {
        if (solicitante == null || solicitante.isBlank()) {
            throw new IllegalStateException("El solicitante es obligatorio");
        }
        if (fecha == null || prioridad == null) {
            throw new IllegalStateException("Fecha y prioridad son obligatorias");
        }
        return new Solicitud(solicitante.strip(), fecha, prioridad,
                instrucciones, direccionAlternativa, seguro);
    }
}
