public class S06Lab01TermostatoMain {
    public static void main(String[] args) {
        // TODO 5: Crear un termostato y mostrar su temperatura inicial.
        S06Termostato termostato = new S06Termostato();
        System.out.println("Temperatura inicial: " + termostato.getTemperaturaObjetivo());

        // TODO 6: Solicitar 24, 31 y 16; mostrar cada resultado y la temperatura posterior.
        System.out.println("Ajustar 24: " + termostato.ajustarTemperatura(24));
        System.out.println("Temperatura: " + termostato.getTemperaturaObjetivo());
        System.out.println("Ajustar 31: " + termostato.ajustarTemperatura(31));
        System.out.println("Temperatura: " + termostato.getTemperaturaObjetivo());
        System.out.println("Ajustar 16: " + termostato.ajustarTemperatura(16));
        System.out.println("Temperatura: " + termostato.getTemperaturaObjetivo());
    }
}