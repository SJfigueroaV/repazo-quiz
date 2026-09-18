import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();

    /** Agrega el producto al final del inventario. */
    public void agregar(Producto producto) {
        // TODO
    }

    /** Cuántos productos hay guardados. */
    public int cantidad() {
        // TODO
        return 0;
    }

    /** El producto con ese SKU, o null si no está. */
    public Producto buscarPorSku(String sku) {
        // TODO
        return null;
    }

    /** Elimina el producto con ese SKU. Devuelve true si lo eliminó. */
    public boolean eliminar(String sku) {
        // TODO
        return false;
    }

    /** Suma de los precios de todos los productos. */
    public double valorTotal() {
        // TODO
        return 0.0;
    }
}
