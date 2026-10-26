package s12lab01;
public class FacturaAlba implements FormatoFactura {
    @Override
    public String presentar(long base, long impuesto) {
        return "FACTURA ALBA base=" + base
                + " impuesto=" + impuesto + " total=" + (base + impuesto);
    }
}
