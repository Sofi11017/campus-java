package s20demo02;

public class Item {
    private final String nombre;
    private final int unidades;

    public Item(String nombre, int unidades) {
        if (nombre == null || nombre.isBlank() || unidades < 0) {
            throw new IllegalArgumentException("Nombre obligatorio y unidades no negativas.");
        }
        this.nombre = nombre.strip();
        this.unidades = unidades;
    }

    public String getNombre() {
        return nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    @Override
    public String toString() {
        return nombre + ":" + unidades;
    }
}
