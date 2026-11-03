package s14demo09;

public final class DocumentoTexto implements Documento {
    private final String texto;

    public DocumentoTexto(String texto) {
        this.texto = java.util.Objects.requireNonNull(texto);
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String aceptar(VisitanteDocumento visitante) {
        return visitante.visitar(this);
    }
}
