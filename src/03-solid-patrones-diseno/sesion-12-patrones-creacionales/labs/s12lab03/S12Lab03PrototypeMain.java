package s12lab03;
public class S12Lab03PrototypeMain {
    public static void main(String[] args) {
        Rutina base = new Rutina("Base");
        base.agregar("Sentadillas", 10);
        base.agregar("Flexiones", 8);
        Rutina personal = base.copiar("Personal");
        personal.cambiarRepeticiones(0, 15);
        personal.agregar("Plancha", 1);
        System.out.println("Objetos distintos: " + (base != personal));
        System.out.println(base.resumen());
        System.out.println(personal.resumen());
        System.out.println("Indice invalido: " + personal.cambiarRepeticiones(8, 20));
        System.out.println("Repeticiones cero: " + personal.cambiarRepeticiones(0, 0));
        System.out.println(personal.resumen());
    }
}
