package s13demo04;

public class S13Demo04BridgeMain {
    public static void main(String[] args) {
        ModuloReportes modulo = new ModuloReportes();
        Exportador pdf = new ExportadorPDF();
        Exportador excel = new ExportadorExcel();
        modulo.mostrar(new ReporteVentas(pdf));
        modulo.mostrar(new ReporteVentas(excel));
        modulo.mostrar(new ReporteInventario(pdf));
        modulo.mostrar(new ReporteInventario(excel));
    }
}
