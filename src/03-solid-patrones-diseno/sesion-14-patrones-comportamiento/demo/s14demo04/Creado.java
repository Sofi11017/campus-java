package s14demo04;

public class Creado implements EstadoPedido {
    @Override
    public String nombre() {
        return "Creado";
    }

    @Override
    public boolean pagar(Pedido contexto) {
        contexto.cambiarEstado(new Pagado());
        return true;
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
