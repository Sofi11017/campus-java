package s19demo01;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class S19Demo01AccionProveedorMain {
    public static void main(String[] args) {
        Supplier<String> mensajeInicial = () -> "Pedido recibido";
        Consumer<String> mostrarAviso = mensaje -> System.out.println("AVISO: " + mensaje);

        System.out.println("1. Comportamientos definidos; todavia no se solicito el mensaje.");
        String mensaje = mensajeInicial.get();
        System.out.println("2. Valor suministrado: " + mensaje);
        mostrarAviso.accept(mensaje);

        System.out.println("3. Solicitar y mostrar otra vez:");
        mostrarAviso.accept(mensajeInicial.get());

        Consumer<String> imprimirLambda = texto -> System.out.println(texto);
        Consumer<String> imprimirReferencia = System.out::println;
        System.out.println("4. Delegacion equivalente:");
        imprimirLambda.accept("Pedido registrado");
        imprimirReferencia.accept("Pedido registrado");
    }
}
