package s13lab01;

public class S13Lab01FacadeMain {
    public static void main(String[] args) {
        ejecutar(true, true);
        ejecutar(false, true);
        ejecutar(true, false);
    }

    private static void ejecutar(boolean disponible, boolean vigente) {
        Catalogo catalogo = new Catalogo(disponible);
        RegistroPrestamos registro = new RegistroPrestamos();
        EmisorRecibo recibos = new EmisorRecibo();
        PrestamoFacade biblioteca = new PrestamoFacade(catalogo, registro, recibos);
        System.out.println(biblioteca.prestar(new Membresia(vigente)));
        System.out.println("Prestamos=" + registro.consultarCantidad()
                + " recibos=" + recibos.consultarCantidad()
                + " disponible=" + catalogo.estaDisponible());
    }
}
