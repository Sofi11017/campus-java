package s13demo04;

public class ExportadorPDF implements Exportador {
    @Override
    public void exportar(String contenido) {
        System.out.println("PDF simulado: " + contenido);
    }
}
