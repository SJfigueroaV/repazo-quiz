import java.util.List;

/**
 * Un pedido ya confirmado: una vez creado, sus artículos no cambian nunca.
 *
 * Así como está, el pedido tiene DOS fugas. Arréglalas:
 *   1. En el constructor: si quien creó el pedido modifica después su lista,
 *      el pedido no debe enterarse.
 *   2. En getArticulos: quien reciba la lista no debe poder meter ni sacar artículos.
 *
 * Además, el constructor debe lanzar IllegalArgumentException si la lista
 * es null o está vacía: no existen pedidos sin artículos.
 */
public class Pedido {
    private final String codigo;
    private final List<Articulo> articulos;

    public Pedido(String codigo, List<Articulo> articulos) {
        // TODO: validar y hacer una copia defensiva
        this.codigo = codigo;
        this.articulos = articulos;
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Articulo> getArticulos() {
        // TODO: que no se pueda modificar desde afuera
        return articulos;
    }

    /** La suma de los precios de los artículos. */
    public double total() {
        // TODO
        return 0;
    }
}
