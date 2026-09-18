import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Depuracion {

    public static List<String> depurarInactivas(List<Cuenta> cuentas) {
        List<String> eliminadas = new ArrayList<>();
        Iterator<Cuenta> it = cuentas.iterator();
        while (it.hasNext()) {
            Cuenta cuenta = it.next();
            if (!cuenta.isActiva()) {
                eliminadas.add(cuenta.getCodigo());
                it.remove();
            }
        }
        return eliminadas;
    }
}
