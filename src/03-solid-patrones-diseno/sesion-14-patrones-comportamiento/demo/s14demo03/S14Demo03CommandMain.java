package s14demo03;

public class S14Demo03CommandMain {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        GestorComandos gestor = new GestorComandos();
        System.out.println("Entrada: " + gestor.ejecutar(new EntradaInventario(inventario, 10)));
        System.out.println("Salida: " + gestor.ejecutar(new SalidaInventario(inventario, 4)));
        System.out.println("Salida excesiva: " + gestor.ejecutar(new SalidaInventario(inventario, 9)));
        System.out.println("Stock: " + inventario.consultar());
        System.out.println("Resultados: " + gestor.consultarResultados());
    }
}
