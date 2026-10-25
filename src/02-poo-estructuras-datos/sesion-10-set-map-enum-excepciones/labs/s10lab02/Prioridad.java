package s10lab02;

public enum Prioridad {
    BAJA(120), MEDIA(60), ALTA(15);

    private final int limiteMinutos;

    Prioridad(int limiteMinutos) {
        this.limiteMinutos = limiteMinutos;
    }

    public int getLimiteMinutos() {
        return limiteMinutos;
    }
}
