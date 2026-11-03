package s14demo09;

public class VisitanteValidacion implements VisitanteDocumento {
    @Override
    public String visitar(DocumentoTexto documento) {
        return "Texto valido: " + !documento.getTexto().isBlank();
    }

    @Override
    public String visitar(DocumentoTabla documento) {
        return "Tabla valida: " + (documento.getFilas() > 0);
    }
}
