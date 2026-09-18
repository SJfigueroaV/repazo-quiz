import java.util.List;

public class Cartera {

    public static boolean subirCupo(List<Cliente> cartera, String cedula, double nuevoCupo) {
        for (Cliente cliente : cartera) {
            if (cliente.getCedula().equals(cedula)) {
                // cliente apunta al mismo objeto que está en la lista:
                // cambiarlo aquí es cambiarlo allá. No hace falta set().
                cliente.setCupo(nuevoCupo);
                return true;
            }
        }
        return false;
    }
}
