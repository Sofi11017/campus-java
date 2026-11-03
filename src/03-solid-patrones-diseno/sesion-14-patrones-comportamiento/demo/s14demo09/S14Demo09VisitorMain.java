package s14demo09;

public class S14Demo09VisitorMain {
    public static void main(String[] args) {
        Documento[] documentos = {new DocumentoTexto("Hola"), new DocumentoTabla(3)};
        for (Documento documento : documentos) {
            System.out.println(documento.aceptar(new VisitanteResumen()));
            System.out.println(documento.aceptar(new VisitanteValidacion()));
        }
    }
}
