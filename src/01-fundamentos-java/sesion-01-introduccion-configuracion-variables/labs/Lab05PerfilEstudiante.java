public class Lab05PerfilEstudiante {
    public static void main(String[] args) {
        // TODO 1: Identificar los tipos de nombre, edad, ciudad, promedio y activo.
        // - nombre: String
        // - edad: int
        // - ciudad: String
        // - promedio: double
        // - activo: boolean

        // TODO 2: Declarar e inicializar esos datos con nombres claros.
        String nombre = "Ana";
        int edad = 20;
        String ciudad = "Cucuta";
        double promedio = 4.2;
        boolean activo = true;

        // TODO 3: Declarar final String CURSO con el valor "Java".
        final String CURSO = "Java";

        // TODO 4: Mostrar la ficha inicial con etiquetas legibles.
        System.out.println("=== Perfil del estudiante ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Promedio: " + promedio);
        System.out.println("Activo: " + activo);
        System.out.println("Curso: " + CURSO);

        // TODO 5: Reasignar ciudad para representar un cambio de residencia y mostrar
        // "Ciudad actualizada: " con el nuevo valor, conservando el mismo tipo.
        ciudad = "Bogota";
        System.out.println("Ciudad actualizada: " + ciudad);

        // TODO 6: Probar el perfil A del README; el perfil B es opcional.
        //=== Perfil del estudiante ===
        //Nombre: Ana
        //Edad: 20
        //Ciudad: Cucuta
        //Promedio: 4.2
        //Activo: true
        //Curso: Java
        //Ciudad actualizada: Bogota

        // TODO 7: Colocar un breakpoint antes de la reasignación; observar ciudad,
        // usar Step Over y registrar el valor anterior y el nuevo.
        // Registro de depuración (Debug):
        // - Valor de 'ciudad' antes de la reasignación (en la línea ciudad = "Bogota";): "Cucuta"
        // - Valor de 'ciudad' después de Step Over (ejecutar la línea): "Bogota"

        // TODO 8: Explicar una elección de tipo y qué garantiza final en CURSO.
        // Justificación:
        // - Se eligió 'double' para 'promedio' porque las calificaciones académicas suelen contener cifras decimales (ej. 4.2), lo cual un tipo entero ('int') truncaría perdiendo precisión.
        // - El modificador 'final' en 'CURSO' garantiza que la referencia sea inmutable (una constante); el compilador impedirá cualquier intento de reasignar otro valor a CURSO durante la ejecución.
    }
}
