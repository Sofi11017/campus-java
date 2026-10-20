public class S02Lab02ReglasDeAcceso {
    public static void main(String[] args) {
        int edad = 18;
        boolean esMiembro = false;
        boolean tieneInvitacion = true;
        boolean bloqueado = false;

        // TODO 1: Escribir la regla de acceso en lenguaje natural.
        // Regla de acceso: Una persona puede ingresar al recinto si y solo si es mayor o igual a 18 años,
        // cuenta con membresía activa O posee una invitación válida, y NO se encuentra bloqueada en el sistema.

        // TODO 2: Construir puedeEntrar combinando edad, membresía, invitación y bloqueo.
        boolean puedeEntrar = (edad >= 18) && (esMiembro || tieneInvitacion) && !bloqueado;

        // TODO 3: Mostrar "Acceso permitido" o "Acceso denegado" con if/else.
        if (puedeEntrar) {
            System.out.println("Acceso permitido");
        } else {
            System.out.println("Acceso denegado");
        }

        // TODO 4: Probar los tres casos mínimos del README; las otras combinaciones son opcionales.
        // Caso 1: edad=18, esMiembro=false, tieneInvitacion=true,  bloqueado=false -> Salida: "Acceso permitido"
        // Caso 2: edad=17, esMiembro=false, tieneInvitacion=true,  bloqueado=false -> Salida: "Acceso denegado"
        // Caso 3: edad=18, esMiembro=false, tieneInvitacion=true,  bloqueado=true  -> Salida: "Acceso denegado"

        // TODO 5: Explicar por qué el bloqueo impide siempre el acceso.
        // Explicación:
        // El operador lógico AND (&&) exige que todos sus operandos sean 'true' para que el resultado final sea 'true'.
        // Si 'bloqueado' es 'true', entonces '!bloqueado' evalúa a 'false'. Al haber al menos un 'false' en una cadena de &&,
        // toda la expresión se evalúa inmediatamente a 'false' , denegando el acceso sin importar la edad o invitación.

        // TODO 6 (opcional): Colocar un breakpoint en if y observar puedeEntrar antes de elegir la rama.


    }
}
