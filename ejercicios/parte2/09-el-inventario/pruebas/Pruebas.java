public class Pruebas {

    private static Inventario inventario() {
        Inventario inventario = new Inventario();
        inventario.agregar(new Producto("P01", "Teclado Mecánico", 150000.0));
        inventario.agregar(new Producto("P02", "Mouse Óptico", 85000.0));
        inventario.agregar(new Producto("P03", "Monitor 24 Pulgadas", 650000.0));
        return inventario;
    }

    public static void main(String[] args) {
        Prueba.igual("un inventario nuevo tiene 0 productos", 0, () -> new Inventario().cantidad());
        Prueba.igual("después de agregar 3 productos la cantidad es 3", 3, () -> inventario().cantidad());
        Prueba.igual("no tiene límite de tamaño: caben 500 productos", 500, () -> {
            Inventario inventario = new Inventario();
            for (int i = 1; i <= 500; i++) {
                inventario.agregar(new Producto("P" + i, "Producto " + i, 1000.0));
            }
            return inventario.cantidad();
        });

        Prueba.igual("busca el producto P02", "Mouse Óptico", () -> inventario().buscarPorSku("P02").getNombre());
        Prueba.esNulo("buscar un SKU que no existe devuelve null", () -> inventario().buscarPorSku("P99"));

        Prueba.esVerdadero("eliminar un producto existente devuelve true", () -> inventario().eliminar("P01"));
        Prueba.esFalso("eliminar un SKU que no existe devuelve false", () -> inventario().eliminar("P99"));
        Prueba.igual("al eliminar, la cantidad baja a 2", 2, () -> {
            Inventario inventario = inventario();
            inventario.eliminar("P01");
            return inventario.cantidad();
        });
        Prueba.esNulo("el producto eliminado ya no se encuentra", () -> {
            Inventario inventario = inventario();
            inventario.eliminar("P02");
            return inventario.buscarPorSku("P02");
        });
        Prueba.igual("la lista se compacta sola al eliminar", "Mouse Óptico", () -> {
            Inventario inventario = inventario();
            inventario.eliminar("P01");
            return inventario.buscarPorSku("P02").getNombre();
        });

        Prueba.igualDecimal("el valor total es la suma de los precios", 885000.0, () -> inventario().valorTotal());
        Prueba.igualDecimal("un inventario vacío vale 0.0", 0.0, () -> new Inventario().valorTotal());
        Prueba.igualDecimal("al eliminar un producto baja el valor total", 735000.0, () -> {
            Inventario inventario = inventario();
            inventario.eliminar("P01");
            return inventario.valorTotal();
        });
        Prueba.resumen();
    }
}
