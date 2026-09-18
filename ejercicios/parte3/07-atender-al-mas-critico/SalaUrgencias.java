import java.util.ArrayList;
import java.util.List;

public class SalaUrgencias {
    private List<Paciente> listaEspera = new ArrayList<>();

    /**
     * Busca y REMUEVE de la lista al paciente con el nivel de triage más crítico
     * (el número más bajo). Si hay empate, atiende al que llegó primero.
     *
     * Si no hay nadie esperando, devuelve null (sin lanzar excepciones).
     */
    public Paciente atenderSiguiente() {
        // TODO
        return null;
    }

    // ---- Ya resueltos (ejercicio 3.6) ----

    public void registrarPaciente(Paciente p) {
        if (p == null) {
            throw new IllegalArgumentException("No se puede registrar un paciente nulo.");
        }
        listaEspera.add(p);
    }

    public int cantidadEnEspera() {
        return listaEspera.size();
    }

    public List<Paciente> pacientesEnEspera() {
        return new ArrayList<>(listaEspera);
    }
}
