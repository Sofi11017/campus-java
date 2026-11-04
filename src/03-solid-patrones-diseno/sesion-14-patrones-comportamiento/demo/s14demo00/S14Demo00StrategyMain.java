package s14demo00;

public class S14Demo00StrategyMain {
    public static void main(String[] args) {
        CalculadorEnvio calculador = new CalculadorEnvio(new EnvioLocal());
        System.out.println("Local: " + calculador.calcular(3));
        calculador.cambiarEstrategia(new EnvioExpress());
        System.out.println("Express: " + calculador.calcular(3));
        calculador.cambiarEstrategia(new Recoleccion());
        System.out.println("Recoleccion: " + calculador.calcular(3));
    }
}
