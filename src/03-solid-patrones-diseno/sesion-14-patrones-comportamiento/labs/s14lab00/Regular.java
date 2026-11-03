package s14lab00;

public class Regular implements Descuento {
    @Override
    public long calcular(long precioUnitario, int unidades) {
        Carrito.validar(precioUnitario, unidades);
        long subtotal = precioUnitario * unidades;
        return 0;
    }
}
