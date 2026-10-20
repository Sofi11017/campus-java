public class Lab04DiagnosticaYCorrige {
    public static void main(String[] args) {
        // En tu copia personal, activa un caso por vez, lee el error y repáralo.
        // Los casos están comentados para que esta plantilla pueda compilar.

        // Caso 1: String nombre = 'Ana';
        // TODO 1: Corregir las comillas, mostrar el nombre y explicar la causa.
        // Causa del error: Las comillas simples (' ') están reservadas exclusivamente para tipos 'char' de un solo carácter. Las cadenas de texto (String) requieren comillas dobles (" ").
        String nombre = "Sofia";
        System.out.println("Nombre: " + nombre);

        // Caso 2: int temperatura = 23.5;
        // TODO 2: Conservar el valor decimal usando un tipo adecuado y mostrarlo.
        // Causa del error: 'int' almacena números enteros; asignar 23.5 genera un error de tipos incompatibles . Se corrige cambiando el tipo a 'double'.
        double temperatura = 23.5;
        System.out.println("Temperatura: " + temperatura);

        // Caso 3:
        // int edad;
        // System.out.println(edad);
        // TODO 3: Inicializar edad antes de mostrarla y explicar por qué es necesario.
        // Causa del error: En Java, las variables locales declaradas dentro de un método no reciben valores por defecto y deben inicializarse con un valor antes de ser leídas.
        int edad = 17;
        System.out.println("Edad: " + edad);

        // Caso 4:
        // final String CURSO = "Java";
        // CURSO = "Python";
        // TODO 4: Conservar CURSO como final y mostrar "Java", sin reasignarlo.
        // Causa del error: La palabra reservada 'final' convierte la variable en una constante inmutable, impidiendo cualquier reasignación posterior. Se elimina la reasignación.
        final String CURSO = "Java";
        System.out.println("Curso: " + CURSO);

        // TODO 5: Registrar los cuatro mensajes del compilador en tu README personal,
        // junto con la causa y la corrección aplicada a cada caso.
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Caso 1:
        //   - Mensaje del compilador: unclosed character literal / incompatible types: char cannot be converted to java.lang.String
        //   - Causa: Se usaron comillas simples en lugar de dobles para una cadena de texto.
        //   - Corrección: Cambiar 'Sofia' por "Sofia".
        // Caso 2:
        //   - Mensaje del compilador: incompatible types: possible lossy conversion from double to int
        //   - Causa: Se intentó guardar un número con decimales (double) en una variable de tipo entero (int).
        //   - Corrección: Cambiar el tipo de dato de int a double.
        // Caso 3:
        //   - Mensaje del compilador: variable edad might not have been initialized
        //   - Causa: Las variables locales deben tener un valor asignado antes de ser utilizadas.
        //   - Corrección: Inicializar la variable: int edad = 20;
        // Caso 4:
        //   - Mensaje del compilador: cannot assign a value to final variable CURSO
        //   - Causa: Se intentó modificar el valor de una constante declarada con el modificador 'final'.
        //   - Corrección: Eliminar la instrucción de reasignación (CURSO = "Python";).
        // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    }
}
