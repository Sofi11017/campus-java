package s07demo00.aplicacion;

public class S07Demo00HerenciaMain {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Ana", "Java");
        System.out.println("Nombre heredado mediante consulta: " + estudiante.getNombre());
        estudiante.mostrarFicha();

        estudiante.describirIdentidad();  // No compila desde este Main:
        // es protected de Usuario, y estamos fuera de su paquete y no somos una subclase.
    }
}
