public class Pruebas {
    public static void main(String[] args) {
        Prueba.esVerdadero("devuelve true al agregar en un estante vacío", () -> {
            Libro[] estante = new Libro[3];
            return Estante.agregar(estante, new Libro("Clean Code", "Martin"));
        });

        Prueba.igual("guarda el libro en la casilla 0 de un estante vacío", "Clean Code", () -> {
            Libro[] estante = new Libro[3];
            Estante.agregar(estante, new Libro("Clean Code", "Martin"));
            return estante[0].getTitulo();
        });

        Prueba.igual("si la casilla 0 está ocupada, usa la casilla 1", "Clean Code", () -> {
            Libro[] estante = new Libro[3];
            estante[0] = new Libro("Effective Java", "Bloch");
            Estante.agregar(estante, new Libro("Clean Code", "Martin"));
            return estante[1].getTitulo();
        });

        Prueba.igual("aprovecha un hueco en la mitad del estante", "Clean Code", () -> {
            Libro[] estante = new Libro[3];
            estante[0] = new Libro("Effective Java", "Bloch");
            estante[2] = new Libro("Design Patterns", "Gamma");
            Estante.agregar(estante, new Libro("Clean Code", "Martin"));
            return estante[1].getTitulo();
        });

        Prueba.esFalso("devuelve false si el estante está lleno", () -> {
            Libro[] estante = { new Libro("Uno", "A"), new Libro("Dos", "B") };
            return Estante.agregar(estante, new Libro("Tres", "C"));
        });

        Prueba.igual("con el estante lleno no reemplaza ningún libro", "Uno", () -> {
            Libro[] estante = { new Libro("Uno", "A"), new Libro("Dos", "B") };
            Estante.agregar(estante, new Libro("Tres", "C"));
            return estante[0].getTitulo();
        });
        Prueba.resumen();
    }
}
