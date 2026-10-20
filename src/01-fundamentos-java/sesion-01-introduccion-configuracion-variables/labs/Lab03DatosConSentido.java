public class Lab03DatosConSentido {
    public static void main(String[] args) {
        // TODO 1: Elegir y justificar los tipos para nombre, edad, temperatura, inicial y activo. Usa String, int, double, char y boolean.
        // Justificación:
        // - String para 'nombre': permite almacenar una secuencia de texto o caracteres alfanuméricos.
        // - int para 'edad': número entero sin parte decimal.
        // - double para 'temperatura': permite almacenar valores numéricos continuos con precisión decimal.
        // - char para 'inicial': almacena exactamente un solo carácter Unicode delimitado por comillas simples.
        // - boolean para 'activo': representa un estado lógico binario (verdadero o falso).

        // TODO 2: Declarar e inicializar las cinco variables con nombres claros (Caso A adaptado).
        String nombre = "Sofia";
        int edad = 17;
        double temperatura = 23.5;
        char inicial = 'S';
        boolean activo = true;

        // TODO 3: Mostrar cada dato en su propia línea, con una etiqueta.
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Inicial: " + inicial);
        System.out.println("Activo: " + activo);

        // TODO 4: Probar el caso A del README; el caso B es opcional.
        // Salida obtenida:
        // Nombre: Sofia
        // Edad: 17
        // Temperatura: 23.5
        // Inicial: S
        // Activo: true

        // TODO 5: Explicar por qué String no es un tipo primitivo.
        // Explicación:
        // String es una clase provista por la biblioteca estándar de Java (java.lang.String) y, por lo tanto,
        // es un tipo de referencia (objeto). A diferencia de los tipos primitivos (como int, double, char o boolean),
        // que guardan directamente su valor binario en la memoria de pila (stack), una variable de tipo String guarda
        // una referencia a un objeto en el heap y dispone de métodos y propiedades (por ejemplo, .length(), .toUpperCase()).
    }
}

