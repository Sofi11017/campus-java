package s14demo04;

public class Pagado implements EstadoPedido {
    @Override
    public String nombre() {
        return "Pagado";
    }

    @Override
    public boolean pagar(Pedido contexto) {
        return false;
    }

    @Override
    public boolean enviar(Pedido contexto) {
        contexto.cambiarEstado(new Enviado());
        return true;
    }

    @Override
    public boolean entregar(Pedido contexto) {
        return false;
    }
}
