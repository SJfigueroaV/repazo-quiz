import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> estanteria = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        estanteria.add(libro);
    }

    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : estanteria) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public boolean eliminarLibro(String isbn) {
        // removeIf elimina y compacta sola la lista; devuelve true si borró algo
        return estanteria.removeIf(libro -> libro.getIsbn().equals(isbn));
    }

    public int cantidadLibros() {
        return estanteria.size();
    }

    public List<Libro> librosDe(String autor) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : estanteria) {
            if (libro.getAutor().equals(autor)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }
}
