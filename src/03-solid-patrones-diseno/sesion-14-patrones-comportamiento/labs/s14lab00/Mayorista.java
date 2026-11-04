package s14lab00;

public class Mayorista implements Descuento {
    @Override
    public long calcular(long precioUnitario, int unidades) {
        Carrito.validar(precioUnitario, unidades);
        long subtotal = precioUnitario * unidades;
        return unidades >= 10 ? subtotal * 10 / 100 : 0;
    }
}
