package reto03;

import java.util.Locale;

/**
 * Clase principal que ejecuta el Escenario Base Obligatorio y las Pruebas Adicionales
 * requeridas para el Reto 3 · Brigada de reciclaje escolar.
 */
public class S08Reto03Main {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("   RETO 3 · BRIGADA DE RECICLAJE ESCOLAR - ESCENARIO BASE  ");
        System.out.println("==========================================================");

        BrigadaReciclaje brigada = new BrigadaReciclaje();

        // 1. Registro inicial
        EntregaReciclaje entrega1 = new EntregaPapel("R-01", 750);
        EntregaReciclaje entrega2 = new EntregaPlastico("R-02", 450);

        brigada.registrarEntrega(entrega1);
        brigada.registrarEntrega(entrega2);

        System.out.println("\n--- ESTADO ANTES DE RETIRAR ---");
        System.out.println("Entregas: " + brigada.cantidadEntregas());
        System.out.println("Peso total: " + brigada.calcularPesoTotal() + " g");
        System.out.println("Puntos totales: " + brigada.calcularPuntosTotales() +
                " (papel: " + entrega1.calcularPuntos() + ", plastico: " + entrega2.calcularPuntos() + ")");
        System.out.println("Comprobantes vigentes:");
        brigada.listarComprobantes();

        // 2. Retirar R-01 primera vez (debe ser aceptado)
        boolean retiro1 = brigada.retirarEntrega("R-01");
        System.out.println("\n--- RETIRAR R-01 (PRIMERA VEZ) ---");
        System.out.println("Operacion aceptada: " + retiro1);
        System.out.println("Entregas: " + brigada.cantidadEntregas());
        System.out.println("Peso total: " + brigada.calcularPesoTotal() + " g");
        System.out.println("Puntos totales: " + brigada.calcularPuntosTotales());
        System.out.println("Comprobantes vigentes tras retiro:");
        brigada.listarComprobantes();

        // 3. Retirar R-01 segunda vez (debe ser rechazado)
        boolean retiro2 = brigada.retirarEntrega("R-01");
        System.out.println("\n--- RETIRAR R-01 (SEGUNDA VEZ) ---");
        System.out.println("Operacion aceptada: " + retiro2);
        System.out.println("Entregas: " + brigada.cantidadEntregas());
        System.out.println("Peso total: " + brigada.calcularPesoTotal() + " g");
        System.out.println("Puntos totales: " + brigada.calcularPuntosTotales());

        // 4. Evidencias genéricas
        System.out.println("\n--- EVIDENCIAS GENERICAS ---");
        Evidencia<Integer> evidenciaPuntos = new Evidencia<>("Puntos vigentes del escenario", brigada.calcularPuntosTotales());
        Evidencia<String> evidenciaConclusion = new Evidencia<>("Conclusion del reto",
                "Las entregas retiradas se excluyen correctamente de los totales y los puntos se recalculan.");

        evidenciaPuntos.mostrar();
        evidenciaConclusion.mostrar();

        // 5. Arreglo de 5 datos fijos (histórico)
        System.out.println("\n--- ARREGLO DE CINCO DIAS (HISTORICO) ---");
        int[] datosArreglo = {1200, 800, 0, 2000, 1000};
        HistoricoRecoleccion historico = new HistoricoRecoleccion(datosArreglo);

        System.out.println("Total: " + historico.calcularTotal() + " g");
        System.out.println(String.format(Locale.ROOT, "Promedio: %.1f g", historico.calcularPromedio()));
        System.out.println("Maximo: " + historico.calcularMaximo() + " g");
        System.out.println("Dia del maximo: " + historico.primerDiaMaximo());

        System.out.println("\n==========================================================");
        System.out.println("                 PRUEBAS ADICIONALES                       ");
        System.out.println("==========================================================");

        // Prueba A: Pesos límites y fuera de rango
        System.out.println("\n[Prueba A] Limites de peso (99, 100, 10000, 10001):");
        try {
            new EntregaPapel("LIM-01", 99);
            System.out.println("Peso 99: ERROR (no deberia crearse)");
        } catch (IllegalArgumentException e) {
            System.out.println("Peso 99: Rechazado correctamente (" + e.getMessage() + ")");
        }

        try {
            new EntregaPlastico("LIM-02", 10001);
            System.out.println("Peso 10001: ERROR (no deberia crearse)");
        } catch (IllegalArgumentException e) {
            System.out.println("Peso 10001: Rechazado correctamente (" + e.getMessage() + ")");
        }

        EntregaReciclaje papelMin = new EntregaPapel("LIM-03", 100);
        EntregaReciclaje plasticoMin = new EntregaPlastico("LIM-04", 100);
        EntregaReciclaje papelMax = new EntregaPapel("LIM-05", 10000);
        System.out.println("Papel 100 g: Aceptado. Puntos: " + papelMin.calcularPuntos() + " (esperado: 1)");
        System.out.println("Plastico 100 g: Aceptado. Puntos: " + plasticoMin.calcularPuntos() + " (esperado: 2)");
        System.out.println("Papel 10000 g: Aceptado. Puntos: " + papelMax.calcularPuntos() + " (esperado: 100)");

        // Prueba B: ID duplicado normalizado
        System.out.println("\n[Prueba B] Duplicado de ID con normalizacion:");
        BrigadaReciclaje brigadaDup = new BrigadaReciclaje();
        boolean reg1 = brigadaDup.registrarEntrega(new EntregaPapel("dup-01", 300));
        boolean reg2 = brigadaDup.registrarEntrega(new EntregaPlastico("  DUP-01  ", 500));
        System.out.println("Registrar 'dup-01': " + reg1);
        System.out.println("Registrar '  DUP-01  ' (duplicado tras normalizar): " + reg2 + " (esperado: false)");

        // Prueba C: Búsqueda existente e inexistente
        System.out.println("\n[Prueba C] Busqueda de IDs:");
        EntregaReciclaje encontrada = brigadaDup.buscarPorId(" DUP-01 ");
        System.out.println("Buscar ' DUP-01 ': " + (encontrada != null ? encontrada.getId() : "No encontrado"));
        EntregaReciclaje noEncontrada = brigadaDup.buscarPorId("INEXISTENTE");
        System.out.println("Buscar 'INEXISTENTE': " + (noEncontrada != null ? noEncontrada.getId() : "No encontrado"));

        // Prueba D: Lista vacía
        System.out.println("\n[Prueba D] Comportamiento con lista vacia:");
        BrigadaReciclaje brigadaVacia = new BrigadaReciclaje();
        System.out.println("Entregas: " + brigadaVacia.cantidadEntregas());
        System.out.println("Peso total: " + brigadaVacia.calcularPesoTotal());
        System.out.println("Puntos totales: " + brigadaVacia.calcularPuntosTotales());
        brigadaVacia.listarComprobantes();

        // Prueba E: Posición fuera de rango en arreglo
        System.out.println("\n[Prueba E] Rango en arreglo de dias:");
        int consultaInvalida = historico.consultarDia(6);
        System.out.println("Consultar dia 6: " + (consultaInvalida == -1 ? "Rechazado (fuera de rango)" : consultaInvalida));
        boolean actualizaInvalido = historico.registrarDia(0, 500);
        System.out.println("Actualizar dia 0: " + (actualizaInvalido ? "Aceptado" : "Rechazado (fuera de rango)"));
    }
}
