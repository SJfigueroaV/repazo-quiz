public class Pruebas {

    private static final Facturable HOSTING = new ServicioDigital("Hosting web", 45000.0, 6);          // 270.000
    private static final Facturable ROUTER = new ProductoFisico("Router WiFi", 180000.0, 0.8);        // 190.000
    private static final Facturable IMPRESORA = new ProductoFisico("Impresora láser", 650000.0, 7.5); // 675.000

    private static Carrito carrito() {
        Carrito carrito = new Carrito();
        carrito.agregar(HOSTING);
        carrito.agregar(ROUTER);
        carrito.agregar(IMPRESORA);
        return carrito;
    }

    public static void main(String[] args) {
        Prueba.igual("un carrito nuevo está vacío", 0, () -> new Carrito().cantidad());
        Prueba.igual("con 3 ítems de distintos tipos, la cantidad es 3", 3, () -> carrito().cantidad());
        Prueba.igual("agregar null no cuenta", 3, () -> {
            Carrito carrito = carrito();
            carrito.agregar(null);
            return carrito.cantidad();
        });
        Prueba.igualDecimal("el total suma cada ítem con su propia fórmula", 1135000.0, () -> carrito().total());
        Prueba.igualDecimal("un carrito vacío suma 0", 0.0, () -> new Carrito().total());

        Prueba.igual("getItems devuelve los ítems en orden", "Router WiFi (0.8 kg)",
                () -> carrito().getItems().get(1).getDetalle());
        Prueba.igual("agregar a la lista de getItems NO cambia el carrito", 3, () -> {
            Carrito carrito = carrito();
            try {
                carrito.getItems().add(HOSTING);
            } catch (UnsupportedOperationException e) {
                // bien: es de solo lectura
            }
            return carrito.cantidad();
        });
        Prueba.igual("vaciar la lista de getItems tampoco", 3, () -> {
            Carrito carrito = carrito();
            try {
                carrito.getItems().clear();
            } catch (UnsupportedOperationException e) {
                // bien
            }
            return carrito.cantidad();
        });

        Prueba.igual("masCaro encuentra la impresora", "Impresora láser (7.5 kg)", () -> carrito().masCaro().getDetalle());
        Prueba.igual("masCaro con un solo ítem devuelve ese ítem", "Router WiFi (0.8 kg)", () -> {
            Carrito carrito = new Carrito();
            carrito.agregar(ROUTER);
            return carrito.masCaro().getDetalle();
        });
        Prueba.igual("en un empate gana el que se agregó primero", "Hosting web [6 meses]", () -> {
            Carrito carrito = new Carrito();
            carrito.agregar(ROUTER);
            carrito.agregar(HOSTING);
            carrito.agregar(new ServicioDigital("Otro hosting", 90000.0, 3));   // también 270.000
            return carrito.masCaro().getDetalle();
        });
        Prueba.esNulo("masCaro con el carrito vacío devuelve null", () -> new Carrito().masCaro());
        Prueba.resumen();
    }
}
