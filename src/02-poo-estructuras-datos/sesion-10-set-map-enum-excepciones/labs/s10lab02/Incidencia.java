package s10lab02;

public class Incidencia {
    private final Prioridad prioridad;
    private int minutosTranscurridos;

    public Incidencia(Prioridad prioridad) {
        if (prioridad == null) {
            throw new IllegalArgumentException("La prioridad es obligatoria");
        }
        this.prioridad = prioridad;
    }

    public boolean registrarMinutos(int minutos) {
        if (minutos < 0) {
            return false;
        }
        minutosTranscurridos = minutos;
        return true;
    }

    public boolean estaVencida() {
        return minutosTranscurridos > prioridad.getLimiteMinutos();
    }

    public int getMinutosTranscurridos() {
        return minutosTranscurridos;
    }

    public String resumen() {
        return prioridad.name() + " " + minutosTranscurridos
                + " min: vencida=" + estaVencida();
    }
}
