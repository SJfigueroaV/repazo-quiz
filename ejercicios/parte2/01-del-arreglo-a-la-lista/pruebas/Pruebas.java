public class Pruebas {
    public static void main(String[] args) {
        String[] arreglo = { "hola", "mundo", "!" };

        Prueba.igual("la lista tiene 3 elementos", 3, () -> Listas.desdeArreglo(arreglo).size());
        Prueba.igual("el primer elemento es \"hola\"", "hola", () -> Listas.desdeArreglo(arreglo).get(0));
        Prueba.igual("el último elemento es \"!\"", "!", () -> Listas.desdeArreglo(arreglo).get(2));
        Prueba.igual("respeta el orden del arreglo", "mundo", () -> Listas.desdeArreglo(arreglo).get(1));
        Prueba.igual("un arreglo vacío devuelve una lista de tamaño 0", 0,
                () -> Listas.desdeArreglo(new String[0]).size());
        Prueba.esFalso("con un arreglo vacío devuelve una lista, no null",
                () -> Listas.desdeArreglo(new String[0]) == null);
        Prueba.resumen();
    }
}
