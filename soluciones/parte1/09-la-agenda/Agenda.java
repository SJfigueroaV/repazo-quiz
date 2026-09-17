public class Agenda {
    private Contacto[] contactos = new Contacto[10];
    private int cantidad = 0;

    public boolean agregar(Contacto contacto) {
        if (cantidad >= contactos.length) {
            return false;
        }
        contactos[cantidad] = contacto;
        cantidad++;
        return true;
    }

    public Contacto buscar(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].getNombre().equals(nombre)) {
                return contactos[i];
            }
        }
        return null;
    }

    public boolean eliminar(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].getNombre().equals(nombre)) {
                // Corremos los siguientes una posición a la izquierda
                for (int j = i; j < cantidad - 1; j++) {
                    contactos[j] = contactos[j + 1];
                }
                contactos[cantidad - 1] = null; // limpiamos el hueco del final
                cantidad--;
                return true;
            }
        }
        return false;
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
