package s16lab00;

public class S16Lab00ReservasMain {
    public static void main(String[] args) throws InterruptedException {
        int cuposIniciales = 20;
        System.out.println("Metodo: " + PruebaReservas.ejecutar(
                new CuposMetodo(cuposIniciales), 4, 10, true));
        System.out.println("Bloque: " + PruebaReservas.ejecutar(
                new CuposBloque(cuposIniciales), 4, 10, true));
    }
}
