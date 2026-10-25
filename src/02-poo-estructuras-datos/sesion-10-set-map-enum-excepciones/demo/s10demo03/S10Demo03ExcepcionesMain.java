package s10demo03;

public class S10Demo03ExcepcionesMain {
    public static String exigirTexto(String texto) throws DatoObligatorioException {
        if (texto == null || texto.isBlank()) {
            throw new DatoObligatorioException("El nombre es obligatorio");
        }
        return texto.strip();
    }

    public static void dividir(String texto, int divisor) {
        try {
            int numero = Integer.parseInt(texto);
            System.out.println("Resultado entero: " + numero / divisor);
        } catch (NumberFormatException error) {
            System.out.println("No es un entero: " + texto);
        } catch (ArithmeticException error) {
            System.out.println("Divisor cero: corrige el divisor");
        } finally {
            // Informa cierre del intento, no que la operación haya sido exitosa.
            System.out.println("Fin del intento");
        }
    }

    public static void main(String[] args) {
        try {
            exigirTexto(" ");
        } catch (DatoObligatorioException error) {
            System.out.println("Dato rechazado: " + error.getMessage());
        }

        try {
            System.out.println("Dato corregido: " + exigirTexto(" Ana "));
        } catch (DatoObligatorioException error) {
            System.out.println("Dato rechazado: " + error.getMessage());
        }
        dividir("12", 3);
        dividir("abc", 3);
        dividir("12", 0);
        dividir("20", 4);
        System.out.println("Division decimal: " + (12.0 / 0.0));
    }
}
