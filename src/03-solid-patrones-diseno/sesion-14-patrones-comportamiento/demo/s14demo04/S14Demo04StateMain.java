package s14demo04;

public class S14Demo04StateMain {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        System.out.println("Inicial: " + pedido.consultarEstado());
        System.out.println("Enviar antes de pagar: " + pedido.enviar());
        System.out.println("Estado: " + pedido.consultarEstado());
        System.out.println("Pagar: " + pedido.pagar());
        System.out.println("Enviar: " + pedido.enviar());
        System.out.println("Entregar: " + pedido.entregar());
        System.out.println("Entregar otra vez: " + pedido.entregar());
        System.out.println("Final: " + pedido.consultarEstado());
    }
}
