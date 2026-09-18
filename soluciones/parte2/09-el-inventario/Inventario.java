import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregar(Producto producto) {
        productos.add(producto);
    }

    public int cantidad() {
        return productos.size();
    }

    public Producto buscarPorSku(String sku) {
        for (Producto producto : productos) {
            if (producto.getSku().equals(sku)) {
                return producto;
            }
        }
        return null;
    }

    public boolean eliminar(String sku) {
        Producto producto = buscarPorSku(sku);
        if (producto == null) {
            return false;
        }
        productos.remove(producto);
        return true;
    }

    public double valorTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
}
