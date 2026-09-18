import java.util.ArrayList;
import java.util.List;

public class SalaUrgencias {
    private List<Paciente> listaEspera = new ArrayList<>();

    /**
     * Devuelve una lista NUEVA con los pacientes que tienen ese nivel de triage,
     * en el orden en que llegaron. Los pacientes NO salen de la sala.
     *
     * Si nadie coincide, devuelve una lista vacía.
     */
    public List<Paciente> filtrarPorTriage(int triageObjetivo) {
        // TODO
        return null;
    }

    /** true si hay al menos un paciente con triage 1 esperando. */
    public boolean hayEmergenciaVital() {
        // TODO
        return false;
    }

    // ---- Ya resueltos (ejercicios 3.6 y 3.7) ----

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

    public Paciente atenderSiguiente() {
        if (listaEspera.isEmpty()) {
            return null;
        }
        Paciente masCritico = listaEspera.get(0);
        for (Paciente p : listaEspera) {
            if (p.getNivelTriage() < masCritico.getNivelTriage()
                    || (p.getNivelTriage() == masCritico.getNivelTriage()
                        && p.getHoraLlegada().isBefore(masCritico.getHoraLlegada()))) {
                masCritico = p;
            }
        }
        listaEspera.remove(masCritico);
        return masCritico;
    }
}
