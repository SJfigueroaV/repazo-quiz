import java.time.LocalTime;

public class Pruebas {

    private static SalaUrgencias sala() {
        SalaUrgencias sala = new SalaUrgencias();
        sala.registrarPaciente(new Paciente("101", "Ana Gómez", 3, LocalTime.of(8, 30)));
        sala.registrarPaciente(new Paciente("102", "Bernardo Silva", 1, LocalTime.of(8, 35)));
        sala.registrarPaciente(new Paciente("103", "Camila Torres", 3, LocalTime.of(8, 40)));
        return sala;
    }

    public static void main(String[] args) {
        Prueba.igual("hay 2 pacientes con triage 3", 2, () -> sala().filtrarPorTriage(3).size());
        Prueba.igual("el primero de ellos es Ana", "Ana Gómez", () -> sala().filtrarPorTriage(3).get(0).getNombre());
        Prueba.igual("conserva el orden de llegada", "Camila Torres",
                () -> sala().filtrarPorTriage(3).get(1).getNombre());
        Prueba.igual("hay 1 paciente con triage 1", 1, () -> sala().filtrarPorTriage(1).size());
        Prueba.igual("nadie tiene triage 5: lista vacía", 0, () -> sala().filtrarPorTriage(5).size());
        Prueba.igual("un nivel que no existe devuelve lista vacía, no null", 0, () -> sala().filtrarPorTriage(9).size());
        Prueba.igual("filtrar en una sala vacía devuelve lista vacía", 0,
                () -> new SalaUrgencias().filtrarPorTriage(1).size());
        Prueba.igual("filtrar NO saca a los pacientes de la sala", 3, () -> {
            SalaUrgencias sala = sala();
            sala.filtrarPorTriage(3);
            return sala.cantidadEnEspera();
        });

        Prueba.esVerdadero("hayEmergenciaVital es true si alguien tiene triage 1", () -> sala().hayEmergenciaVital());
        Prueba.esFalso("es false si nadie lo tiene", () -> {
            SalaUrgencias sala = new SalaUrgencias();
            sala.registrarPaciente(new Paciente("201", "Leve", 4, LocalTime.of(9, 0)));
            return sala.hayEmergenciaVital();
        });
        Prueba.esFalso("con la sala vacía es false", () -> new SalaUrgencias().hayEmergenciaVital());
        Prueba.esFalso("tras atender al crítico deja de haber emergencia vital", () -> {
            SalaUrgencias sala = sala();
            sala.atenderSiguiente();
            return sala.hayEmergenciaVital();
        });
        Prueba.resumen();
    }
}
