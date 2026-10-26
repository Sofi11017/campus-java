package s12lab01;
public class ImpuestoBoreal implements CalculadorImpuesto {
    @Override
    public long calcular(long base) {
        if (base < 0 || base > 1000000 || base % 100 != 0) {
            throw new IllegalArgumentException("Base fuera del contrato");
        }
        return base * 10 / 100;
    }
}
