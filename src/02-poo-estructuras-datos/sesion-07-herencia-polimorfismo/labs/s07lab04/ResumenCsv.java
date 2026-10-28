package s07lab04;

// TODO 3: Implementar Exportable y completar exportar con @Override.
public class ResumenCsv implements Exportable {
    @Override
    public String exportar(String titulo, int cantidad) {
        return titulo + "," + cantidad;
    }
}