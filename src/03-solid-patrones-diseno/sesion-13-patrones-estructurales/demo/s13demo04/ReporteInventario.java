package s13demo04;

public class ReporteInventario extends Reporte {
    public ReporteInventario(Exportador exportador) {
        super(exportador);
    }

    @Override
    public void generar() {
        exportador.exportar("Inventario: 8 unidades");
    }
}
