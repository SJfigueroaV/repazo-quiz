import java.util.ArrayList;
import java.util.List;

public class Pruebas {

    private static List<Cliente> cartera() {
        List<Cliente> cartera = new ArrayList<>();
        cartera.add(new Cliente("101", "Carlos", 1500000.0));
        cartera.add(new Cliente("102", "Diana", 2400000.0));
        cartera.add(new Cliente("103", "Eduardo", 850000.0));
        return cartera;
    }

    public static void main(String[] args) {
        Prueba.esVerdadero("subir el cupo de un cliente que existe devuelve true",
                () -> Cartera.subirCupo(cartera(), "102", 3000000.0));

        Prueba.igualDecimal("el cliente de la lista queda con el cupo nuevo", 3000000.0, () -> {
            List<Cliente> cartera = cartera();
            Cartera.subirCupo(cartera, "102", 3000000.0);
            return cartera.get(1).getCupo();
        });

        Prueba.esVerdadero("el cliente se modifica, no se reemplaza por otro objeto", () -> {
            List<Cliente> cartera = cartera();
            Cliente diana = cartera.get(1);
            Cartera.subirCupo(cartera, "102", 3000000.0);
            return cartera.get(1) == diana && diana.getCupo() == 3000000.0;
        });

        Prueba.igual("la lista sigue con 3 clientes", 3, () -> {
            List<Cliente> cartera = cartera();
            Cartera.subirCupo(cartera, "102", 3000000.0);
            return cartera.size();
        });

        Prueba.igualDecimal("los demás clientes no cambian", 1500000.0, () -> {
            List<Cliente> cartera = cartera();
            Cartera.subirCupo(cartera, "102", 3000000.0);
            return cartera.get(0).getCupo();
        });

        Prueba.esVerdadero("funciona con el último de la lista",
                () -> {
                    List<Cliente> cartera = cartera();
                    return Cartera.subirCupo(cartera, "103", 900000.0) && cartera.get(2).getCupo() == 900000.0;
                });

        Prueba.esVerdadero("compara la cédula por contenido (equals), no con ==",
                () -> Cartera.subirCupo(cartera(), new String("101"), 2000000.0));

        Prueba.esFalso("una cédula que no existe devuelve false",
                () -> Cartera.subirCupo(cartera(), "999", 5000000.0));

        Prueba.igualDecimal("y no toca a nadie", 850000.0, () -> {
            List<Cliente> cartera = cartera();
            Cartera.subirCupo(cartera, "999", 5000000.0);
            return cartera.get(2).getCupo();
        });

        Prueba.esFalso("con una cartera vacía devuelve false",
                () -> Cartera.subirCupo(new ArrayList<>(), "101", 1.0));
        Prueba.resumen();
    }
}
