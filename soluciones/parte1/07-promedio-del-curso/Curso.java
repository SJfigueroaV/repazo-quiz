public class Curso {

    public static double promedio(Estudiante[] curso) {
        double suma = 0.0;
        int registrados = 0;
        for (int i = 0; i < curso.length; i++) {
            if (curso[i] != null) {
                suma += curso[i].getNotaFinal();
                registrados++;
            }
        }
        if (registrados == 0) {
            return 0.0;
        }
        return suma / registrados;
    }
}
