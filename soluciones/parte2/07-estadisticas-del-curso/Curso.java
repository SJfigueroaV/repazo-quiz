import java.util.ArrayList;

public class Curso {

    public static double promedio(ArrayList<Estudiante> curso) {
        if (curso.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (Estudiante estudiante : curso) {
            suma += estudiante.getNotaFinal();
        }
        return suma / curso.size();
    }

    public static Estudiante mejor(ArrayList<Estudiante> curso) {
        if (curso.isEmpty()) {
            return null;
        }
        Estudiante mejor = curso.get(0);
        for (Estudiante estudiante : curso) {
            // Con > (y no >=) el empate se lo queda el primero que encontramos
            if (estudiante.getNotaFinal() > mejor.getNotaFinal()) {
                mejor = estudiante;
            }
        }
        return mejor;
    }
}
