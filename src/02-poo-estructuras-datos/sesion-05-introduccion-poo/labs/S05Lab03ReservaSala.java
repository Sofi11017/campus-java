public class S05Lab03ReservaSala {
    public static void main(String[] args) {
        // TODO 7: Crear reservaAna (2 horas, 15000 pesos/hora) y reservaLuis (1, 20000).
        S05ReservaSala reservaAna = new S05ReservaSala("Ana", 2, 15000L);
        S05ReservaSala reservaLuis = new S05ReservaSala("Luis", 1, 20000L);

        // TODO 8: Mostrar los resultados de extender la reserva de Ana en 1, 6 y 0 horas.
        System.out.println("Ampliar 1 hora: " + reservaAna.extender(1));
        System.out.println("Ampliar 6 horas: " + reservaAna.extender(6));
        System.out.println("Ampliar 0 horas: " + reservaAna.extender(0));

        // TODO 9: Mostrar cliente, horas y costo final de ambas reservas.
        System.out.println("Cliente: " + reservaAna.obtenerCliente());
        System.out.println("Horas: " + reservaAna.obtenerHoras());
        System.out.println("Costo (pesos): " + reservaAna.calcularCosto());
        System.out.println("Cliente: " + reservaLuis.obtenerCliente());
        System.out.println("Horas: " + reservaLuis.obtenerHoras());
        System.out.println("Costo (pesos): " + reservaLuis.calcularCosto());
    }
}