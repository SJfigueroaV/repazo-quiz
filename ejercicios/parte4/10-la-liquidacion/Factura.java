import java.util.List;

public class Factura {

    /**
     * Una línea de factura: el detalle alineado a la izquierda en 30 caracteres,
     * " | $", y el importe alineado a la derecha en 14 caracteres, con separador
     * de miles y 2 decimales. El formato es "%-30s | $%,14.2f".
     *
     *   Hosting web [6 meses]          | $    270.000,00
     */
    public static String linea(Facturable item) {
        // TODO
        return "";
    }

    /**
     * La liquidación completa: una línea por ítem, después 48 guiones,
     * y al final la línea del TOTAL con el mismo formato ("TOTAL" en el lugar del detalle).
     * Las líneas se separan con "\n" y no hay "\n" al final.
     *
     *   Hosting web [6 meses]          | $    270.000,00
     *   Router WiFi (0.8 kg)           | $    190.000,00
     *   ------------------------------------------------
     *   TOTAL                          | $    460.000,00
     */
    public static String liquidacion(List<Facturable> items) {
        // TODO
        return "";
    }
}
