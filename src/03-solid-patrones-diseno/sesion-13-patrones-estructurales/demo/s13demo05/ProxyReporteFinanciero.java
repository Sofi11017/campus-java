package s13demo05;

import java.util.Objects;

public class ProxyReporteFinanciero implements ReporteFinanciero {
    private final ServicioAutorizacion autorizacion;
    private final ReporteFinanciero reporteReal;

    public ProxyReporteFinanciero(ServicioAutorizacion autorizacion,
                                 ReporteFinanciero reporteReal) {
        this.autorizacion = Objects.requireNonNull(autorizacion);
        this.reporteReal = Objects.requireNonNull(reporteReal);
    }

    @Override
    public void consultarReporte(Usuario usuario) {
        if (!autorizacion.tienePermiso(usuario)) {
            System.out.println("Acceso denegado");
            return;
        }
        reporteReal.consultarReporte(usuario);
    }
}
