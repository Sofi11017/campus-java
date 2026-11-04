package s14demo01;

public class AnaliticaObservador implements ObservadorPedido {
    @Override
    public void actualizar(EventoPedido evento) {
        System.out.println("Analitica: " + evento.getCodigo());
    }
}
