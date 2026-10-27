package s10demo02;

import java.util.Locale;

public class S10Demo02EnumMain {
    public static void mostrarEntrada(String texto) {
        if (texto == null || texto.isBlank()) {
            System.out.println("Dia obligatorio :::");
            return;
        }
        try {
            // Convierte el texto a mayúsculas utilizando reglas independientes de un idioma o país específico, para obtener un comportamiento consistente entre equipos.
            DiaSemana dia = DiaSemana.valueOf(texto.strip().toUpperCase(Locale.ROOT));
            System.out.println("Entrada aceptada: " + dia.name());
        } catch (IllegalArgumentException error) {
            System.out.println("Dia desconocido: " + texto);
        }
    }

    public static void main(String[] args) {
        for (DiaSemana dia : DiaSemana.values()) {
            System.out.println(dia.name() + " laborable=" + dia.esLaborable() + ", Descripción: " + dia.getDescripcion());
        }
        System.out.println("Comparar lunes: " + (DiaSemana.LUNES == DiaSemana.LUNES));
        mostrarEntrada("");
        mostrarEntrada(" lunes ");
        mostrarEntrada("FESTIVO");
    }
}
