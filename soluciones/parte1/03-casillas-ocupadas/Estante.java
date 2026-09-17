public class Estante {

    public static int casillasOcupadas(Libro[] estante) {
        int ocupadas = 0;
        for (int i = 0; i < estante.length; i++) {
            if (estante[i] != null) {
                ocupadas++;
            }
        }
        return ocupadas;
    }
}
