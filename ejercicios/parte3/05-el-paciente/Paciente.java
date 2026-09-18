import java.time.LocalTime;

/**
 * Un paciente de la sala de urgencias.
 *
 * nivelTriage va de 1 a 5, donde 1 es paro cardíaco / emergencia vital
 * y 5 es cita menor.
 */
public class Paciente {
    private String cedula;
    private String nombre;
    private int nivelTriage;
    private LocalTime horaLlegada;

    /**
     * Si el nivel de triage no está entre 1 y 5, lanza IllegalArgumentException:
     *
     *     throw new IllegalArgumentException("El nivel de triage debe estar entre 1 y 5.");
     */
    public Paciente(String cedula, String nombre, int nivelTriage, LocalTime horaLlegada) {
        // TODO: valida el triage y guarda los cuatro atributos
    }

    public String getCedula() {
        // TODO
        return null;
    }

    public String getNombre() {
        // TODO
        return null;
    }

    public int getNivelTriage() {
        // TODO
        return 0;
    }

    public LocalTime getHoraLlegada() {
        // TODO
        return null;
    }

    /** Formato exacto: Ana Gómez (C.C. 101) - Triage 3 - 08:30 */
    @Override
    public String toString() {
        // TODO
        return "";
    }
}
