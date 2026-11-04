package s13demo01;

public class NotificacionService {
    private int enviadas;

    public void confirmar() {
        enviadas++;
    }

    public int consultarEnviadas() {
        return enviadas;
    }
}
