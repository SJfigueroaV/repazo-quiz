public class Nombres {

    public static String nombres(Persona[] grupo) {
        String resultado = "";
        for (int i = 0; i < grupo.length; i++) {
            if (grupo[i] == null) {
                continue;
            }
            if (!resultado.isEmpty()) {
                resultado += ", ";
            }
            resultado += grupo[i].getNombre();
        }
        return resultado;
    }
}
