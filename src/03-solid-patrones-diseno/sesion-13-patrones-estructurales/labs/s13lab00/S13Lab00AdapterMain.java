package s13lab00;

public class S13Lab00AdapterMain {
    public static void main(String[] args) {
        int[] duracionesSegundos = {0, 2700, 5400};
        for (int segundos : duracionesSegundos) {
            DuracionCita cita = new AdaptadorDuracion(new BibliotecaSegundos(segundos));
            System.out.println(segundos + " s = " + cita.consultarMinutos() + " min");
        }
        try {
            new BibliotecaSegundos(-1);
        } catch (IllegalArgumentException error) {
            System.out.println("Duracion negativa rechazada");
        }
    }
}
