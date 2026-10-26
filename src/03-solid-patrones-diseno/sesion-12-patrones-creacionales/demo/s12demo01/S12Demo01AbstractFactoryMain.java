package s12demo01;
public class S12Demo01AbstractFactoryMain {
    public static void main(String[] args) {
        System.out.println(new Atencion(new FabricaBasica()).procesar());
        System.out.println(new Atencion(new FabricaPremium()).procesar());
    }
}
