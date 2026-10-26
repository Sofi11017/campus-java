package s12lab01;
public interface CalculadorImpuesto {
    // Base en pesos enteros: 0..1000000 y múltiplo de 100.
    long calcular(long base);
}
