package reto04;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Gestor que administra los equipos del torneo escolar en una List tipada.
 * Permite registrar sin duplicados, registrar resultados, listar fichas mediante
 * el contrato común y determinar al líder polimórficamente sin consultar tipos concretos.
 */
public class TorneoEscolar {
    private final List<Equipo> equipos;

    public TorneoEscolar() {
        this.equipos = new ArrayList<>();
    }

    /**
     * Registra un equipo si no es nulo y su ID normalizado no existe previamente.
     */
    public boolean registrarEquipo(Equipo equipo) {
        if (equipo == null) {
            return false;
        }

        String idNormalizado = equipo.getId();
        // Verificamos duplicados con ciclo y equals
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getId().equals(idNormalizado)) {
                return false; // Rechazado por ID repetido
            }
        }

        equipos.add(equipo);
        return true;
    }

    /**
     * Busca un equipo por su ID normalizado con strip() y toUpperCase(Locale.ROOT).
     * Si no se encuentra, retorna null.
     */
    public Equipo buscarPorId(String id) {
        if (id == null || id.strip().isEmpty()) {
            return null;
        }
        String idNormalizado = id.strip().toUpperCase(Locale.ROOT);
        for (int i = 0; i < equipos.size(); i++) {
            Equipo eq = equipos.get(i);
            if (eq.getId().equals(idNormalizado)) {
                return eq;
            }
        }
        return null;
    }

    /**
     * Registra un resultado ('G', 'E', 'P') para el equipo con el ID dado.
     * Retorna true si fue aceptado, o false si el ID no existe o el resultado es inválido.
     */
    public boolean registrarResultado(String id, String resultado) {
        Equipo equipo = buscarPorId(id);
        if (equipo == null) {
            return false;
        }
        return equipo.registrarResultado(resultado);
    }

    /**
     * Retorna la cantidad total de equipos registrados.
     */
    public int totalEquipos() {
        return equipos.size();
    }

    /**
     * Determina el equipo líder (mayor cantidad de puntos).
     * En caso de empate, preserva al primer equipo registrado gracias al operador '>' estricto.
     * Si la lista está vacía, retorna null.
     */
    public Equipo obtenerLider() {
        if (equipos.isEmpty()) {
            return null;
        }
        Equipo lider = equipos.get(0);
        for (int i = 1; i < equipos.size(); i++) {
            if (equipos.get(i).calcularPuntos() > lider.calcularPuntos()) {
                lider = equipos.get(i);
            }
        }
        return lider;
    }

    /**
     * Retorna una representación textual del líder o "Sin datos" si la lista está vacía.
     */
    public String mostrarLider() {
        Equipo lider = obtenerLider();
        if (lider == null) {
            return "Sin datos";
        }
        return String.format(Locale.ROOT, "Lider: %s (%s) con %d puntos",
                lider.getId(), lider.getNombre(), lider.calcularPuntos());
    }

    /**
     * Muestra las fichas de todos los equipos en orden de registro usando el contrato Reportable.
     */
    public void listarFichas() {
        if (equipos.isEmpty()) {
            System.out.println("Lista vacia. Sin equipos registrados.");
            return;
        }
        for (int i = 0; i < equipos.size(); i++) {
            imprimirFicha(equipos.get(i));
        }
    }

    /**
     * Método cliente que recibe el contrato Reportable sin consultar el subtipo concreto.
     */
    public static void imprimirFicha(Reportable reporte) {
        if (reporte != null) {
            System.out.println(reporte.generarFicha());
        }
    }

    /**
     * Retorna una copia defensiva de la lista interna.
     */
    public List<Equipo> getEquipos() {
        return new ArrayList<>(equipos);
    }
}
