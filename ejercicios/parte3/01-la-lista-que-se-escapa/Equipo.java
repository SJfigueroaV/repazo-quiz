import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private List<Jugador> jugadores = new ArrayList<>();

    /** Agrega un jugador al equipo. */
    public void fichar(Jugador jugador) {
        // TODO
    }

    /** Cuántos jugadores tiene el equipo. */
    public int cantidad() {
        // TODO
        return 0;
    }

    /**
     * Devuelve los jugadores del equipo PARA CONSULTA.
     *
     * Quien reciba esta lista no debe poder meter ni sacar jugadores del equipo.
     * Tienes dos formas de lograrlo:
     *   - devolver una copia:  new ArrayList<>(jugadores)
     *   - devolver una vista de solo lectura: Collections.unmodifiableList(jugadores)
     */
    public List<Jugador> getJugadores() {
        // TODO
        return null;
    }

    /** Suma de los goles de todos los jugadores. */
    public int golesTotales() {
        // TODO
        return 0;
    }
}
