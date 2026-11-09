package s19demo03;

public class Pedido {
    private final String codigo;
    private final int total;

    public Pedido(String codigo, int total) {
        if (codigo == null || codigo.isBlank() || total < 0) {
            throw new IllegalArgumentException("Codigo obligatorio y total no negativo.");
        }
        this.codigo = codigo.strip();
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return codigo + ":" + total;
    }
}
