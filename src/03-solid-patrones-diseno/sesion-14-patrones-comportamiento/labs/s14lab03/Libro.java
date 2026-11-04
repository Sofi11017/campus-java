package s14lab03;

public class Libro {
    private boolean prestado;
    private boolean renovado;

    public boolean prestar() {
        if (prestado) {
            return false;
        }
        prestado = true;
        renovado = false;
        return true;
    }

    public boolean renovar() {
        if (!prestado || renovado) {
            return false;
        }
        renovado = true;
        return true;
    }

    public boolean devolver() {
        if (!prestado) {
            return false;
        }
        prestado = false;
        renovado = false;
        return true;
    }

    public String consultar() {
        return "prestado=" + prestado + ", renovado=" + renovado;
    }
}
