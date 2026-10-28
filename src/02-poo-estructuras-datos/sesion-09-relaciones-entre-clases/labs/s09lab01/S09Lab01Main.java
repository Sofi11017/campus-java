package s09lab01;

public class S09Lab01Main {
    public static void main(String[] args) {
        Cliente tienda = new Cliente("Tienda Norte");
        Consultor ana = new Consultor("Ana");
        Consultor luis = new Consultor("Luis");

        System.out.println(ana.resumen());
        ana.asignarCliente(tienda);
        luis.asignarCliente(tienda);
        System.out.println(ana.resumen());
        System.out.println(luis.resumen());

        ana.liberarAsignacion();
        System.out.println("Tras liberar a Ana:");
        System.out.println(ana.resumen());
        System.out.println(luis.resumen());
        System.out.println("Cliente original: " + tienda.getNombre());
        System.out.println("Asignar null: " + luis.asignarCliente(null));
        System.out.println(luis.resumen());
    }
}