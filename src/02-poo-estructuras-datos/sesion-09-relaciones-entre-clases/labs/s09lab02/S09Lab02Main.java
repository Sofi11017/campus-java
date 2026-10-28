package s09lab02;

public class S09Lab02Main {
    public static void main(String[] args) {
        Jugador sara = new Jugador("Sara");
        Jugador leo = new Jugador("Leo");
        Equipo azul = new Equipo("Azul");
        Equipo rojo = new Equipo("Rojo");

        azul.agregar(sara);
        azul.agregar(leo);
        rojo.agregar(sara);
        System.out.println(azul.resumen());
        System.out.println(rojo.resumen());
        System.out.println("Repetir Sara en Azul: " + azul.agregar(sara));
        System.out.println("Retirar Sara de Azul: " + azul.retirar(sara));
        System.out.println(azul.resumen());
        System.out.println(rojo.resumen());
        System.out.println("Jugador original: " + sara.getNombre());
    }
}