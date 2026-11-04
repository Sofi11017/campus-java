package s13demo01;

public class InventarioService {
    private int disponibles;

    public InventarioService(int disponibles) {
        if (disponibles < 0) {
            throw new IllegalArgumentException("Existencias negativas");
        }
        this.disponibles = disponibles;
    }

    public boolean reservar() {
        if (disponibles == 0) {
            return false;
        }
        disponibles--;
        return true;
    }

    public void liberarReserva() {
        disponibles++;
    }

    public int consultarDisponibles() {
        return disponibles;
    }
}
