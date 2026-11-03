package s14demo08;

public class S14Demo08MementoMain {
    public static void main(String[] args) {
        Cotizacion cotizacion = new Cotizacion();
        HistorialCotizacion historial = new HistorialCotizacion(cotizacion);
        System.out.println("Undo inicial: " + historial.deshacer());
        historial.editar("Version A");
        historial.editar("Version B");
        historial.deshacer();
        System.out.println("Undo 1: " + cotizacion.consultar());
        historial.deshacer();
        System.out.println("Undo 2: " + cotizacion.consultar());
        historial.rehacer();
        System.out.println("Redo: " + cotizacion.consultar());
        historial.editar("Version C");
        System.out.println("Nueva edicion: " + cotizacion.consultar());
        System.out.println("Redo descartado: " + historial.rehacer());
    }
}
