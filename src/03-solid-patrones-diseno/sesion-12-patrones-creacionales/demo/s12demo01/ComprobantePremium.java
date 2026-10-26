package s12demo01;
public class ComprobantePremium implements Comprobante {
    @Override
    public String generar() {
        return "Comprobante PREMIUM";
    }
}
