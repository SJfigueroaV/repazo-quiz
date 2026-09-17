public class Agenda {
    private Contacto[] contactos = new Contacto[5];
    private int cantidad = 0;

    public boolean agregar(Contacto contacto) {
        if (cantidad == contactos.length) {
            ampliar();
        }
        contactos[cantidad] = contacto;
        cantidad++;
        return true;
    }

    /** Crea un arreglo del doble de casillas y copia los contactos viejos. */
    private void ampliar() {
        Contacto[] masGrande = new Contacto[contactos.length * 2];
        for (int i = 0; i < contactos.length; i++) {
            masGrande[i] = contactos[i];
        }
        contactos = masGrande;
    }

    public int capacidad() {
        return contactos.length;
    }

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
