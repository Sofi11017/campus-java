package s14lab00;

public class Fidelizado implements Descuento {
    @Override
    public long calcular(long precioUnitario, int unidades) {
        Carrito.validar(precioUnitario, unidades);
        long subtotal = precioUnitario * unidades;
        return subtotal * 5 / 100;
    }
}
