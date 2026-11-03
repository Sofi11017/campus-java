package s13demo06;

public class S13Demo06FlyweightMain {
    public static void main(String[] args) {
        FabricaEmbalajes fabrica = new FabricaEmbalajes();
        Paquete primero = new Paquete("P1", "Ana", 1,
                fabrica.obtenerEmbalaje("Caja", "Carton", "20x20x20"));
        Paquete segundo = new Paquete("P2", "Luis", 2,
                fabrica.obtenerEmbalaje("Caja", "Carton", "20x20x20"));
        Paquete tercero = new Paquete("P3", "Sara", 3,
                fabrica.obtenerEmbalaje("Caja", "Carton", "40x40x40"));
        ModuloLogistica modulo = new ModuloLogistica();
        modulo.registrar(primero);
        modulo.registrar(segundo);
        modulo.registrar(tercero);
        System.out.println(primero.descripcion());
        System.out.println(segundo.descripcion());
        System.out.println("Paquetes distintos: " + (primero != segundo));
        System.out.println("Embalaje compartido: " + (primero.getEmbalaje() == segundo.getEmbalaje()));
        System.out.println("Paquetes: " + modulo.consultarCantidad());
        System.out.println("Tipos retenidos: " + fabrica.consultarCantidadTipos());
    }
}
