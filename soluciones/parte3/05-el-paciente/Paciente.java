import java.time.LocalTime;

public class Paciente {
    private String cedula;
    private String nombre;
    private int nivelTriage;
    private LocalTime horaLlegada;

    public Paciente(String cedula, String nombre, int nivelTriage, LocalTime horaLlegada) {
        if (nivelTriage < 1 || nivelTriage > 5) {
            throw new IllegalArgumentException("El nivel de triage debe estar entre 1 y 5.");
        }
        this.cedula = cedula;
        this.nombre = nombre;
        this.nivelTriage = nivelTriage;
        this.horaLlegada = horaLlegada;
    }

    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public int getNivelTriage() { return nivelTriage; }
    public LocalTime getHoraLlegada() { return horaLlegada; }

    @Override
    public String toString() {
        return nombre + " (C.C. " + cedula + ") - Triage " + nivelTriage + " - " + horaLlegada;
    }
}
