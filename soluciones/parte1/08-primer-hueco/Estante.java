public class Estante {

    public static boolean agregar(Libro[] estante, Libro libro) {
        for (int i = 0; i < estante.length; i++) {
            if (estante[i] == null) {
                estante[i] = libro;
                return true;
            }
        }
        return false;
    }
}
