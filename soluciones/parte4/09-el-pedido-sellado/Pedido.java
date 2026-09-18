import java.util.List;

public class Pedido {
    private final String codigo;
    private final List<Articulo> articulos;

    public Pedido(String codigo, List<Articulo> articulos) {
        if (articulos == null || articulos.isEmpty()) {
            throw new IllegalArgumentException("Un pedido necesita al menos un artículo");
        }
        this.codigo = codigo;
        // Copia inmutable: los cambios que el llamador haga después en SU lista
        // no llegan aquí, y nadie puede modificar esta.
        this.articulos = List.copyOf(articulos);
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Articulo> getArticulos() {
        // Ya es inmutable, así que se puede entregar tal cual.
        return articulos;
    }

    public double total() {
        double total = 0;
        for (Articulo articulo : articulos) {
            total += articulo.getPrecio();
        }
        return total;
    }
}
