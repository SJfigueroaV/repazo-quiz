import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> contactos = new ArrayList<>();

    public boolean agregar(Contacto contacto) {
        contactos.add(contacto);
        return true;
    }

    public Contacto buscar(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public boolean eliminar(String nombre) {
        Contacto contacto = buscar(nombre);
        if (contacto == null) {
            return false;
        }
        contactos.remove(contacto);
        return true;
    }

    public int cantidad() {
        return contactos.size();
    }

    public Contacto contactoEn(int indice) {
        if (indice < 0 || indice >= contactos.size()) {
            return null;
        }
        return contactos.get(indice);
    }
}
