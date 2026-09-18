import java.util.ArrayList;

public class Listas {

    public static ArrayList<String> desdeArreglo(String[] palabras) {
        ArrayList<String> lista = new ArrayList<>();
        for (String palabra : palabras) {
            lista.add(palabra);
        }
        return lista;
    }
}
