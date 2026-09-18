import java.util.ArrayList;

public class Listas {

    public static int sumar(ArrayList<Integer> numeros) {
        int suma = 0;
        for (int numero : numeros) {
            suma += numero;
        }
        return suma;
    }
}
