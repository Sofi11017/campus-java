public class S02Lab03ClasificaResultados {
    public static void main(String[] args) {
        int nota = 85;

        // TODO 1: Rechazar notas fuera de 0 a 100 antes de clasificarlas.
        // TODO 2: Clasificar con if/else if/else: A desde 90, B desde 80, C desde 70, D desde 60 y E por debajo de 60.
        // TODO 3: Mostrar "Categoria X" o "Nota invalida" según corresponda.
        if (nota < 0 || nota > 100) {
            System.out.println("Nota invalida");
        } else if (nota >= 90) {
            System.out.println("Categoria A");
        } else if (nota >= 80) {
            System.out.println("Categoria B");
        } else if (nota >= 70) {
            System.out.println("Categoria C");
        } else if (nota >= 60) {
            System.out.println("Categoria D");
        } else {
            System.out.println("Categoria E");
        }

        // TODO 4: Probar nota 85, 90 y 101; las demás entradas son opcionales.
        // - nota = 85  -> Categoria B
        // - nota = 90  -> Categoria A
        // - nota = 101 -> Nota invalida

        // TODO 5: Explicar con nota = 95 por qué el orden de las condiciones importa.
        // Explicación:
        // Las estructuras if/else if se evalúan secuencialmente de arriba hacia abajo y ejecutan únicamente la primera rama cuya condición sea verdadera.
        // Si evaluáramos primero 'nota >= 60' antes que 'nota >= 90', una nota de 95 haría verdadera la condición (95 >= 60) y se imprimiría erróneamente 'Categoria D',
        // ignorando por completo la categoría superior 'Categoria A'. Por ello, las escalas deben evaluarse siempre desde el rango más específico y alto hacia el más bajo.

    }
}
