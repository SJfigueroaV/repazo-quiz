import java.util.ArrayList;

public class Pruebas {

    private static ArrayList<Estudiante> curso() {
        ArrayList<Estudiante> curso = new ArrayList<>();
        curso.add(new Estudiante("Ana Gómez", 4.5));
        curso.add(new Estudiante("Bernardo Silva", 3.8));
        curso.add(new Estudiante("Camila Torres", 4.8));
        return curso;
    }

    private static ArrayList<Estudiante> conEmpate() {
        ArrayList<Estudiante> curso = new ArrayList<>();
        curso.add(new Estudiante("Ana", 4.0));
        curso.add(new Estudiante("Beto", 4.8));
        curso.add(new Estudiante("Carlos", 4.8));
        return curso;
    }

    public static void main(String[] args) {
        Prueba.igualDecimal("el promedio de 4.5, 3.8 y 4.8 es 4.3667", 4.366666666,
                () -> Curso.promedio(curso()));
        Prueba.igualDecimal("un curso vacío tiene promedio 0.0 y no se cae", 0.0,
                () -> Curso.promedio(new ArrayList<Estudiante>()));
        Prueba.igualDecimal("con un solo estudiante el promedio es su nota", 4.5, () -> {
            ArrayList<Estudiante> uno = new ArrayList<>();
            uno.add(new Estudiante("Ana", 4.5));
            return Curso.promedio(uno);
        });

        Prueba.igual("la mejor nota es la de Camila", "Camila Torres", () -> Curso.mejor(curso()).getNombre());
        Prueba.igual("si el mejor está de primero también lo encuentra", "Ana", () -> {
            ArrayList<Estudiante> curso = new ArrayList<>();
            curso.add(new Estudiante("Ana", 5.0));
            curso.add(new Estudiante("Beto", 2.0));
            return Curso.mejor(curso).getNombre();
        });
        Prueba.igual("si hay empate gana el primero de la lista", "Beto", () -> Curso.mejor(conEmpate()).getNombre());
        Prueba.esNulo("con un curso vacío devuelve null", () -> Curso.mejor(new ArrayList<Estudiante>()));
        Prueba.resumen();
    }
}
