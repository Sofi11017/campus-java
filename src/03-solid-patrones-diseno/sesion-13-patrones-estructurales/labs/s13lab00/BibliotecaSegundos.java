package s13lab00;

public class BibliotecaSegundos {
    private final int segundos;

    public BibliotecaSegundos(int segundos) {
        if (segundos < 0) {
            throw new IllegalArgumentException("Duracion negativa");
        }
        this.segundos = segundos;
    }

    public int obtenerSegundos() {
        return segundos;
    }
}
