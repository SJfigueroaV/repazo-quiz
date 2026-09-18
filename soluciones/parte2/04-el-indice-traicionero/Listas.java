import java.util.ArrayList;

public class Listas {

    public static void quitarElNumero(ArrayList<Integer> numeros, int numero) {
        // remove(int) borra por posición; para borrar por valor hay que
        // pasarle un Integer, no un int.
        numeros.remove(Integer.valueOf(numero));
    }
}
