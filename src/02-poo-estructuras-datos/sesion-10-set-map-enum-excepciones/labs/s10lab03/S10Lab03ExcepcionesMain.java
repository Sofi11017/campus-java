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
    }
}
