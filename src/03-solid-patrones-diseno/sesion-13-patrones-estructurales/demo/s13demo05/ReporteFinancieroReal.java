package s13demo05;

public class ReporteFinancieroReal implements ReporteFinanciero {
    private int consultas;

    @Override
    public void consultarReporte(Usuario usuario) {
        consultas++;
        System.out.println("Reporte ficticio para " + usuario.getNombre());
    }

    public int consultarCantidad() {
        return consultas;
    }
}
