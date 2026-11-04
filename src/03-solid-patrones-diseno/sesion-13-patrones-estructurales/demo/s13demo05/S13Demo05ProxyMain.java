package s13demo05;

public class S13Demo05ProxyMain {
    public static void main(String[] args) {
        ReporteFinancieroReal real = new ReporteFinancieroReal();
        ModuloFinanciero modulo = new ModuloFinanciero(
                new ProxyReporteFinanciero(new ServicioAutorizacion(), real));
        modulo.consultar(new Usuario("Ana", true));
        modulo.consultar(new Usuario("Luis", false));
        System.out.println("Consultas reales: " + real.consultarCantidad());
    }
}
