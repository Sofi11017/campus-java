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

        // Comprobaciones adicionales (pasos 4 y 5 de la actividad)
        System.out.println("\n--- Comprobaciones adicionales (pasos 4 y 5) ---");
        taller.disponer("TIJERAS");
        System.out.println("Faltantes tras disponer TIJERAS: " + taller.faltantes());
        System.out.println("Requeridos conservados: " + taller.cantidadRequeridos());
        System.out.println("Disponer null: " + taller.disponer(null));
        System.out.println("Disponer '   ': " + taller.disponer("   "));
        System.out.println("Disponer ' cartulina ' repetida: " + taller.disponer(" cartulina "));
        System.out.println("Disponibles finales: " + taller.cantidadDisponibles());
    }
}

