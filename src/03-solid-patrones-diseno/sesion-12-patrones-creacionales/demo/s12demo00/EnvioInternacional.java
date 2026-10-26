package s12demo00;
public class EnvioInternacional extends CreadorEnvio {
    @Override
    protected Transporte crearTransporte() {
        return new Avion();
    }
}
