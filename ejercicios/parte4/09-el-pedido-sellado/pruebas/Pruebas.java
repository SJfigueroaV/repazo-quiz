import java.util.ArrayList;
import java.util.List;

public class Pruebas {

    private static List<Articulo> articulos() {
        List<Articulo> lista = new ArrayList<>();
        lista.add(new Articulo("ART-01", "Teclado USB", 45000.0));
        lista.add(new Articulo("ART-02", "Mouse óptico", 25000.0));
        return lista;
    }

    public static void main(String[] args) {
        Prueba.igual("guarda el código", "PED-7", () -> new Pedido("PED-7", articulos()).getCodigo());
        Prueba.igual("guarda los 2 artículos", 2, () -> new Pedido("PED-7", articulos()).getArticulos().size());
        Prueba.igualDecimal("el total suma los precios", 70000.0, () -> new Pedido("PED-7", articulos()).total());

        Prueba.igual("agregar a la lista ORIGINAL después de crear el pedido no lo cambia", 2, () -> {
            List<Articulo> lista = articulos();
            Pedido pedido = new Pedido("PED-7", lista);
            lista.add(new Articulo("ART-99", "Colado", 1000000.0));
            return pedido.getArticulos().size();
        });
        Prueba.igualDecimal("ni cambia su total", 70000.0, () -> {
            List<Articulo> lista = articulos();
            Pedido pedido = new Pedido("PED-7", lista);
            lista.add(new Articulo("ART-99", "Colado", 1000000.0));
            return pedido.total();
        });
        Prueba.igual("vaciar la lista original tampoco", 2, () -> {
            List<Articulo> lista = articulos();
            Pedido pedido = new Pedido("PED-7", lista);
            lista.clear();
            return pedido.getArticulos().size();
        });

        Prueba.igual("agregar a la lista de getArticulos no cambia el pedido", 2, () -> {
            Pedido pedido = new Pedido("PED-7", articulos());
            try {
                pedido.getArticulos().add(new Articulo("ART-99", "Colado", 1.0));
            } catch (UnsupportedOperationException e) {
                // bien
            }
            return pedido.getArticulos().size();
        });
        Prueba.igual("quitar de la lista de getArticulos tampoco", 2, () -> {
            Pedido pedido = new Pedido("PED-7", articulos());
            try {
                pedido.getArticulos().remove(0);
            } catch (UnsupportedOperationException e) {
                // bien
            }
            return pedido.getArticulos().size();
        });

        Prueba.lanza("un pedido con la lista null lanza IllegalArgumentException",
                IllegalArgumentException.class, () -> new Pedido("PED-8", null));
        Prueba.lanza("un pedido sin artículos lanza IllegalArgumentException",
                IllegalArgumentException.class, () -> new Pedido("PED-8", new ArrayList<>()));
        Prueba.resumen();
    }
}
