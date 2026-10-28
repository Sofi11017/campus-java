package s07lab04;

public class S07Lab04InterfacesMain {
    public static void mostrarExportacion(Exportable formato) {
        // TODO 4
        System.out.println(formato.exportar("Asistencia", 12));
    }

    public static void main(String[] args) {
        // TODO 5
        mostrarExportacion(new ResumenTexto());
        mostrarExportacion(new ResumenCsv());
    }
}