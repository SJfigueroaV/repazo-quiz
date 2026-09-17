public class Agenda {
    private Contacto[] contactos = new Contacto[10];
    private int cantidad = 0;

    /**
     * Agrega el contacto al final de la agenda y devuelve true.
     * Si la agenda ya tiene 10 contactos, no agrega nada y devuelve false.
     */
    public boolean agregar(Contacto contacto) {
        // TODO
        return false;
    }

    /** Devuelve el contacto con ese nombre, o null si no está en la agenda. */
    public Contacto buscar(String nombre) {
        // TODO
        return null;
    }

    /**
     * Elimina el contacto con ese nombre y devuelve true.
     * Si no existe, devuelve false.
     *
     * La agenda NO puede quedar con huecos en la mitad: al eliminar, los
     * contactos siguientes se corren una posición a la izquierda.
     */
    public boolean eliminar(String nombre) {
        // TODO
        return false;
    }

    /** Devuelve cuántos contactos hay guardados ahora mismo. */
    public int cantidad() {
        // TODO
        return 0;
    }

    /**
     * Devuelve el contacto que está en esa posición, o null si la posición
     * está fuera de la agenda o todavía no tiene contacto.
     */
    public Contacto contactoEn(int indice) {
        // TODO
        return null;
    }
}
