package s14demo09;

public class VisitanteResumen implements VisitanteDocumento {
    @Override
    public String visitar(DocumentoTexto documento) {
        return "Texto: " + documento.getTexto().length() + " caracteres";
    }

    @Override
    public String visitar(DocumentoTabla documento) {
        return "Tabla: " + documento.getFilas() + " filas";
    }
}
