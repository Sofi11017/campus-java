package s14demo06;

import java.util.Iterator;

public class S14Demo06IteratorMain {
    public static void main(String[] args) {
        CatalogoDocumentos catalogo = new CatalogoDocumentos();
        System.out.println("Vacio: " + !catalogo.iterator().hasNext());
        catalogo.agregar("Guia");
        System.out.println("Un elemento: " + catalogo.iterator().next());
        catalogo.agregar("Manual");
        for (String documento : catalogo) {
            System.out.println("for-each: " + documento);
        }
        Iterator<String> iterador = catalogo.iterator();
        while (iterador.hasNext()) {
            System.out.println("Iterator: " + iterador.next());
        }
    }
}
