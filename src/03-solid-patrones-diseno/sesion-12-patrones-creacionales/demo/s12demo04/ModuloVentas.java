package s12demo04;
public class ModuloVentas {
    private final ConfiguracionSistema configuracion;
    public ModuloVentas(ConfiguracionSistema configuracion) {
        if (configuracion == null) {
            throw new IllegalArgumentException("Configuracion obligatoria");
        }
        this.configuracion = configuracion;
    }
    public String resumen() {
        return "ModuloVentas: " + configuracion.resumen();
    }
}
