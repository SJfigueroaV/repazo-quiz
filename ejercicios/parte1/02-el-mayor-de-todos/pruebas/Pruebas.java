public class Pruebas {
    public static void main(String[] args) {
        Prueba.igual("mayor({3, 9, 2}) devuelve 9", 9, () -> Calculadora.mayor(new int[]{3, 9, 2}));
        Prueba.igual("mayor({5}) devuelve 5", 5, () -> Calculadora.mayor(new int[]{5}));
        Prueba.igual("mayor({9, 3, 2}) devuelve 9 (el mayor va primero)", 9, () -> Calculadora.mayor(new int[]{9, 3, 2}));
        Prueba.igual("mayor({-4, -9, -1}) devuelve -1 (todos negativos)", -1, () -> Calculadora.mayor(new int[]{-4, -9, -1}));
        Prueba.igual("mayor({2, 2}) devuelve 2", 2, () -> Calculadora.mayor(new int[]{2, 2}));
        Prueba.resumen();
    }
}
