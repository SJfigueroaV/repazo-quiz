import java.util.ArrayList;

public class Pruebas {

    private static ArrayList<Producto> inventario() {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("P01", "Teclado", 150000.0));
        productos.add(new Producto("P02", "Mouse", 85000.0));
        return productos;
    }

    public static void main(String[] args) {
        Producto teclado = new Producto("P01", "Teclado", 150000.0);
        Producto mismoSku = new Producto("P01", "Teclado viejo", 90000.0);
        Producto otroSku = new Producto("P99", "Teclado", 150000.0);

        Prueba.esVerdadero("un producto es igual a sí mismo", () -> teclado.equals(teclado));
        Prueba.esVerdadero("dos productos con el mismo SKU son iguales", () -> teclado.equals(mismoSku));
        Prueba.esFalso("con SKU distinto no son iguales", () -> teclado.equals(otroSku));
        Prueba.esFalso("un producto no es igual a null", () -> teclado.equals(null));
        Prueba.esFalso("un producto no es igual a un String", () -> teclado.equals("P01"));
        Prueba.esVerdadero("equals funciona en los dos sentidos", () -> mismoSku.equals(teclado));

        Prueba.esVerdadero("dos productos iguales tienen el mismo hashCode",
                () -> teclado.hashCode() == mismoSku.hashCode());

        Prueba.esVerdadero("ahora contains encuentra un producto equivalente",
                () -> inventario().contains(new Producto("P02", "otro nombre", 1.0)));
        Prueba.esFalso("y sigue diciendo que no si el SKU no está",
                () -> inventario().contains(new Producto("P99", "Mouse", 85000.0)));
        Prueba.igual("indexOf devuelve la posición del equivalente", 1,
                () -> inventario().indexOf(new Producto("P02", "otro nombre", 1.0)));
        Prueba.igual("remove por contenido ahora funciona", 1, () -> {
            ArrayList<Producto> productos = inventario();
            productos.remove(new Producto("P01", "cualquier nombre", 0.0));
            return productos.size();
        });
        Prueba.resumen();
    }
}
