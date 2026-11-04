package s14lab01;

public class Tablero implements ObservadorCupo {
    @Override
    public void actualizar(EventoCupo evento) {
        System.out.println("Tablero: cupo en " + evento.getCurso());
    }
}
