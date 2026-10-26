package s12lab02;
import java.time.LocalDate;

public class S12Lab02BuilderMain {
    public static void main(String[] args) {
        ReservaBuilder builder = new ReservaBuilder().huesped("Ana")
                .fecha(LocalDate.of(2026, 2, 10)).desayuno(true).estacionamiento(true);
        Reserva primera = builder.build();
        Reserva segunda = builder.lateCheckout(true).build();
        System.out.println(primera.resumen());
        System.out.println(segunda.resumen());
        System.out.println("Primera conserva lateCheckout: " + primera.tieneLateCheckout());
        System.out.println("Objetos distintos: " + (primera != segunda));
        try {
            new ReservaBuilder().fecha(LocalDate.of(2026, 2, 10)).build();
        } catch (IllegalStateException error) {
            System.out.println("Reserva rechazada: " + error.getMessage());
        }
    }
}
