package s12lab01;
public class FacturaBoreal implements FormatoFactura {
    @Override
    public String presentar(long base, long impuesto) {
        return "FACTURA BOREAL base=" + base
                + " impuesto=" + impuesto + " total=" + (base + impuesto);
    }
}
