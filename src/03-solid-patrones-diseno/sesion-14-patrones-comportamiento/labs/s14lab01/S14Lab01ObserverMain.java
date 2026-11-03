package s14lab01;

public class S14Lab01ObserverMain {
    public static void main(String[] args) {
        PublicadorCupos curso = new PublicadorCupos();
        Estudiante ana = new Estudiante("Ana");
        Estudiante luis = new Estudiante("Luis");
        curso.suscribir(ana);
        curso.suscribir(luis);
        curso.suscribir(new CanalConFallo());
        curso.suscribir(new Tablero());
        System.out.println("Entregas: " + curso.publicar(new EventoCupo("Java")));
        curso.retirar(luis);
        System.out.println("Tras baja: " + curso.publicar(new EventoCupo("Java")));
        System.out.println("Vacio: " + new PublicadorCupos().publicar(new EventoCupo("Java")));
    }
}
