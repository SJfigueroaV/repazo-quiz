public class ProductoFisico implements Facturable {
    private String descripcion;
    private double precio;
    private double pesoKg;

    public ProductoFisico(String descripcion, double precio, double pesoKg) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.pesoKg = pesoKg;
    }

    @Override
    public String getDetalle() {
        return descripcion + " (" + pesoKg + " kg)";
    }

    @Override
    public double calcularImporte() {
        double envio = pesoKg > 1.0 ? 25000.0 : 10000.0;
        return precio + envio;
    }
}
