package s13lab01;

public class Catalogo {
    private boolean disponible;

    public Catalogo(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean reservar() {
        if (!disponible) {
            return false;
        }
        disponible = false;
        return true;
    }

    public boolean estaDisponible() {
        return disponible;
    }
}
