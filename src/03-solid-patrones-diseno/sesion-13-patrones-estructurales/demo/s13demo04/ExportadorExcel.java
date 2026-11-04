package s13demo04;

public class ExportadorExcel implements Exportador {
    @Override
    public void exportar(String contenido) {
        System.out.println("Excel simulado: " + contenido);
    }
}
