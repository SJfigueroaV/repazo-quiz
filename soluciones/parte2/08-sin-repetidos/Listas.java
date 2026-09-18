import java.util.ArrayList;

public class Listas {

    public static ArrayList<String> sinRepetidos(ArrayList<String> palabras) {
        ArrayList<String> resultado = new ArrayList<>();
        for (String palabra : palabras) {
            if (!resultado.contains(palabra)) {
                resultado.add(palabra);
            }
        }
        return resultado;
    }
}
