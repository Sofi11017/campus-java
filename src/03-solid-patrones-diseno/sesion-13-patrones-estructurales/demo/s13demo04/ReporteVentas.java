package s13demo04;

public class ReporteVentas extends Reporte {
    public ReporteVentas(Exportador exportador) {
        super(exportador);
    }

    @Override
    public void generar() {
        exportador.exportar("Ventas: 3 pedidos");
    }
}
