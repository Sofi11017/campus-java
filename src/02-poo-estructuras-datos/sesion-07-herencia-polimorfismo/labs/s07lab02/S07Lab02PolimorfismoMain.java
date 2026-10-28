package s07lab02;

public class S07Lab02PolimorfismoMain {
    public static void mostrarDuracion(ServicioTecnico servicio) {
        // TODO 3
        System.out.println("Duracion: " + servicio.duracionMinutos() + " min");
    }

    public static void main(String[] args) {
        // TODO 4: Reemplazar null por objetos RevisionEquipo e InstalacionPrograma.
        ServicioTecnico revision = new RevisionEquipo();
        ServicioTecnico instalacion = new InstalacionPrograma();
        mostrarDuracion(revision);
        mostrarDuracion(instalacion);
    }
}