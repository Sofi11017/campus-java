import java.util.Scanner;


public class S03Reto03Calidad {
    public static void main(String[] args) {

        int cantidadPiezas = 0, inspeccionadas = 0, aprobadas = 0, reprocesadas = 0, rechazadas = 0, rechazadasConsecutivas = 0;
        double medida = 0, sumaMedidas = 0, promedioAprobacion, promedioMedidas, medidaMaxima = 0, medidaMinima = 0;
        String reporte;

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                ================BIENVENIDO==================
                |        AL SISTEMA DE REVISIÓN DE         |
                |             PIEZAS POR LOTES             |
                |------------------------------------------|
                |              A CONTINUACIÓN:             |
                |   Podrás digitar la cantidad de piezas   |
                |     que contiene el lote que quieres     |
                |                 revisar.                 |
                ============================================""");

        do {

            System.out.println("Digite la cantidad de piezas del lote a revisar: ");

            if (!scanner.hasNextInt()) {
                String valorInvalido = scanner.next();
                System.out.println("ERROR: Solo puede digitar números enteros... Intente nuevamente.\n" +
                        "Valor insertado: "+valorInvalido);
                continue;
            }

            cantidadPiezas = scanner.nextInt();

            if (cantidadPiezas <= 0) {
                System.out.println("ERROR: El lote de piezas a revisar no puede ser ni cero ni negativo.");
            }

        }while(cantidadPiezas <= 0);


        reporte = "TAMAÑO DEL LOTE: "+cantidadPiezas+"\n";

        for (int i = 1; i <= cantidadPiezas; i++) {

            boolean piezaAprobada = false, piezaReprocesada = false, datoValido = false;

            do {

                System.out.println("Digite la medida (en milímetros) de la pieza "+i+": ");

                if (!scanner.hasNextDouble()) {
                    String valorInvalido = scanner.next();
                    System.out.println("ERROR: Solo se puede digitar números decimales... Intente nuevamente.\n" +
                            "Valor insertado: "+valorInvalido);
                    continue;
                }

                medida = scanner.nextDouble();

                if (medida <= 0 || !Double.isFinite(medida))  {
                    System.out.println("ERROR: La medida de una pieza debe ser un número positivo y finito.");
                }
                else {
                    datoValido = true;
                }

            }while(!datoValido);


            if (medida >= 9.5 && medida <= 10.5) {

                rechazadasConsecutivas = 0;

                if ((medida < 9.8) || (medida > 10.2)) {
                    System.out.println("""
                            ================AVISO================
                            |  ESTA PIEZA DEBE SER REPROCESADA  |
                            |                                   |
                            |---------------RAZÓN---------------|
                            |    SUS MEDIDAS ESTÁN DENTRO DE    |
                            |       LOS RANGOS REQUERIDOS       |
                            |    (9.5-<9.8) O (>10.2-10.5)MM    |
                            =====================================""");
                    reprocesadas++;
                    piezaReprocesada = true;
                }

                else {
                    System.out.println("""
                            ================AVISO================
                            |      ESTA PIEZA FUE APROBADA      |
                            |                                   |
                            |---------------RAZÓN---------------|
                            |     SUS MEDIDAS ESTÁN DENTRO      |
                            |        DEL RANGO REQUERIDO        |
                            |            (9.8-10.2)MM           |
                            =====================================""");
                    aprobadas++;
                    piezaAprobada = true;
                }

            }
            else {
                System.out.println("""
                            ================AVISO================
                            |      ESTA PIEZA FUE RECHAZADA     |
                            |                                   |
                            |---------------RAZÓN---------------|
                            |  SUS MEDIDAS ESTÁN POR FUERA DEL  |
                            |  RANGO REQUERIDO EN LA REVISIÓN:  |
                            |           (9.5-10.5)MM            |
                            =====================================""");
                rechazadas++;
                rechazadasConsecutivas++;
            }

            System.out.println("VALOR OBTENIDO: "+medida+"\n");

            inspeccionadas++;
            sumaMedidas += medida;

            String fila = piezaAprobada? "Aprobada": piezaReprocesada? "Reprocesada" : "Rechazada";

            reporte = reporte.concat("Pieza "+i+": "+medida+ " | " + fila +"\n");

            if (i == 1) {
                medidaMaxima = medida;
                medidaMinima = medida;
            }
            else {
                if (medida > medidaMaxima) {
                    medidaMaxima = medida;
                }
                if (medida < medidaMinima) {
                    medidaMinima = medida;
                }
            }

            if (rechazadasConsecutivas == 3) {
                System.out.println("""
                            ================ALERTA===============
                            |        DETENER LA LÍNEA DE        |
                            |             PRODUCCIÓN            |
                            |---------------RAZÓN---------------|
                            |       SE LLEGÓ A 3 RECHAZOS       |
                            |            CONSECUTIVOS           |
                            =====================================""");
                break;
            }
        }

        scanner.close();

        promedioAprobacion = (100.0 * aprobadas) / inspeccionadas;
        promedioMedidas = (sumaMedidas / inspeccionadas);

        System.out.println("===============REPORTE FINAL===============\n"+reporte+
                "-------------------------------------------\nPIEZAS APROBADAS: "+aprobadas+"\n" +
                "PIEZAS REPROCESADAS: "+ reprocesadas+"\nPIEZAS RECHAZADAS: "+rechazadas+"\n" +
                "TOTAL DE PIEZAS INSPECCIONADAS: "+inspeccionadas+"\nPROMEDIO DE APROBACIÓN: "+promedioAprobacion+"%\n" +
                "PROMEDIO DE MEDIDAS: "+promedioMedidas+"\n" +
                "--------------------------------------------\n" + "MEDIDA MÁXIMA: "+medidaMaxima+"\n" +
                "MEDIDA MÍNIMA: "+medidaMinima+"\n"+ "============================================");

    }
}