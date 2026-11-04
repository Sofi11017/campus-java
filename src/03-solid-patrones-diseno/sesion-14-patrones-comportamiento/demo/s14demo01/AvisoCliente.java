package s14demo01;

public class AvisoCliente implements ObservadorPedido {
    @Override
    public void actualizar(EventoPedido evento) {
        System.out.println("Aviso: " + evento.getCodigo());
    }
}
