package s13lab02;

public class S13Lab02DecoratorMain {
    public static void main(String[] args) {
        Empaque base = new EmpaqueEstandar();
        System.out.println("Base: " + base.calcularCosto());
        System.out.println("Ecologico: " + new EmpaqueEcologico(base).calcularCosto());
        System.out.println("Seguro: " + new SeguroEmpaque(base).calcularCosto());
        System.out.println("Ecologico y seguro: "
                + new SeguroEmpaque(new EmpaqueEcologico(base)).calcularCosto());
        System.out.println("Seguro y ecologico: "
                + new EmpaqueEcologico(new SeguroEmpaque(base)).calcularCosto());
    }
}
