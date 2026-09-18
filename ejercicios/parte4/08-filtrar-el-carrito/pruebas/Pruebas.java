import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pruebas {

    private static Carrito carrito() {
        Carrito carrito = new Carrito();
        carrito.agregar(new ServicioDigital("Hosting web", 45000.0, 6));          // 270.000
        carrito.agregar(new ProductoFisico("Mouse", 25000.0, 0.2));               //  35.000
        carrito.agregar(new ProductoFisico("Impresora láser", 650000.0, 7.5));    // 675.000
        carrito.agregar(new ServicioDigital("Dominio", 60000.0, 1));              //  60.000
        return carrito;
    }

    private static List<String> detalles(List<Facturable> items) {
        List<String> detalles = new ArrayList<>();
        for (Facturable f : items) detalles.add(f.getDetalle());
        return detalles;
    }

    public static void main(String[] args) {
        Prueba.igual("itemsDesde(100.000) deja los dos caros, en orden",
                Arrays.asList("Hosting web [6 meses]", "Impresora láser (7.5 kg)"),
                () -> detalles(carrito().itemsDesde(100000.0)));
        Prueba.igual("el mínimo se incluye (>=)",
                Arrays.asList("Hosting web [6 meses]", "Impresora láser (7.5 kg)", "Dominio [1 mes]"),
                () -> detalles(carrito().itemsDesde(60000.0)));
        Prueba.igual("si ninguno llega, devuelve una lista vacía", 0,
                () -> carrito().itemsDesde(1000000.0).size());
        Prueba.igual("itemsDesde no cambia el carrito", 4, () -> {
            Carrito carrito = carrito();
            carrito.itemsDesde(100000.0);
            return carrito.cantidad();
        });
        Prueba.igual("la lista devuelta es tuya: se puede modificar sin tocar el carrito", 4, () -> {
            Carrito carrito = carrito();
            carrito.itemsDesde(0).clear();
            return carrito.cantidad();
        });

        Prueba.igual("quitarMenoresA(100.000) saca 2 ítems", 2, () -> carrito().quitarMenoresA(100000.0));
        Prueba.igual("y en el carrito quedan los caros",
                Arrays.asList("Hosting web [6 meses]", "Impresora láser (7.5 kg)"), () -> {
                    Carrito carrito = carrito();
                    carrito.quitarMenoresA(100000.0);
                    return detalles(carrito.getItems());
                });
        Prueba.igualDecimal("el total baja a 945.000", 945000.0, () -> {
            Carrito carrito = carrito();
            carrito.quitarMenoresA(100000.0);
            return carrito.total();
        });
        Prueba.igual("un ítem que vale justo el mínimo se queda", 0,
                () -> carrito().quitarMenoresA(35000.0));
        Prueba.igual("si no hay nada que quitar devuelve 0", 0,
                () -> carrito().quitarMenoresA(1.0));
        Prueba.igual("con el carrito vacío devuelve 0", 0,
                () -> new Carrito().quitarMenoresA(100000.0));
        Prueba.resumen();
    }
}
