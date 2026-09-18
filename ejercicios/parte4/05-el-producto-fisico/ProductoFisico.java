public class ProductoFisico implements Facturable {
    private String descripcion;
    private double precio;
    private double pesoKg;

    public ProductoFisico(String descripcion, double precio, double pesoKg) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.pesoKg = pesoKg;
    }

    /** La descripción y el peso entre paréntesis: "Router WiFi (0.8 kg)". */
    @Override
    public String getDetalle() {
        // TODO
        return "";
    }

    /**
     * El precio más el envío. El envío cuesta 25000.0 si el producto pesa
     * MÁS de 1 kg, y 10000.0 si pesa 1 kg o menos.
     */
    @Override
    public double calcularImporte() {
        // TODO
        return 0;
    }
}
