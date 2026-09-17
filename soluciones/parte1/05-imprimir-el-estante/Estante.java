public class Estante {

    public static void imprimir(Libro[] estante) {
        for (int i = 0; i < estante.length; i++) {
            if (estante[i] != null) {
                System.out.println("[" + i + "] " + estante[i].getTitulo());
            } else {
                System.out.println("[" + i + "] Casilla vacía");
            }
        }
    }
}
