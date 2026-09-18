import java.util.ArrayList;

public class Pruebas {

    private static ArrayList<Producto> inventario() {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("P01", "Teclado Mecánico", 150000.0));
        productos.add(new Producto("P02", "Mouse Óptico", 85000.0));
        productos.add(new Producto("P03", "Monitor 24 Pulgadas", 650000.0));
        return productos;
    }

    public static void main(String[] args) {
        Prueba.igual("encuentra el producto P02", "Mouse Óptico",
                () -> Inventario.buscarPorSku(inventario(), "P02").getNombre());
        Prueba.igual("encuentra el último producto de la lista", "Monitor 24 Pulgadas",
                () -> Inventario.buscarPorSku(inventario(), "P03").getNombre());
        Prueba.esNulo("devuelve null si el SKU no existe",
                () -> Inventario.buscarPorSku(inventario(), "P99"));
        Prueba.esNulo("devuelve null si la lista está vacía",
                () -> Inventario.buscarPorSku(new ArrayList<Producto>(), "P01"));
        Prueba.igual("compara el contenido del SKU, no las referencias", "Teclado Mecánico",
                () -> Inventario.buscarPorSku(inventario(), new String("P01")).getNombre());

        Prueba.igual("2 productos cuestan más de 100000", 2,
                () -> Inventario.cuantosCuestanMasDe(inventario(), 100000.0));
        Prueba.igual("ninguno cuesta más de un millón", 0,
                () -> Inventario.cuantosCuestanMasDe(inventario(), 1000000.0));
        Prueba.igual("los tres cuestan más de 1000", 3,
                () -> Inventario.cuantosCuestanMasDe(inventario(), 1000.0));
        Prueba.resumen();
    }
}
