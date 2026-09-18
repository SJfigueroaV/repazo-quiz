import java.util.List;

public class Catalogo {

    public static Producto masBarato(List<Producto> productos) {
        if (productos.isEmpty()) {
            return null;
        }
        Producto masBarato = productos.get(0);
        for (Producto producto : productos) {
            // Con < (y no <=) el empate se lo queda el primero
            if (producto.getPrecio() < masBarato.getPrecio()) {
                masBarato = producto;
            }
        }
        return masBarato;
    }

    public static double valorTotal(List<Producto> productos) {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
}
