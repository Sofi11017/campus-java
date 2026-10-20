public class S02Lab04EligeLaEntrega {
    public static void main(String[] args) {
        String tipoEntrega = "EXPRESS";

        // TODO 1: Resolver ESTANDAR=500, EXPRESS=1200 y RECOGIDA=0 centavos con switch.
        // TODO 2: Manejar default como opción inválida; no mostrar un costo válido.
        long costoCentavos = switch (tipoEntrega) {
            case "ESTANDAR" -> 500;
            case "EXPRESS" -> 1200;
            case "RECOGIDA" -> 0;
            default -> -1;
        };

        // TODO 3: En opciones válidas mostrar "Costo (centavos): " con el valor.
        // TODO 4: Usar un ternario para elegir "Retiro en tienda" o "Entrega a domicilio".
        // TODO 5: Mostrar la etiqueta con "Etiqueta: "; para invalidos mostrar solo
        // "Tipo de entrega invalido".
        if (costoCentavos < 0) {
            System.out.println("Tipo de entrega invalido");
        } else {
            System.out.println("Costo (centavos): " + costoCentavos);
            String etiqueta = "RECOGIDA".equals(tipoEntrega) ? "Retiro en tienda" : "Entrega a domicilio";
            System.out.println("Etiqueta: " + etiqueta);
        }

        // TODO 6: Probar los tres tipos y DRON; opcionalmente comparar switch clásico y moderno
        // en tu copia personal. Entregar una versión y explicar break y las flechas.
        // Pruebas:
        // - "ESTANDAR" -> Costo (centavos): 500  | Etiqueta: Entrega a domicilio
        // - "EXPRESS"  -> Costo (centavos): 1200 | Etiqueta: Entrega a domicilio
        // - "RECOGIDA" -> Costo (centavos): 0    | Etiqueta: Retiro en tienda
        // - "DRON"     -> Tipo de entrega invalido
        //
        // Explicación de break vs flechas (->):
        // - En el switch clásico se usa 'break' para no seguir ejecutando los casos de abajo.
        // - Con flechas ('->') no se necesita 'break' porque solo ejecuta esa opción y devuelve el valor directamente.

    }
}
