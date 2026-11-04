package s14demo05;

public abstract class ProcesoReporte {
    public final void ejecutar() {
        System.out.println("Preparar datos");
        System.out.println("Validar datos");
        generar();
        System.out.println("Entregar reporte simulado");
    }

    protected abstract void generar();
}
