package s14lab01;

public class CanalConFallo implements ObservadorCupo {
    @Override
    public void actualizar(EventoCupo evento) {
        throw new FalloAvisoException("Canal temporalmente no disponible");
    }
}
