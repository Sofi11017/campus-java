public class S02Lab05MotorPromociones {
    public static void main(String[] args) {
        long subtotalCentavos = 18_500;
        int cantidad = 4;
        boolean esMiembro = true;
        String tipoEntrega = "EXPRESS";

    // TODO 1: Predecir descuento, importe neto, envío y total antes de programar.
        // Predicción:
        // - Subtotal: 18500 centavos, cantidad: 4 unidades -> datos válidos.
        // - Entrega EXPRESS -> costo base: 1200 centavos.
        // - esMiembro=true y subtotal>=10000 -> tasa de descuento = 10%.
        // - Descuento en centavos = 18500 * 10 / 100 = 1850 centavos.
        // - Neto en centavos = 18500 - 1850 = 16650 centavos.
        // - Envío gratis no aplica (solo aplica a ESTANDAR con neto >= 25000) -> Envío = 1200 centavos.
        // - Total = 16650 + 1200 = 17850 centavos.

    // TODO 2: Validar subtotal entre 0 y 1000000 inclusive y cantidad mayor que cero.
        boolean datosValidos = (subtotalCentavos >= 0 && subtotalCentavos <= 1_000_000) && (cantidad > 0);

        if (!datosValidos) {
            System.out.println("Pedido invalido: subtotal o cantidad fuera de rango");
        } else {

    // TODO 3: Rechazar entrega desconocida; no mostrar un desglose válido.
                long envioCentavos = switch (tipoEntrega) {
                case "ESTANDAR" -> 500L;
                case "EXPRESS" -> 1200L;
                case "RECOGIDA" -> 0L;
                default -> -1L;
            };

            if (envioCentavos < 0) {
                System.out.println("Pedido invalido: tipo de entrega desconocido");
            } else {

    // TODO 4: Elegir 10%, 5% o 0% con if/else if/else según las reglas del README.
      int porcentajeDescuento;
      if (esMiembro && subtotalCentavos >= 10000) {
          porcentajeDescuento = 10;
        } else if (!esMiembro && subtotalCentavos >= 20000) {
          porcentajeDescuento = 5;
      } else {
          porcentajeDescuento = 0;
      }

    // TODO 5: Calcular descuento y neto en centavos; truncar fracciones de centavo.
                long descuentoCentavos = subtotalCentavos * porcentajeDescuento / 100;
                long netoCentavos = subtotalCentavos - descuentoCentavos;

    // TODO 6: Elegir costo de envío con switch y aplicar gratuidad solo al ESTANDAR
    // cuando el neto alcanza 25000 centavos.
                if (tipoEntrega.equals("ESTANDAR") && netoCentavos >= 25000) {
                    envioCentavos = 0L;
                }
                long totalCentavos = netoCentavos + envioCentavos;

    // TODO 7: Mostrar el desglose con las etiquetas indicadas en el README.
                System.out.println("Subtotal (centavos): " + subtotalCentavos);
                System.out.println("Descuento (%): " + porcentajeDescuento);
                System.out.println("Descuento (centavos): " + descuentoCentavos);
                System.out.println("Neto (centavos): " + netoCentavos);
                System.out.println("Envio (centavos): " + envioCentavos);
                System.out.println("Total (centavos): " + totalCentavos);


    // TODO 8: Probar los cinco casos mínimos del README; registrar resultados.
                // 1. Caso inicial: 18500, 4, true, "EXPRESS" -> Total: 17850 centavos (Envío 1200)
                // 2. Prueba 2: 26314, 1, false, "ESTANDAR"   -> Descuento: 1315, Neto: 24999, Envío: 500, Total: 25499
                // 3. Prueba 3: 26315, 1, false, "ESTANDAR"   -> Descuento: 1315, Neto: 25000, Envío: 0 (gratis), Total: 25000
                // 4. Prueba inválida: cantidad = 0           -> "Pedido invalido: subtotal o cantidad fuera de rango"
                // 5. Prueba inválida: tipoEntrega = "DRON"   -> "Pedido invalido: tipo de entrega desconocido"

    // TODO 9 (opcional): Inspeccionar con Debug descuentoCentavos, netoCentavos y envioCentavos.
    // En modo Debug se verifica que con 18500 centavos, descuentoCentavos es 1850, netoCentavos es 16650 y envioCentavos es 1200.

    // TODO 10: Mejorar nombres y repetir las pruebas sin alterar las reglas.
    // Justificación:
                // El envío gratis depende del importe neto y no del subtotal porque representa el dinero real que el cliente pagará
                // por los productos adquiridos; otorgar beneficios sobre el subtotal bruto bonificaría dinero no recaudado.

    }
}