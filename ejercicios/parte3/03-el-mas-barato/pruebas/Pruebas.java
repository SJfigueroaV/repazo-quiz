import java.util.ArrayList;
import java.util.List;

public class Pruebas {

    private static List<Producto> catalogo() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("P01", "Teclado", 150000.0));
        productos.add(new Producto("P02", "Mouse", 85000.0));
        productos.add(new Producto("P03", "Monitor", 650000.0));
        return productos;
    }

    private static List<Producto> conEmpate() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("P01", "Teclado", 150000.0));
        productos.add(new Producto("P02", "Mouse", 50000.0));
        productos.add(new Producto("P03", "Cable", 50000.0));
        return productos;
    }

    public static void main(String[] args) {
        Prueba.igual("el más barato es el Mouse", "Mouse", () -> Catalogo.masBarato(catalogo()).getNombre());
        Prueba.igual("también lo encuentra si está de primero", "Cable", () -> {
            List<Producto> productos = new ArrayList<>();
            productos.add(new Producto("P01", "Cable", 5000.0));
            productos.add(new Producto("P02", "Monitor", 650000.0));
            return Catalogo.masBarato(productos).getNombre();
        });
        Prueba.igual("con un solo producto devuelve ese", "Único", () -> {
            List<Producto> productos = new ArrayList<>();
            productos.add(new Producto("P01", "Único", 1000.0));
            return Catalogo.masBarato(productos).getNombre();
        });
        Prueba.igual("si hay empate gana el primero de la lista", "Mouse",
                () -> Catalogo.masBarato(conEmpate()).getNombre());
        Prueba.esNulo("con la lista vacía devuelve null y no se cae",
                () -> Catalogo.masBarato(new ArrayList<Producto>()));

        Prueba.igualDecimal("el valor total suma los tres precios", 885000.0, () -> Catalogo.valorTotal(catalogo()));
        Prueba.igualDecimal("un catálogo vacío vale 0.0", 0.0,
                () -> Catalogo.valorTotal(new ArrayList<Producto>()));
        Prueba.resumen();
    }
}
