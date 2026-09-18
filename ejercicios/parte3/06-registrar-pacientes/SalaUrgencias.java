import java.util.ArrayList;
import java.util.List;

public class SalaUrgencias {
    private List<Paciente> listaEspera = new ArrayList<>();

    /**
     * Agrega un paciente a la lista de espera.
     * Si le pasan null, lanza IllegalArgumentException (un null en la lista
     * haría explotar todos los demás métodos más adelante).
     */
    public void registrarPaciente(Paciente p) {
        // TODO
    }

    /** Cuántos pacientes están esperando. */
    public int cantidadEnEspera() {
        // TODO
        return 0;
    }

    /**
     * Los pacientes en espera, PARA CONSULTA.
     * Quien reciba esta lista no debe poder registrar ni sacar pacientes de la sala.
     */
    public List<Paciente> pacientesEnEspera() {
        // TODO
        return null;
    }
}
