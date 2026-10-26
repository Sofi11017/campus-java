package s12lab01;
public class EmisorFactura {
    private final FabricaDocumentos fabrica;
    public EmisorFactura(FabricaDocumentos fabrica) {
        if (fabrica == null) {
            throw new IllegalArgumentException("Fabrica obligatoria");
        }
        this.fabrica = fabrica;
    }
    public String emitir(long base) {
        CalculadorImpuesto calculador = fabrica.crearCalculador();
        FormatoFactura formato = fabrica.crearFormato();
        return formato.presentar(base, calculador.calcular(base));
    }
}
