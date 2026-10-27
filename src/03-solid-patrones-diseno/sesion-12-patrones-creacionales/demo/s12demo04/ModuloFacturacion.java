package s12demo04;
public class ModuloFacturacion {
    private final ConfiguracionSistema configuracion;
    public ModuloFacturacion(ConfiguracionSistema configuracion) {
        if (configuracion == null) {
            throw new IllegalArgumentException("Configuracion obligatoria");
        }
        this.configuracion = configuracion;
    }
    public String resumen() {
        return "ModuloFacturacion: " + configuracion.resumen();
    }
}
