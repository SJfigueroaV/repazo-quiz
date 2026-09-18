import java.util.ArrayList;

public class Pruebas {

    private static ArrayList<Integer> lista(int... numeros) {
        ArrayList<Integer> resultado = new ArrayList<>();
        for (int numero : numeros) {
            resultado.add(numero);
        }
        return resultado;
    }

    public static void main(String[] args) {
        Prueba.igual("quitar el 20 de [10, 20, 30] deja 2 elementos", 2, () -> {
            ArrayList<Integer> numeros = lista(10, 20, 30);
            Listas.quitarElNumero(numeros, 20);
            return numeros.size();
        });
        Prueba.igual("y los que quedan son [10, 30]", 30, () -> {
            ArrayList<Integer> numeros = lista(10, 20, 30);
            Listas.quitarElNumero(numeros, 20);
            return numeros.get(1);
        });
        Prueba.igual("quitar un número que no está deja la lista igual", 3, () -> {
            ArrayList<Integer> numeros = lista(10, 20, 30);
            Listas.quitarElNumero(numeros, 1);
            return numeros.size();
        });
        Prueba.igual("quitar el 1 NO borra la posición 1 (el 20 sigue ahí)", 20, () -> {
            ArrayList<Integer> numeros = lista(10, 20, 30);
            Listas.quitarElNumero(numeros, 1);
            return numeros.get(1);
        });
        Prueba.igual("quita solo la primera aparición de los repetidos", 1, () -> {
            ArrayList<Integer> numeros = lista(5, 5);
            Listas.quitarElNumero(numeros, 5);
            return numeros.size();
        });
        Prueba.igual("quitar de una lista vacía no se cae", 0, () -> {
            ArrayList<Integer> numeros = lista();
            Listas.quitarElNumero(numeros, 7);
            return numeros.size();
        });
        Prueba.resumen();
    }
}
