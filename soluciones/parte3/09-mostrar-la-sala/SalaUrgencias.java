import java.util.ArrayList;
import java.util.List;

public class SalaUrgencias {
    private List<Paciente> listaEspera = new ArrayList<>();

    /**
     * Imprime el estado de la sala en forma de tabla. Con la sala vacía
     * imprime una sola línea: La sala de espera está vacía.
     *
     * # | Cédula | Nombre | Triage | Llegada
     * 1 | 101 | Ana Gómez | 3 | 08:30
     * 2 | 102 | Bernardo Silva | 1 | 08:35
     *
     * La numeración empieza en 1 y los pacientes salen en el orden en que llegaron.
     */
    public void mostrarSala() {
        if (listaEspera.isEmpty()) {
            System.out.println("La sala de espera está vacía.");
            return;
        }
        System.out.println("# | Cédula | Nombre | Triage | Llegada");
        for (int i = 0; i < listaEspera.size(); i++) {
            Paciente p = listaEspera.get(i);
            System.out.println((i + 1) + " | " + p.getCedula() + " | " + p.getNombre()
                    + " | " + p.getNivelTriage() + " | " + p.getHoraLlegada());
        }
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
}
