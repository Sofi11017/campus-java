package s10lab03;

public class S10Lab03ExcepcionesMain {
    public static void main(String[] args) {
        RegistroTemperaturas registro = new RegistroTemperaturas();
        String[] entradas = {"20", "abc", " 25 ", "80", "", "-10"};
        for (String entrada : entradas) {
            registro.registrar(entrada);
        }
        System.out.println("Lecturas: " + registro.lecturasComoTexto());
        System.out.println("Aceptadas: " + registro.aceptadas());
        System.out.println("Rechazadas: " + registro.rechazadas());
        System.out.println("Promedio: " + registro.promedioComoTexto());

        // Comprobaciones adicionales (paso 5 de la actividad)
        System.out.println("\n--- Comprobacion paso 5: todas rechazadas ---");
        RegistroTemperaturas regRechazadas = new RegistroTemperaturas();
        String[] entradasRechazadas = {"abc", "", "80"};
        for (String entrada : entradasRechazadas) {
            regRechazadas.registrar(entrada);
        }
        System.out.println("Lecturas: " + regRechazadas.lecturasComoTexto());
        System.out.println("Aceptadas: " + regRechazadas.aceptadas());
        System.out.println("Rechazadas: " + regRechazadas.rechazadas());
        System.out.println("Promedio: " + regRechazadas.promedioComoTexto());

        System.out.println("\n--- Comprobacion paso 5: limites aceptados ---");
        RegistroTemperaturas regValidas = new RegistroTemperaturas();
        String[] entradasValidas = {"-10", "50"};
        for (String entrada : entradasValidas) {
            regValidas.registrar(entrada);
        }
        System.out.println("Lecturas: " + regValidas.lecturasComoTexto());
        System.out.println("Aceptadas: " + regValidas.aceptadas());
        System.out.println("Rechazadas: " + regValidas.rechazadas());
        System.out.println("Promedio: " + regValidas.promedioComoTexto());
    }
}

