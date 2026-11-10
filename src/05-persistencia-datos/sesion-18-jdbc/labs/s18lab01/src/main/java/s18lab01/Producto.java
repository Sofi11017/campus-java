package s18lab01;

public class Producto {
    private final int id;
    private final String nombre;
    private final int stock;

    public Producto(int id, String nombre, int stock) {
        if (id < 0) {
            throw new IllegalArgumentException("El id no puede ser negativo.");
        }
        this.id = id;
        this.nombre = validarNombre(nombre);
        this.stock = validarStock(stock);
    }

    public static String validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank() || nombre.strip().length() > 100) {
            throw new IllegalArgumentException("Nombre obligatorio de hasta 100 caracteres.");
        }
        return nombre.strip();
    }

    public static int validarStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        return stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }
}
