package s12lab01;
public class FabricaAlba implements FabricaDocumentos {
    @Override
    public CalculadorImpuesto crearCalculador() {
        return new ImpuestoAlba();
    }
    @Override
    public FormatoFactura crearFormato() {
        return new FacturaAlba();
    }
}
