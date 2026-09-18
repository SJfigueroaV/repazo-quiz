import java.util.ArrayList;

public class Pruebas {

    private static ArrayList<Empleado> plantilla(String... nombres) {
        // Un nombre que termine en * es un empleado despedido
        ArrayList<Empleado> plantilla = new ArrayList<>();
        for (String nombre : nombres) {
            boolean despedido = nombre.endsWith("*");
            plantilla.add(new Empleado(despedido ? nombre.substring(0, nombre.length() - 1) : nombre, despedido));
        }
        return plantilla;
    }

    public static void main(String[] args) {
        Prueba.igual("de [Ana*, Bernardo, Camila*, Daniel, Elena*] quedan 2", 2, () -> {
            ArrayList<Empleado> equipo = plantilla("Ana*", "Bernardo", "Camila*", "Daniel", "Elena*");
            Plantilla.eliminarDespedidos(equipo);
            return equipo.size();
        });
        Prueba.igual("los que quedan son Bernardo y Daniel", "Daniel", () -> {
            ArrayList<Empleado> equipo = plantilla("Ana*", "Bernardo", "Camila*", "Daniel", "Elena*");
            Plantilla.eliminarDespedidos(equipo);
            return equipo.get(1).getNombre();
        });
        Prueba.igual("también borra al penúltimo (el caso que el for-each se salta)", 3, () -> {
            ArrayList<Empleado> equipo = plantilla("Felipe", "Gloria", "Hugo", "Iván*", "Julia*");
            Plantilla.eliminarDespedidos(equipo);
            return equipo.size();
        });
        Prueba.igual("si todos están despedidos la lista queda vacía", 0, () -> {
            ArrayList<Empleado> equipo = plantilla("Ana*", "Beto*", "Carlos*");
            Plantilla.eliminarDespedidos(equipo);
            return equipo.size();
        });
        Prueba.igual("si ninguno está despedido la lista queda igual", 3, () -> {
            ArrayList<Empleado> equipo = plantilla("Ana", "Beto", "Carlos");
            Plantilla.eliminarDespedidos(equipo);
            return equipo.size();
        });
        Prueba.igual("con dos despedidos seguidos no se salta ninguno", 1, () -> {
            ArrayList<Empleado> equipo = plantilla("Ana*", "Beto*", "Carlos");
            Plantilla.eliminarDespedidos(equipo);
            return equipo.size();
        });
        Prueba.igual("una lista vacía no se cae", 0, () -> {
            ArrayList<Empleado> equipo = plantilla();
            Plantilla.eliminarDespedidos(equipo);
            return equipo.size();
        });
        Prueba.resumen();
    }
}
