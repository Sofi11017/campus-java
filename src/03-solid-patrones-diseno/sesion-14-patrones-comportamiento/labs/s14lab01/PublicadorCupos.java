package s14lab01;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PublicadorCupos {
    private final List<ObservadorCupo> observadores = new ArrayList<>();

    public void suscribir(ObservadorCupo observador) {
        Objects.requireNonNull(observador);
        for (ObservadorCupo actual : observadores) {
            if (actual == observador) {
                return;
            }
        }
        observadores.add(observador);
    }

    public void retirar(ObservadorCupo observador) {
        for (int indice = 0; indice < observadores.size(); indice++) {
            if (observadores.get(indice) == observador) {
                observadores.remove(indice);
                return;
            }
        }
    }

    public int publicar(EventoCupo evento) {
        Objects.requireNonNull(evento);
        int entregas = 0;
        for (ObservadorCupo observador : new ArrayList<>(observadores)) {
            try {
                observador.actualizar(evento);
                entregas++;
            } catch (FalloAvisoException error) {
                System.out.println("Fallo de entrega: " + error.getMessage());
            }
        }
        return entregas;
    }
}
