package s14demo04;

public class Pedido {
    private EstadoPedido estado = new Creado();

    void cambiarEstado(EstadoPedido estado) {
        this.estado = java.util.Objects.requireNonNull(estado);
    }

    public String consultarEstado() {
        return estado.nombre();
    }

    public boolean pagar() {
        return estado.pagar(this);
    }

    public boolean enviar() {
        return estado.enviar(this);
    }

    public boolean entregar() {
        return estado.entregar(this);
    }
}
