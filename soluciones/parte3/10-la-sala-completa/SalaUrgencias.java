import java.util.ArrayList;
import java.util.List;

public class SalaUrgencias {
    private List<Paciente> listaEspera = new ArrayList<>();

    /**
     * Atiende a TODOS los pacientes y devuelve la lista de atendidos en el
     * orden en que pasaron a consulta. La sala queda vacía.
     *
     * Con la sala vacía devuelve una lista vacía.
     */
    public List<Paciente> atenderTodos() {
        List<Paciente> atendidos = new ArrayList<>();
        while (cantidadEnEspera() > 0) {
            atendidos.add(atenderSiguiente());
        }
        return atendidos;
    }

    /**
     * Promedio de los niveles de triage de los pacientes en espera.
     * Con la sala vacía devuelve 0.0.
     */
    public double promedioTriage() {
        if (listaEspera.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (Paciente p : listaEspera) {
            suma += p.getNivelTriage();
        }
        return suma / listaEspera.size();
    }

    // ---- Ya resueltos ----

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
