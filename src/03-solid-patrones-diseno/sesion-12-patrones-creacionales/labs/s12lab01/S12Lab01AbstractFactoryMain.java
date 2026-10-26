package s12lab01;
public class S12Lab01AbstractFactoryMain {
    public static void main(String[] args) {
        System.out.println(new EmisorFactura(new FabricaAlba()).emitir(10000));
        System.out.println(new EmisorFactura(new FabricaBoreal()).emitir(10000));
    }
}
