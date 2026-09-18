import java.util.ArrayList;

/**
 * La misma agenda del ejercicio 1.9, pero por dentro usa una lista dinámica.
 * Los métodos públicos son idénticos: quien use la Agenda no nota el cambio.
 */
public class Agenda {
    private ArrayList<Contacto> contactos = new ArrayList<>();

    /** Agrega el contacto al final. Ahora SIEMPRE devuelve true: ya no hay límite. */
    public boolean agregar(Contacto contacto) {
        // TODO
        return false;
    }

    public Contacto buscar(String nombre) {
        // TODO
        return null;
    }

    /** Elimina el contacto con ese nombre. Devuelve true si lo eliminó. */
    public boolean eliminar(String nombre) {
        // TODO
        return false;
    }

    public int cantidad() {
        // TODO
        return 0;
    }

    /** El contacto en esa posición, o null si la posición no existe. */
    public Contacto contactoEn(int indice) {
        // TODO
        return null;
    }
}
