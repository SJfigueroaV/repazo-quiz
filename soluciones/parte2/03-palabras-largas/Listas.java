import java.util.ArrayList;

public class Listas {

    public static ArrayList<String> largas(ArrayList<String> palabras, int minimo) {
        ArrayList<String> resultado = new ArrayList<>();
        for (String palabra : palabras) {
            if (palabra.length() >= minimo) {
                resultado.add(palabra);
            }
        }
        return resultado;
    }
}
