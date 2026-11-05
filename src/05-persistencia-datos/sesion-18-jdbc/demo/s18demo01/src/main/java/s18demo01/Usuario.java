package s18demo01;

public class Usuario {
    private final int id;
    private final String nombre;
    private final String correo;

    public Usuario(int id, String nombre, String correo) {
        if (id < 0) {
            throw new IllegalArgumentException("El id no puede ser negativo.");
        }
        if (correo == null || correo.isBlank() || !correo.contains("@")
                || correo.strip().length() > 150) {
            throw new IllegalArgumentException("Correo obligatorio, con @ y hasta 150 caracteres.");
        }
        this.id = id;
        this.nombre = validarNombre(nombre);
        this.correo = correo.strip();
    }

    public static String validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank() || nombre.strip().length() > 100) {
            throw new IllegalArgumentException("Nombre obligatorio de hasta 100 caracteres.");
        }
        return nombre.strip();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
}
