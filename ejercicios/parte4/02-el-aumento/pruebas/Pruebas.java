import java.util.ArrayList;
import java.util.List;

public class Pruebas {

    private static List<Double> precios() {
        List<Double> precios = new ArrayList<>();
        precios.add(100.0);
        precios.add(250.0);
        precios.add(80.0);
        return precios;
    }

    public static void main(String[] args) {
        Prueba.igualDecimal("con 10%, el primer precio pasa de 100 a 110", 110.0, () -> {
            List<Double> precios = precios();
            Precios.aumentar(precios, 10);
            return precios.get(0);
        });
        Prueba.igualDecimal("el segundo pasa de 250 a 275", 275.0, () -> {
            List<Double> precios = precios();
            Precios.aumentar(precios, 10);
            return precios.get(1);
        });
        Prueba.igualDecimal("y el último de 80 a 88", 88.0, () -> {
            List<Double> precios = precios();
            Precios.aumentar(precios, 10);
            return precios.get(2);
        });
        Prueba.igual("la lista sigue con 3 precios", 3, () -> {
            List<Double> precios = precios();
            Precios.aumentar(precios, 10);
            return precios.size();
        });
        Prueba.igualDecimal("con 50% un precio de 250 queda en 375", 375.0, () -> {
            List<Double> precios = precios();
            Precios.aumentar(precios, 50);
            return precios.get(1);
        });
        Prueba.igualDecimal("aplicar el aumento dos veces se acumula (100 -> 110 -> 121)", 121.0, () -> {
            List<Double> precios = precios();
            Precios.aumentar(precios, 10);
            Precios.aumentar(precios, 10);
            return precios.get(0);
        });
        Prueba.igualDecimal("con 0% nada cambia", 250.0, () -> {
            List<Double> precios = precios();
            Precios.aumentar(precios, 0);
            return precios.get(1);
        });
        Prueba.igual("con una lista vacía no pasa nada", 0, () -> {
            List<Double> precios = new ArrayList<>();
            Precios.aumentar(precios, 10);
            return precios.size();
        });
        Prueba.resumen();
    }
}
