package s12lab01;
public class FabricaBoreal implements FabricaDocumentos {
    @Override
    public CalculadorImpuesto crearCalculador() {
        return new ImpuestoBoreal();
    }
    @Override
    public FormatoFactura crearFormato() {
        return new FacturaBoreal();
    }
}
