package s14demo04;

public class Entregado implements EstadoPedido {
    @Override
    public String nombre() {
        return "Entregado";
    }

    @Override
    public boolean pagar(Pedido contexto) {
        return false;
    }

    @Override
    public boolean enviar(Pedido contexto) {
        return false;
    }

    @Override
    public boolean entregar(Pedido contexto) {
        return false;
    }
}
