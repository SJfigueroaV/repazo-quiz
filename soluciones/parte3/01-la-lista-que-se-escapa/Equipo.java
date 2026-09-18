import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equipo {
    private List<Jugador> jugadores = new ArrayList<>();

    public void fichar(Jugador jugador) {
        jugadores.add(jugador);
    }

    public int cantidad() {
        return jugadores.size();
    }

    public List<Jugador> getJugadores() {
        // Vista de solo lectura: quien la reciba puede mirar, no modificar.
        // La otra opción válida es: return new ArrayList<>(jugadores);
        return Collections.unmodifiableList(jugadores);
    }

    public int golesTotales() {
        int total = 0;
        for (Jugador jugador : jugadores) {
            total += jugador.getGoles();
        }
        return total;
    }
}
