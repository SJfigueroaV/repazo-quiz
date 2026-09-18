import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrito {
    private List<Facturable> items = new ArrayList<>();

    public void agregar(Facturable item) {
        if (item != null) {
            items.add(item);
        }
    }

    public int cantidad() {
        return items.size();
    }

    public double total() {
        double total = 0;
        for (Facturable item : items) {
            total += item.calcularImporte();   // cada objeto responde con SU fórmula
        }
        return total;
    }

    public List<Facturable> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Facturable masCaro() {
        Facturable mayor = null;
        for (Facturable item : items) {
            if (mayor == null || item.calcularImporte() > mayor.calcularImporte()) {
                mayor = item;
            }
        }
        return mayor;
    }
}
