package s14demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PublicadorPedidos {
    private final List<ObservadorPedido> observadores = new ArrayList<>();

    public void suscribir(ObservadorPedido observador) {
        Objects.requireNonNull(observador);
        for (ObservadorPedido actual : observadores) {
            if (actual == observador) {
                return;
            }
        }
        observadores.add(observador);
    }

    public void retirar(ObservadorPedido observador) {
        for (int indice = 0; indice < observadores.size(); indice++) {
            if (observadores.get(indice) == observador) {
                observadores.remove(indice);
                return;
            }
        }
    }

    public int confirmar(EventoPedido evento) {
        Objects.requireNonNull(evento);
        int entregas = 0;
        for (ObservadorPedido observador : new ArrayList<>(observadores)) {
            try {
                observador.actualizar(evento);
                entregas++;
            } catch (FalloNotificacionException error) {
                System.out.println("Fallo de entrega: " + error.getMessage());
            }
        }
        return entregas;
    }
}
