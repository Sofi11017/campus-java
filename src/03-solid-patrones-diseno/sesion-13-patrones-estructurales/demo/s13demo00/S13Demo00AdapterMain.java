package s13demo00;

public class S13Demo00AdapterMain {
    public static void main(String[] args) {
        TarifadorEnvios tarifadorGramos = new AdaptadorProveedorEnvios(new ProveedorLogistico());
        TarifadorEnvios tarifadorkG = new ProveedorLogisticoKg();

        ModuloEnvios adaptado = new ModuloEnvios(tarifadorGramos);
        System.out.println("Tarifa: " + adaptado.consultarTarifa(1) + " pesos");
        System.out.println("Tarifa: " + adaptado.consultarTarifa(2.5) + " pesos");

        ModuloEnvios directo = new ModuloEnvios(tarifadorkG);
        System.out.println("Proveedor kg: " + directo.consultarTarifa(2.5) + " pesos");
        double[] invalidos = {0, -1, Double.NaN, Double.POSITIVE_INFINITY, 0.0005};
        for (double peso : invalidos) {
            try {
                adaptado.consultarTarifa(peso);
            } catch (IllegalArgumentException error) {
                System.out.println("Peso rechazado: " + peso);
            }
        }
    }
}
