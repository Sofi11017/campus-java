package s12demo00;
public class EnvioUrbano extends CreadorEnvio {
    @Override
    protected Transporte crearTransporte() {
        return new Camion();
    }
}
