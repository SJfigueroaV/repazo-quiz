import java.util.List;

public class Precios {

    public static void aumentar(List<Double> precios, double porcentaje) {
        // Un Double no se puede modificar: hay que poner uno nuevo en la casilla.
        for (int i = 0; i < precios.size(); i++) {
            precios.set(i, precios.get(i) * (1 + porcentaje / 100));
        }
    }
}
