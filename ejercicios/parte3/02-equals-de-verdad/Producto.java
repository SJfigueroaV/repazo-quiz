public class Producto {
    private String sku;
    private String nombre;
    private double precio;

    public Producto(String sku, String nombre, double precio) {
        this.sku = sku;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getSku() { return sku; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    /**
     * Dos productos son el mismo si tienen el mismo SKU (el nombre y el precio no importan).
     *
     * Pasos del equals de siempre:
     *   1. si es el mismo objeto (this == obj), true
     *   2. si obj es null, false
     *   3. si no es un Producto (getClass() != obj.getClass()), false
     *   4. convertirlo a Producto y comparar los SKU con equals
     */
    @Override
    public boolean equals(Object obj) {
        // TODO
        return false;
    }

    /** Dos productos iguales deben devolver el mismo hashCode. Usa el del SKU. */
    @Override
    public int hashCode() {
        // TODO
        return 0;
    }

    @Override
    public String toString() {
        return "[" + sku + "] " + nombre;
    }
}
