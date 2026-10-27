package s12demo00;
public class S12Demo00FactoryMethodMain {
    public static void main(String[] args) {
        CreadorEnvio urbano = new EnvioUrbano();
        CreadorEnvio internacional = new EnvioInternacional();
        System.out.println(urbano.procesarEnvio());
        System.out.println(internacional.procesarEnvio());
    }
}
