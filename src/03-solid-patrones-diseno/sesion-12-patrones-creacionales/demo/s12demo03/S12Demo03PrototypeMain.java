package s12demo03;
public class S12Demo03PrototypeMain {
    public static void main(String[] args) {
        Campania plantilla = new Campania("Bienvenida");
        plantilla.agregarEtiqueta("Inicio");
        plantilla.agregarSegmento("Nuevos");
        Campania alias = plantilla;
        Campania copia = plantilla.copiar("Octubre");
        copia.agregarEtiqueta("Oferta");
        copia.agregarSegmento("Frecuentes");
        System.out.println("Alias mismo objeto: " + (alias == plantilla));
        System.out.println("Copia distinta: " + (copia != plantilla));
        System.out.println(plantilla.resumen());
        System.out.println(copia.resumen());
    }
}
