import java.util.List;

public class Pruebas {

    private static Equipo equipo() {
        Equipo equipo = new Equipo();
        equipo.fichar(new Jugador("Ana", 7));
        equipo.fichar(new Jugador("Beto", 3));
        return equipo;
    }

    public static void main(String[] args) {
        Prueba.igual("un equipo nuevo no tiene jugadores", 0, () -> new Equipo().cantidad());
        Prueba.igual("después de fichar a 2 jugadores la cantidad es 2", 2, () -> equipo().cantidad());
        Prueba.igual("getJugadores devuelve los 2 jugadores", 2, () -> equipo().getJugadores().size());
        Prueba.igual("y son los que fichamos", "Ana", () -> equipo().getJugadores().get(0).getNombre());
        Prueba.igual("golesTotales suma los goles de todos", 10, () -> equipo().golesTotales());
        Prueba.igual("un equipo vacío tiene 0 goles", 0, () -> new Equipo().golesTotales());

        Prueba.igual("agregar a la lista devuelta NO mete un jugador al equipo", 2, () -> {
            Equipo equipo = equipo();
            List<Jugador> vista = equipo.getJugadores();
            try {
                vista.add(new Jugador("Colado", 99));
            } catch (UnsupportedOperationException e) {
                // perfecto: devolviste una vista de solo lectura
            }
            return equipo.cantidad();
        });

        Prueba.igual("vaciar la lista devuelta NO vacía el equipo", 2, () -> {
            Equipo equipo = equipo();
            List<Jugador> vista = equipo.getJugadores();
            try {
                vista.clear();
            } catch (UnsupportedOperationException e) {
                // también perfecto
            }
            return equipo.cantidad();
        });

        Prueba.igual("y los goles tampoco cambian por fuera", 10, () -> {
            Equipo equipo = equipo();
            try {
                equipo.getJugadores().add(new Jugador("Colado", 99));
            } catch (UnsupportedOperationException e) {
                // ok
            }
            return equipo.golesTotales();
        });
        Prueba.resumen();
    }
}
