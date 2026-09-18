import java.util.ArrayList;
import java.util.List;

/**
 * La biblioteca original guardaba los libros en un arreglo fijo:
 *
 *     private Libro[] estanteria = new Libro[50];
 *     private int cantidadLibros = 0;
 *
 * Tu tarea es escribir la misma clase, pero con una lista dinámica.
 */
public class Biblioteca {
    private List<Libro> estanteria = new ArrayList<>();

    /** Agrega el libro a la estantería. Ya no puede fallar por falta de espacio. */
    public void agregarLibro(Libro libro) {
        // TODO
    }

    /** Devuelve el libro con ese ISBN, o null si no está. */
    public Libro buscarPorIsbn(String isbn) {
        // TODO
        return null;
    }

    /** Elimina el libro con ese ISBN. Devuelve true si lo eliminó. */
    public boolean eliminarLibro(String isbn) {
        // TODO
        return false;
    }

    /** Cuántos libros hay en la estantería. */
    public int cantidadLibros() {
        // TODO
        return 0;
    }

    /** Devuelve una lista nueva con los libros de ese autor. */
    public List<Libro> librosDe(String autor) {
        // TODO
        return null;
    }
}
