package s12lab04;
public class ProcesoLaboratorio {
    private final ContadorMetricas contador;
    public ProcesoLaboratorio(ContadorMetricas contador) {
        if (contador == null) {
            throw new IllegalArgumentException("Contador obligatorio");
        }
        this.contador = contador;
    }
    public void registrarEventos(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("Cantidad negativa");
        }
        for (int i = 0; i < cantidad; i++) {
            contador.incrementar();
        }
    }
}
