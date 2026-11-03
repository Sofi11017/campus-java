package s14demo01;

public class S14Demo01ObserverMain {
    public static void main(String[] args) {
        PublicadorPedidos publicador = new PublicadorPedidos();
        AvisoCliente aviso = new AvisoCliente();
        publicador.suscribir(aviso);
        publicador.suscribir(aviso);
        publicador.suscribir(new ObservadorConFallo());
        publicador.suscribir(new InventarioObservador());
        publicador.suscribir(new AnaliticaObservador());
        System.out.println("Entregas: " + publicador.confirmar(new EventoPedido("P1")));
        publicador.retirar(aviso);
        System.out.println("Entregas tras baja: " + publicador.confirmar(new EventoPedido("P2")));
        System.out.println("Sin suscriptores: "
                + new PublicadorPedidos().confirmar(new EventoPedido("P3")));
    }
}
