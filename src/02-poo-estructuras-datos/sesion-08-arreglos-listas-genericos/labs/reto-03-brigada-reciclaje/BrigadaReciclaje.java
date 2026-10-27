package reto03;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Gestor que administra las entregas de reciclaje en una List tipada.
 * Protege sus reglas de negocio: no duplicados, validación de ID,
 * recálculo estricto sobre la lista actual y rechazo de operaciones inválidas.
 */
public class BrigadaReciclaje {
    private final List<EntregaReciclaje> entregas;

    public BrigadaReciclaje() {
        this.entregas = new ArrayList<>();
    }

    /**
     * Registra una nueva entrega si no es nula y su ID normalizado no existe previamente.
     */
    public boolean registrarEntrega(EntregaReciclaje entrega) {
        if (entrega == null) {
            return false;
        }

        String idNormalizado = entrega.getId();
        // Verificamos duplicados con ciclo y equals sin depender de contains sobre objetos
        for (int i = 0; i < entregas.size(); i++) {
            if (entregas.get(i).getId().equals(idNormalizado)) {
                return false; // Rechazado por ID duplicado
            }
        }

        entregas.add(entrega);
        return true;
    }

    /**
     * Busca una entrega por su ID aplicando la normalización strip() y toUpperCase(Locale.ROOT).
     * Si no se encuentra, retorna null.
     */
    public EntregaReciclaje buscarPorId(String id) {
        if (id == null || id.strip().isEmpty()) {
            return null;
        }
        String idNormalizado = id.strip().toUpperCase(Locale.ROOT);
        for (int i = 0; i < entregas.size(); i++) {
            EntregaReciclaje entrega = entregas.get(i);
            if (entrega.getId().equals(idNormalizado)) {
                return entrega;
            }
        }
        return null;
    }

    /**
     * Retira una entrega por su ID normalizado.
     * Retorna true si fue retirada exitosamente, o false si no existía (conservando la lista).
     */
    public boolean retirarEntrega(String id) {
        if (id == null || id.strip().isEmpty()) {
            return false;
        }
        String idNormalizado = id.strip().toUpperCase(Locale.ROOT);
        for (int i = 0; i < entregas.size(); i++) {
            if (entregas.get(i).getId().equals(idNormalizado)) {
                entregas.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna la cantidad de entregas vigentes en la lista.
     */
    public int cantidadEntregas() {
        return entregas.size();
    }

    /**
     * Calcula el peso total en gramos sumando únicamente las entregas de la lista actual.
     */
    public int calcularPesoTotal() {
        int total = 0;
        for (int i = 0; i < entregas.size(); i++) {
            total += entregas.get(i).getPesoGramos();
        }
        return total;
    }

    /**
     * Calcula los puntos totales sumando únicamente las entregas de la lista actual.
     */
    public int calcularPuntosTotales() {
        int total = 0;
        for (int i = 0; i < entregas.size(); i++) {
            total += entregas.get(i).calcularPuntos();
        }
        return total;
    }

    /**
     * Muestra las fichas/comprobantes de las entregas vigentes usando el contrato Comprobable.
     */
    public void listarComprobantes() {
        if (entregas.isEmpty()) {
            System.out.println("Lista vacia. Sin registros.");
            return;
        }
        for (int i = 0; i < entregas.size(); i++) {
            imprimirComprobante(entregas.get(i));
        }
    }

    /**
     * Método cliente que recibe la interfaz Comprobable sin consultar el subtipo concreto.
     */
    public static void imprimirComprobante(Comprobable comprobable) {
        if (comprobable != null) {
            System.out.println(comprobable.generarComprobante());
        }
    }

    /**
     * Retorna una copia defensiva de la lista de entregas para proteger el estado interno.
     */
    public List<EntregaReciclaje> getEntregas() {
        return new ArrayList<>(entregas);
    }
}
