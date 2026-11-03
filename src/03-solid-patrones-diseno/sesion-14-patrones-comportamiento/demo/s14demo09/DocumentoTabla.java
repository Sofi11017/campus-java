package s14demo09;

public final class DocumentoTabla implements Documento {
    private final int filas;

    public DocumentoTabla(int filas) {
        if (filas < 0) {
            throw new IllegalArgumentException("Filas negativas");
        }
        this.filas = filas;
    }

    public int getFilas() {
        return filas;
    }

    @Override
    public String aceptar(VisitanteDocumento visitante) {
        return visitante.visitar(this);
    }
}
