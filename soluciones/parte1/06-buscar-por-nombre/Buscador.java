public class Buscador {

    public static Persona buscarPorNombre(Persona[] grupo, String nombre) {
        for (int i = 0; i < grupo.length; i++) {
            if (grupo[i] != null && grupo[i].getNombre().equals(nombre)) {
                return grupo[i];
            }
        }
        return null;
    }
}
