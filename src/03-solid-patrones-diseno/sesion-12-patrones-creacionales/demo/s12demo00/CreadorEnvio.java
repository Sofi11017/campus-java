package s12demo00;
public abstract class CreadorEnvio {
    protected abstract Transporte crearTransporte();

    public String procesarEnvio() {
        Transporte transporte = crearTransporte();
        return transporte.entregar();
    }
}
