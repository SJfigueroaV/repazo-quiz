import java.util.ArrayList;

public class Inventario {

    public static Producto buscarPorSku(ArrayList<Producto> productos, String sku) {
        for (Producto producto : productos) {
            if (producto.getSku().equals(sku)) {
                return producto;
            }
        }
        return null;
    }

    public static int cuantosCuestanMasDe(ArrayList<Producto> productos, double precio) {
        int cuantos = 0;
        for (Producto producto : productos) {
            if (producto.getPrecio() > precio) {
                cuantos++;
            }
        }
        return cuantos;
    }
}
