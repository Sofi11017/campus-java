package s07lab01;

public class Tramite {
    // TODO 1: Hacer privado el campo codigo sin cambiar su nombre ni tipo.
    private final String codigo;

    public Tramite(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String descripcion() {
        return "Tramite: " + codigo;
    }

    public String verificar(Validador validador) {
        // TODO 2: Devolver el resultado de revisar() del validador recibido.
        return validador.revisar();
    }
}