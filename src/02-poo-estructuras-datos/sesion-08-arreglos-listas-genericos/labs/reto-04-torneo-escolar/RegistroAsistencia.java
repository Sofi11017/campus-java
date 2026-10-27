package reto04;

/**
 * Gestiona un arreglo de tamaño fijo de 5 fechas con la asistencia de espectadores (0 a 500 por fecha).
 * Las fechas van de 1 a 5 (índices 0 a 4).
 * No altera ni ordena el arreglo para preservar la correspondencia temporal de las fechas.
 */
public class RegistroAsistencia {
    private final int[] asistenciaFechas;

    public RegistroAsistencia() {
        this.asistenciaFechas = new int[5];
    }

    public RegistroAsistencia(int[] valoresIniciales) {
        this();
        if (valoresIniciales != null && valoresIniciales.length == 5) {
            for (int i = 0; i < 5; i++) {
                if (valoresIniciales[i] >= 0 && valoresIniciales[i] <= 500) {
                    this.asistenciaFechas[i] = valoresIniciales[i];
                }
            }
        }
    }

    /**
     * Registra o actualiza la asistencia de una fecha (1 a 5).
     * Retorna true si es válido o false si se rechaza sin alterar el arreglo.
     */
    public boolean registrarFecha(int fecha, int espectadores) {
        int indice = fecha - 1;
        if (indice < 0 || indice >= asistenciaFechas.length) {
            return false;
        }
        if (espectadores < 0 || espectadores > 500) {
            return false;
        }
        asistenciaFechas[indice] = espectadores;
        return true;
    }

    /**
     * Consulta la asistencia de una fecha específica (1 a 5).
     * Retorna el número de espectadores o -1 si la fecha está fuera de rango.
     */
    public int consultarFecha(int fecha) {
        int indice = fecha - 1;
        if (indice < 0 || indice >= asistenciaFechas.length) {
            return -1;
        }
        return asistenciaFechas[indice];
    }

    /**
     * Calcula la asistencia total acumulada en las 5 fechas.
     */
    public int calcularTotal() {
        int total = 0;
        for (int i = 0; i < asistenciaFechas.length; i++) {
            total += asistenciaFechas[i];
        }
        return total;
    }

    /**
     * Calcula el promedio decimal de asistencia de las 5 fechas.
     */
    public double calcularPromedio() {
        if (asistenciaFechas.length == 0) {
            return 0.0;
        }
        return (double) calcularTotal() / asistenciaFechas.length;
    }

    /**
     * Encuentra la máxima asistencia registrada en alguna fecha.
     */
    public int calcularMaximo() {
        int max = asistenciaFechas[0];
        for (int i = 1; i < asistenciaFechas.length; i++) {
            if (asistenciaFechas[i] > max) {
                max = asistenciaFechas[i];
            }
        }
        return max;
    }

    /**
     * Retorna la primera fecha (1 a 5) en la que se registró la máxima asistencia.
     * En caso de empate, preserva la primera fecha mediante el operador '>' estricto.
     */
    public int primeraFechaMaximo() {
        int max = asistenciaFechas[0];
        int fechaMax = 1;
        for (int i = 1; i < asistenciaFechas.length; i++) {
            if (asistenciaFechas[i] > max) {
                max = asistenciaFechas[i];
                fechaMax = i + 1;
            }
        }
        return fechaMax;
    }
}
