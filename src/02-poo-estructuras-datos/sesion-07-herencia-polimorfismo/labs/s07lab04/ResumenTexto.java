package s07lab04;

// TODO 2: Implementar Exportable y completar exportar con @Override.
public class ResumenTexto implements Exportable {
    @Override
    public String exportar(String titulo, int cantidad) {
        return titulo + ": " + cantidad;
    }
}