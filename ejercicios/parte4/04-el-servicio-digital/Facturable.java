/** Todo lo que se puede cobrar en una factura. */
public interface Facturable {
    /** Texto que describe el ítem en la factura. */
    String getDetalle();

    /** Cuánto se cobra por este ítem. */
    double calcularImporte();
}
