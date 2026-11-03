package s14demo02;

public class S14Demo02ChainMain {
    public static void main(String[] args) {
        ManejadorCompra cadena = new Supervisor(new Gerencia(new Direccion(null)));
        long[] montos = {1, 100_000, 100_001, 500_000, 500_001, 1_000_000, 1_000_001};
        for (long monto : montos) {
            System.out.println(monto + ": " + cadena.resolver(new SolicitudCompra(monto)));
        }
    }
}
