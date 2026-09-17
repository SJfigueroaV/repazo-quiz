public class Pruebas {
    public static void main(String[] args) {
        Estudiante[] conHuecos = new Estudiante[4];
        conHuecos[0] = new Estudiante("Ana Gómez", 4.5);
        conHuecos[1] = new Estudiante("Bernardo Silva", 3.8);
        conHuecos[2] = new Estudiante("Camila Torres", 4.8);

        Estudiante[] unoSolo = new Estudiante[3];
        unoSolo[2] = new Estudiante("Daniel Ruiz", 3.0);

        Prueba.igualDecimal("promedio de 4.5, 3.8 y 4.8 (con una casilla vacía) es 4.3667", 4.366666666,
                () -> Curso.promedio(conHuecos));
        Prueba.igualDecimal("divide entre los estudiantes reales, no entre el tamaño del arreglo", 3.0,
                () -> Curso.promedio(unoSolo));
        Prueba.igualDecimal("un curso sin estudiantes devuelve 0.0 y no se cae", 0.0,
                () -> Curso.promedio(new Estudiante[5]));
        Prueba.igualDecimal("un arreglo de tamaño 0 devuelve 0.0", 0.0,
                () -> Curso.promedio(new Estudiante[0]));
        Prueba.resumen();
    }
}
