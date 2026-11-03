package s13demo01;

public class S13Demo01FacadeMain {
    public static void main(String[] args) {
        ejecutar(1, true);
        ejecutar(0, true);
        ejecutar(1, false);
    }

    private static void ejecutar(int stock, boolean aprobado) {
        InventarioService inventario = new InventarioService(stock);
        PagoService pago = new PagoService();
        NotificacionService notificacion = new NotificacionService();
        CheckoutFacade facade = new CheckoutFacade(inventario, pago, notificacion);
        ModuloCompras compras = new ModuloCompras(facade);
        System.out.println(compras.comprar(aprobado));
        System.out.println("Stock=" + inventario.consultarDisponibles() + " pagos=" + pago.consultarIntentos() + " avisos=" + notificacion.consultarEnviadas());
    }
}
