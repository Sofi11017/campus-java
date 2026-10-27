package reto03;

/**
 * Gestiona un arreglo de tamaño fijo de 5 días con datos de recolección en gramos (0 a 100000 por día).
 * Los días van de 1 a 5 (índices 0 a 4).
 * No altera ni ordena el arreglo para preservar la correspondencia temporal de los días.
 */
public class HistoricoRecoleccion {
    private final int[] recoleccionDiaria;

    public HistoricoRecoleccion() {
        this.recoleccionDiaria = new int[5];
    }

    public HistoricoRecoleccion(int[] valoresIniciales) {
        this();
        if (valoresIniciales != null && valoresIniciales.length == 5) {
            for (int i = 0; i < 5; i++) {
                if (valoresIniciales[i] >= 0 && valoresIniciales[i] <= 100000) {
                    this.recoleccionDiaria[i] = valoresIniciales[i];
                }
            }
        }
    }

    /**
     * Registra o actualiza el valor de un día (1 a 5).
     * Retorna true si el día y los gramos son válidos, o false si se rechaza sin alterar el arreglo.
     */
    public boolean registrarDia(int dia, int gramos) {
        int indice = dia - 1;
        if (indice < 0 || indice >= recoleccionDiaria.length) {
            return false;
        }
        if (gramos < 0 || gramos > 100000) {
            return false;
        }
        recoleccionDiaria[indice] = gramos;
        return true;
    }

    /**
     * Consulta los gramos de un día específico (1 a 5).
     * Retorna el valor o -1 si la posición está fuera de rango.
     */
    public int consultarDia(int dia) {
        int indice = dia - 1;
        if (indice < 0 || indice >= recoleccionDiaria.length) {
            return -1;
        }
        return recoleccionDiaria[indice];
    }

    /**
     * Calcula la suma total de los 5 días.
     */
    public int calcularTotal() {
        int total = 0;
        for (int i = 0; i < recoleccionDiaria.length; i++) {
            total += recoleccionDiaria[i];
        }
        return total;
    }

    /**
     * Calcula el promedio decimal de los 5 días.
     */
    public double calcularPromedio() {
        if (recoleccionDiaria.length == 0) {
            return 0.0;
        }
        return (double) calcularTotal() / recoleccionDiaria.length;
    }

    /**
     * Encuentra el valor máximo de gramos recolectados en el arreglo.
     */
    public int calcularMaximo() {
        int max = recoleccionDiaria[0];
        for (int i = 1; i < recoleccionDiaria.length; i++) {
            if (recoleccionDiaria[i] > max) {
                max = recoleccionDiaria[i];
            }
        }
        return max;
    }

    /**
     * Retorna el primer día (1 a 5) en el que se alcanzó el valor máximo.
     * En caso de empate, preserva el primer día al usar '>' estricto.
     */
    public int primerDiaMaximo() {
        int max = recoleccionDiaria[0];
        int diaMax = 1;
        for (int i = 1; i < recoleccionDiaria.length; i++) {
            if (recoleccionDiaria[i] > max) {
                max = recoleccionDiaria[i];
                diaMax = i + 1;
            }
        }
        return diaMax;
    }
}
