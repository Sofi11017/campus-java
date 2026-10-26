package s12demo04;
public final class ConfiguracionSistema {
    private static final ConfiguracionSistema INSTANCIA = new ConfiguracionSistema();
    private final String nombreSistema;
    private final String moneda;
    private final int limiteOperaciones;

    private ConfiguracionSistema() {
        nombreSistema = "Campus";
        moneda = "COP";
        limiteOperaciones = 100;
    }
    public static ConfiguracionSistema obtenerInstancia() {
        return INSTANCIA;
    }
    public String resumen() {
        return nombreSistema + " moneda=" + moneda + " limite=" + limiteOperaciones;
    }
}
