public class Pruebas {
    public static void main(String[] args) {
        Prueba.igual("sumar({1, 2, 3}) devuelve 6", 6, () -> Calculadora.sumar(new int[]{1, 2, 3}));
        Prueba.igual("sumar({7}) devuelve 7", 7, () -> Calculadora.sumar(new int[]{7}));
        Prueba.igual("sumar({10, -4, 2}) devuelve 8", 8, () -> Calculadora.sumar(new int[]{10, -4, 2}));
        Prueba.igual("sumar({}) devuelve 0", 0, () -> Calculadora.sumar(new int[]{}));
        Prueba.resumen();
    }
}
