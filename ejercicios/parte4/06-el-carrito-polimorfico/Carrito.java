import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrito {
    private List<Facturable> items = new ArrayList<>();

    /** Agrega el ítem al final. Si recibe null, lo ignora. */
    public void agregar(Facturable item) {
        // TODO
    }

    /** Cuántos ítems tiene el carrito. */
    public int cantidad() {
        // TODO
        return 0;
    }

    /** La suma de los importes de todos los ítems. */
    public double total() {
        // TODO
        return 0;
    }

    /** Los ítems, de solo lectura: desde afuera no se puede meter ni sacar nada. */
    public List<Facturable> getItems() {
        // TODO
        return null;
    }

    /**
     * El ítem con el importe más alto. Si hay empate, el que se agregó primero.
     * Con el carrito vacío devuelve null.
     */
    public Facturable masCaro() {
        // TODO
        return null;
    }
}
