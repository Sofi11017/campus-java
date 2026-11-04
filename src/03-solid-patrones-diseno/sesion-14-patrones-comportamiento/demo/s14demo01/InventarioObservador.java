package s14demo01;

public class InventarioObservador implements ObservadorPedido {
    @Override
    public void actualizar(EventoPedido evento) {
        System.out.println("Inventario simulado: " + evento.getCodigo());
    }
}
