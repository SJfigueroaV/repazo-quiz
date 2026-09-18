import java.util.ArrayList;

public class Pruebas {

    private static ArrayList<String> lista(String... palabras) {
        ArrayList<String> resultado = new ArrayList<>();
        for (String palabra : palabras) {
            resultado.add(palabra);
        }
        return resultado;
    }

    public static void main(String[] args) {
        Prueba.igual("de [sol, arreglo, luna, dinamico] con mínimo 5 quedan 2", 2,
                () -> Listas.largas(lista("sol", "arreglo", "luna", "dinamico"), 5).size());
        Prueba.igual("la primera que queda es \"arreglo\"", "arreglo",
                () -> Listas.largas(lista("sol", "arreglo", "luna", "dinamico"), 5).get(0));
        Prueba.igual("respeta el orden original", "dinamico",
                () -> Listas.largas(lista("sol", "arreglo", "luna", "dinamico"), 5).get(1));
        Prueba.igual("incluye las palabras que miden exactamente el mínimo", 1,
                () -> Listas.largas(lista("luna", "sol"), 4).size());
        Prueba.igual("si ninguna cumple devuelve una lista vacía", 0,
                () -> Listas.largas(lista("sol", "luz"), 10).size());
        Prueba.igual("no modifica la lista original", 4, () -> {
            ArrayList<String> original = lista("sol", "arreglo", "luna", "dinamico");
            Listas.largas(original, 5);
            return original.size();
        });
        Prueba.resumen();
    }
}
