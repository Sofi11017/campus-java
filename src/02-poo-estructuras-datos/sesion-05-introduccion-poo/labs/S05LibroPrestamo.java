public class S05LibroPrestamo {
    // TODO 1: Declarar titulo (String) y prestado (boolean) como campos privados.
    private String titulo;
    private boolean prestado;

    public S05LibroPrestamo(String titulo) {
        // TODO 2: Guardar el titulo y establecer prestado en false.
        this.titulo = titulo;
        this.prestado = false;
    }

    public String obtenerTitulo() {
        // TODO 3: Devolver el titulo del objeto.
        return this.titulo;
    }

    public boolean prestar() {
        // TODO 4: Rechazar un segundo prestamo; si esta disponible, prestarlo.
        if (this.prestado) {
            return false;
        }
        this.prestado = true;
        return true;
    }

    public void devolver() {
        // TODO 5: Marcar el libro como no prestado.
        this.prestado = false;
    }

    public boolean estaPrestado() {
        // TODO 6: Devolver el estado prestado del objeto.
        return this.prestado;
    }
}