package s12demo04;
public class S12Demo04SingletonMain {
    public static void main(String[] args) {
        ConfiguracionSistema primera = ConfiguracionSistema.obtenerInstancia();
        ConfiguracionSistema segunda = ConfiguracionSistema.obtenerInstancia();
        System.out.println("Misma instancia: " + (primera == segunda));
        System.out.println(new ModuloVentas(primera).resumen());
        System.out.println(new ModuloFacturacion(segunda).resumen());
    }
}
