public class Pruebas {

    private static Biblioteca biblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(new Libro("978-0134685991", "Effective Java", "Bloch"));
        biblioteca.agregarLibro(new Libro("978-0132350884", "Clean Code", "Martin"));
        biblioteca.agregarLibro(new Libro("978-0135974445", "Agile Software Development", "Martin"));
        return biblioteca;
    }

    public static void main(String[] args) {
        Prueba.igual("una biblioteca nueva no tiene libros", 0, () -> new Biblioteca().cantidadLibros());
        Prueba.igual("después de agregar 3 libros hay 3", 3, () -> biblioteca().cantidadLibros());
        Prueba.igual("ya no hay límite de 50: caben 120 libros", 120, () -> {
            Biblioteca biblioteca = new Biblioteca();
            for (int i = 1; i <= 120; i++) {
                biblioteca.agregarLibro(new Libro("ISBN-" + i, "Libro " + i, "Autor " + i));
            }
            return biblioteca.cantidadLibros();
        });

        Prueba.igual("busca Clean Code por su ISBN", "Clean Code",
                () -> biblioteca().buscarPorIsbn("978-0132350884").getTitulo());
        Prueba.esNulo("un ISBN que no existe devuelve null", () -> biblioteca().buscarPorIsbn("000"));
        Prueba.esNulo("buscar en una biblioteca vacía devuelve null",
                () -> new Biblioteca().buscarPorIsbn("978-0132350884"));

        Prueba.esVerdadero("eliminar un libro existente devuelve true",
                () -> biblioteca().eliminarLibro("978-0134685991"));
        Prueba.esFalso("eliminar un ISBN que no existe devuelve false", () -> biblioteca().eliminarLibro("000"));
        Prueba.igual("al eliminar queda un libro menos", 2, () -> {
            Biblioteca biblioteca = biblioteca();
            biblioteca.eliminarLibro("978-0134685991");
            return biblioteca.cantidadLibros();
        });
        Prueba.esNulo("el libro eliminado ya no se encuentra", () -> {
            Biblioteca biblioteca = biblioteca();
            biblioteca.eliminarLibro("978-0132350884");
            return biblioteca.buscarPorIsbn("978-0132350884");
        });
        Prueba.igual("la lista se compacta: los otros libros siguen ahí", "Effective Java", () -> {
            Biblioteca biblioteca = biblioteca();
            biblioteca.eliminarLibro("978-0132350884");
            return biblioteca.buscarPorIsbn("978-0134685991").getTitulo();
        });

        Prueba.igual("Martin tiene 2 libros", 2, () -> biblioteca().librosDe("Martin").size());
        Prueba.igual("Bloch tiene 1", 1, () -> biblioteca().librosDe("Bloch").size());
        Prueba.igual("un autor sin libros devuelve una lista vacía", 0, () -> biblioteca().librosDe("Nadie").size());
        Prueba.igual("librosDe no saca los libros de la biblioteca", 3, () -> {
            Biblioteca biblioteca = biblioteca();
            biblioteca.librosDe("Martin");
            return biblioteca.cantidadLibros();
        });
        Prueba.resumen();
    }
}
