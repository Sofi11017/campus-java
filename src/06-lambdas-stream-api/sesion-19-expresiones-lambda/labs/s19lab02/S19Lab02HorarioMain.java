package s19lab02;

import java.util.function.Supplier;

public class S19Lab02HorarioMain {
    public static void main(String[] args) {
        // Interfaz elegida: Supplier<String>
        // Recibe: ningun argumento
        // Devuelve: String con el aviso de horario
        // Metodo que ejecuta la lambda: get()
        Supplier<String> horario = () -> "Horario: 8:00 a 17:00";

        System.out.println(horario.get()); // Primera solicitud
        System.out.println(horario.get()); // Segunda solicitud
        System.out.println(horario.get()); // Tercera solicitud
        // Explicacion: obtener el aviso (get() devuelve el String) es distinto a mostrarlo
        // (System.out.println lo imprime). La lambda entrega el texto y es quien llama
        // quien decide que hacer con el: mostrarlo, guardarlo o combinarlo con otro texto.
    }
}

