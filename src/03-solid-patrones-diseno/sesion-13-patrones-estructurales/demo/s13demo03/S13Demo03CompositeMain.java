package s13demo03;

public class S13Demo03CompositeMain {
    public static void main(String[] args) {
        ModuloProyectos modulo = new ModuloProyectos();
        Actividad hoja = new ActividadSimple(10_000);

        PaqueteActividades subpaquete = new PaqueteActividades();
        modulo.mostrarCosto(hoja);
        modulo.mostrarCosto(subpaquete);

        subpaquete.agregarActividad(new ActividadSimple(20_000));
        PaqueteActividades proyecto = new PaqueteActividades();
        proyecto.agregarActividad(hoja);
        proyecto.agregarActividad(subpaquete);
        modulo.mostrarCosto(proyecto);

        try {
            subpaquete.agregarActividad(proyecto);
        } catch (IllegalArgumentException error) {
            System.out.println("Ciclo rechazado");
        }
    }
}
