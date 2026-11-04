package s17demo02;

public final class Pedido {
    private final String codigo;
    private final String cliente;
    private final String estado;

    public Pedido(String codigo, String cliente, String estado) {
        if (codigo.isBlank() || cliente.isBlank()
                || !(estado.equals("PENDIENTE") || estado.equals("ENTREGADO"))) {
            throw new IllegalArgumentException("Campos vacios o estado desconocido");
        }
        this.codigo = codigo;
        this.cliente = cliente;
        this.estado = estado;
    }

    public String descripcion() {
        return codigo + " / " + cliente + " / " + estado;
    }
}
