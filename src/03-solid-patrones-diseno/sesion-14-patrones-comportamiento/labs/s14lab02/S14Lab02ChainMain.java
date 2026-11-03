package s14lab02;

public class S14Lab02ChainMain {
    public static void main(String[] args) {
        Soporte cadena = new NivelUno(new Especialista(new Proveedor(null)));
        String[] categorias = {"CONTRASENA", "EQUIPO", "CONEXION", "OTRA"};
        for (String categoria : categorias) {
            System.out.println(categoria + ": " + cadena.resolver(new Ticket(categoria)));
        }
        Soporte invertida = new Especialista(new NivelUno(new Proveedor(null)));
        System.out.println("Invertida CONTRASENA: "
                + invertida.resolver(new Ticket("CONTRASENA")));
    }
}
