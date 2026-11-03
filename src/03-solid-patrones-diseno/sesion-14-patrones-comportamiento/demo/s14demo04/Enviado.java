package s14demo04;

public class Enviado implements EstadoPedido {
    @Override
    public String nombre() {
        return "Enviado";
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
        contexto.cambiarEstado(new Entregado());
        return true;
    }
}
