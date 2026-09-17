public class Pruebas {
    public static void main(String[] args) {
        Libro[] conDosLibros = new Libro[5];
        conDosLibros[0] = new Libro("Effective Java", "Bloch");
        conDosLibros[3] = new Libro("Clean Code", "Martin");

        Libro[] lleno = {
            new Libro("Effective Java", "Bloch"),
            new Libro("Clean Code", "Martin"),
            new Libro("Design Patterns", "Gamma")
        };

        Prueba.igual("un estante de 5 con 2 libros devuelve 2", 2, () -> Estante.casillasOcupadas(conDosLibros));
        Prueba.igual("un estante recién creado devuelve 0", 0, () -> Estante.casillasOcupadas(new Libro[3]));
        Prueba.igual("un estante sin huecos devuelve 3", 3, () -> Estante.casillasOcupadas(lleno));
        Prueba.igual("un estante de tamaño 0 devuelve 0", 0, () -> Estante.casillasOcupadas(new Libro[0]));
        Prueba.resumen();
    }
}
