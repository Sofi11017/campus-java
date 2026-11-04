package s13demo05;

import java.util.Objects;

public class ModuloFinanciero {
    private final ReporteFinanciero reporte;

    public ModuloFinanciero(ReporteFinanciero reporte) {
        this.reporte = Objects.requireNonNull(reporte);
    }

    public void consultar(Usuario usuario) {
        reporte.consultarReporte(usuario);
    }
}
