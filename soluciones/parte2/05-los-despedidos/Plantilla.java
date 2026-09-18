import java.util.ArrayList;

public class Plantilla {

    public static void eliminarDespedidos(ArrayList<Empleado> plantilla) {
        // Solución 1: for hacia atrás
        for (int i = plantilla.size() - 1; i >= 0; i--) {
            if (plantilla.get(i).isDespedido()) {
                plantilla.remove(i);
            }
        }

        // Solución 2 (una línea, Java 8+):
        // plantilla.removeIf(empleado -> empleado.isDespedido());
    }
}
