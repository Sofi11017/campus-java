package s12demo00;
public class Camion implements Transporte {
    @Override
    public String entregar() {
        return "Entrega urbana por camion";
    }
}
