package s10lab00;

public class S10Lab00SetMain {
    public static void main(String[] args) {
        MaterialesTaller taller = new MaterialesTaller();
        taller.requerir("CARTULINA");
        taller.requerir("PEGAMENTO");
        taller.requerir("TIJERAS");
        taller.disponer("cartulina");
        taller.disponer("REGLA");
        System.out.println("Faltantes: " + taller.faltantes());
        taller.disponer("PEGAMENTO");
        System.out.println("Faltantes despues: " + taller.faltantes());
        System.out.println("Repetir cartulina: " + taller.disponer(" cartulina "));
        System.out.println("Requeridos: " + taller.cantidadRequeridos());
        System.out.println("Disponibles: " + taller.cantidadDisponibles());
    }
}
