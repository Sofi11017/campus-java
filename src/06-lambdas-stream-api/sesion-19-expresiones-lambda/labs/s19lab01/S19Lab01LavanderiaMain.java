package s19lab01;

import java.util.function.Consumer;

public class S19Lab01LavanderiaMain {
    public static void main(String[] args) {
        // Interfaz elegida: Consumer<String>
        // Recibe: nombre del cliente (String)
        // Devuelve: void (no devuelve nada, solo realiza una accion)
        // Metodo que ejecuta la lambda: accept(valor)
        Consumer<String> avisar = nombre -> System.out.println("Tu pedido esta listo, " + nombre);

        avisar.accept("Ana");
        avisar.accept("Luis");
        avisar.accept("Sara");
        // Explicacion: imprimir el mensaje no significa devolverlo. println escribe en
        // consola pero no retorna ningun valor al codigo que llamo la lambda. Consumer
        // es el contrato correcto porque la operacion tiene efecto (el aviso) pero no
        // produce un resultado reutilizable.
    }
}

