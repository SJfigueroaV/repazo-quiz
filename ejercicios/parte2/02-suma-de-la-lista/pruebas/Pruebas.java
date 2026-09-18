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
        Prueba.igual("sumar [1, 2, 3] devuelve 6", 6, () -> Listas.sumar(lista(1, 2, 3)));
        Prueba.igual("sumar [7] devuelve 7", 7, () -> Listas.sumar(lista(7)));
        Prueba.igual("sumar [10, -4, 2] devuelve 8", 8, () -> Listas.sumar(lista(10, -4, 2)));
        Prueba.igual("sumar una lista vacía devuelve 0", 0, () -> Listas.sumar(lista()));
        Prueba.igual("sumar [1, 1, 1, 1, 1] devuelve 5", 5, () -> Listas.sumar(lista(1, 1, 1, 1, 1)));
        Prueba.resumen();
    }
}
