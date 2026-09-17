public class Agenda {
    private Contacto[] contactos = new Contacto[5]; // arranca con 5 casillas
    private int cantidad = 0;

    /**
     * Agrega el contacto al final de la agenda. Siempre devuelve true: si la
     * agenda se queda sin espacio, PRIMERO se amplía y después agrega.
     *
     * Ampliar significa: crear un arreglo nuevo del doble de casillas, copiar
     * los contactos viejos al nuevo y quedarse con el nuevo.
     */
    public boolean agregar(Contacto contacto) {
        // TODO: si cantidad == contactos.length, amplía el arreglo antes de guardar
        contactos[cantidad] = contacto;
        cantidad++;
        return true;
    }

    /** Devuelve cuántas casillas tiene el arreglo interno ahora mismo. */
    public int capacidad() {
        // TODO
        return 0;
    }

    // ---- Estos métodos ya están resueltos (son los del ejercicio anterior) ----

    public Contacto buscar(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].getNombre().equals(nombre)) {
                return contactos[i];
            }
        }
        return null;
    }

    public int cantidad() {
        return cantidad;
    }

    public Contacto contactoEn(int indice) {
        if (indice < 0 || indice >= cantidad) {
            return null;
        }
        return contactos[indice];
    }
}
