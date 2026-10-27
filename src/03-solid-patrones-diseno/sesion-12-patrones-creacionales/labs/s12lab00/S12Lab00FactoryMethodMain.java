package s12lab00;
public class S12Lab00FactoryMethodMain {
    public static void main(String[] args) {
        GestorPrestamo fisico = new GestorFisico();
        GestorPrestamo digital = new GestorDigital();
        System.out.println(fisico.registrarPrestamo("Java inicial"));
        System.out.println(digital.registrarPrestamo("Java inicial"));
    }
}
