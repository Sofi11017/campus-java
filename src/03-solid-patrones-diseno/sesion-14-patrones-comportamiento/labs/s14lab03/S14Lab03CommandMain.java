package s14lab03;

public class S14Lab03CommandMain {
    public static void main(String[] args) {
        Libro libro = new Libro();
        GestorBiblioteca gestor = new GestorBiblioteca();
        System.out.println("Renovar sin prestamo: " + gestor.ejecutar(new Renovar(libro)));
        System.out.println("Prestar: " + gestor.ejecutar(new Prestar(libro)));
        System.out.println("Prestar otra vez: " + gestor.ejecutar(new Prestar(libro)));
        System.out.println("Renovar: " + gestor.ejecutar(new Renovar(libro)));
        System.out.println("Devolver: " + gestor.ejecutar(new Devolver(libro)));
        System.out.println("Estado: " + libro.consultar());
        System.out.println("Resultados: " + gestor.consultarResultados());
    }
}
