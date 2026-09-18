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
        Prueba.igual("de [sol, luna, sol, mar] quedan 3 palabras", 3,
                () -> Listas.sinRepetidos(lista("sol", "luna", "sol", "mar")).size());
        Prueba.igual("conserva el orden de la primera aparición", "luna",
                () -> Listas.sinRepetidos(lista("sol", "luna", "sol", "mar")).get(1));
        Prueba.igual("la última es \"mar\"", "mar",
                () -> Listas.sinRepetidos(lista("sol", "luna", "sol", "mar")).get(2));
        Prueba.igual("una lista sin repetidos queda igual", 3,
                () -> Listas.sinRepetidos(lista("a", "b", "c")).size());
        Prueba.igual("de [a, a, a] queda una sola", 1,
                () -> Listas.sinRepetidos(lista("a", "a", "a")).size());
        Prueba.igual("una lista vacía devuelve una lista vacía", 0,
                () -> Listas.sinRepetidos(lista()).size());
        Prueba.igual("no modifica la lista original", 4, () -> {
            ArrayList<String> original = lista("sol", "luna", "sol", "mar");
            Listas.sinRepetidos(original);
            return original.size();
        });
        Prueba.resumen();
    }
}
