package s09lab02;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private final String nombre;
    private final List<Jugador> jugadores = new ArrayList<>();

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public boolean agregar(Jugador jugador) {
        if (jugador == null) {
            return false;
        }
        for (Jugador actual : jugadores) {
            if (actual == jugador) {
                return false;
            }
        }
        jugadores.add(jugador);
        return true;
    }

    public boolean retirar(Jugador jugador) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i) == jugador) {
                jugadores.remove(i);
                return true;
            }
        }
        return false;
    }

    public int cantidad() {
        return jugadores.size();
    }

    public String resumen() {
        String texto = nombre + " (" + cantidad() + "):";
        for (Jugador jugador : jugadores) {
            texto += " " + jugador.getNombre();
        }
        return texto;
    }
}