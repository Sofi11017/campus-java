package s14demo04;

public interface EstadoPedido {
    String nombre();
    boolean pagar(Pedido contexto);
    boolean enviar(Pedido contexto);
    boolean entregar(Pedido contexto);
}
