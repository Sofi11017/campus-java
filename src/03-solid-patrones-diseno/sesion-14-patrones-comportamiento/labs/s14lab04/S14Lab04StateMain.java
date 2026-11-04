package s14lab04;

public class S14Lab04StateMain {
    public static void main(String[] args) {
        Reserva reserva = new Reserva();
        System.out.println("Inicial: " + reserva.consultarEstado());
        System.out.println("Ocupar antes de confirmar: " + reserva.ocupar());
        System.out.println("Estado: " + reserva.consultarEstado());
        System.out.println("Confirmar: " + reserva.confirmar());
        System.out.println("Cerrar sin ocupar: " + reserva.cerrar());
        System.out.println("Estado: " + reserva.consultarEstado());
        System.out.println("Ocupar: " + reserva.ocupar());
        System.out.println("Cerrar: " + reserva.cerrar());
        System.out.println("Cerrar otra vez: " + reserva.cerrar());
        System.out.println("Final: " + reserva.consultarEstado());
    }
}
