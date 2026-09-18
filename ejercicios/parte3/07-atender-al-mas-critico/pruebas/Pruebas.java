import java.time.LocalTime;

public class Pruebas {

    private static SalaUrgencias sala() {
        SalaUrgencias sala = new SalaUrgencias();
        sala.registrarPaciente(new Paciente("101", "Ana Gómez", 3, LocalTime.of(8, 30)));
        sala.registrarPaciente(new Paciente("102", "Bernardo Silva", 1, LocalTime.of(8, 35)));
        sala.registrarPaciente(new Paciente("103", "Camila Torres", 3, LocalTime.of(8, 40)));
        sala.registrarPaciente(new Paciente("104", "Daniel Ruiz", 1, LocalTime.of(8, 20)));
        return sala;
    }

    public static void main(String[] args) {
        Prueba.esNulo("con la sala vacía devuelve null", () -> new SalaUrgencias().atenderSiguiente());
        Prueba.igual("con la sala vacía no rompe nada", 0, () -> {
            SalaUrgencias sala = new SalaUrgencias();
            sala.atenderSiguiente();
            return sala.cantidadEnEspera();
        });

        Prueba.igual("atiende primero el triage más crítico, aunque haya llegado después", "Daniel Ruiz",
                () -> sala().atenderSiguiente().getNombre());
        Prueba.igual("el paciente atendido sale de la sala", 3, () -> {
            SalaUrgencias sala = sala();
            sala.atenderSiguiente();
            return sala.cantidadEnEspera();
        });
        Prueba.igual("en el empate de triage 1 atiende al que llegó primero", "Bernardo Silva", () -> {
            SalaUrgencias sala = sala();
            sala.atenderSiguiente();
            return sala.atenderSiguiente().getNombre();
        });
        Prueba.igual("después siguen los de triage 3, el más antiguo primero", "Ana Gómez", () -> {
            SalaUrgencias sala = sala();
            sala.atenderSiguiente();
            sala.atenderSiguiente();
            return sala.atenderSiguiente().getNombre();
        });
        Prueba.igual("y al final queda vacía", 0, () -> {
            SalaUrgencias sala = sala();
            for (int i = 0; i < 4; i++) {
                sala.atenderSiguiente();
            }
            return sala.cantidadEnEspera();
        });
        Prueba.esNulo("atender de más devuelve null en vez de caerse", () -> {
            SalaUrgencias sala = sala();
            for (int i = 0; i < 4; i++) {
                sala.atenderSiguiente();
            }
            return sala.atenderSiguiente();
        });
        Prueba.igual("con un solo paciente lo atiende a él", "Único", () -> {
            SalaUrgencias sala = new SalaUrgencias();
            sala.registrarPaciente(new Paciente("999", "Único", 4, LocalTime.of(10, 0)));
            return sala.atenderSiguiente().getNombre();
        });
        Prueba.resumen();
    }
}
