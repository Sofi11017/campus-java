package s10demo01;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class S10Demo01MapMain {
    public static void main(String[] args) {
        // HashMap, LinkedHashMap y TreeMap, porque los tres implementan la interfaz Map

        Map<String, String> agenda = new HashMap<>();
        System.out.println("Primer put: " + agenda.put("P-02", "Luis"));
        agenda.put("P-01", "Ana");
        agenda.put("P-06", "Javier");
        System.out.println("Valor reemplazado: " + agenda.put("P-01", "Andrea"));
        System.out.println("putIfAbsent devuelve: " + agenda.putIfAbsent("P-01", "Otra"));
        System.out.println("Valor actual P-01: " + agenda.get("P-01"));
        System.out.println("Existe P-99: " + agenda.containsKey("P-99"));
        System.out.println("Existe Javier: " + agenda.containsValue("Javier"));
        System.out.println("Consulta P-99: " + agenda.get("P-99"));
        System.out.println("Cantidad: " + agenda.size());
        agenda.remove("P-06");
        System.out.println("Cantidad: " + agenda.size());
        System.out.println("Vista de Claves: " + agenda.keySet());
        System.out.println("Vista de Values: " + agenda.values());
        System.out.println("Vista de Clave-Valor: " + agenda.entrySet());


        // Se recorre una copia ordenada para un reporte reproducible.
        Map<String, String> ordenada = new TreeMap<>(agenda);
        for (Map.Entry<String, String> entrada : ordenada.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }

        Map<String, String> llegada = new LinkedHashMap<>();
        llegada.put("P-02", "Luis");
        llegada.put("P-01", "Andrea");
        System.out.println("Claves por llegada: " + llegada.keySet());
        // keySet/values/entrySet son vistas; no se entregan como colecciones independientes.
        // En esta agenda no se almacenan valores null.
    }
}
