import java.time.LocalTime;
import java.util.List;

public class Pruebas {

    private static SalaUrgencias sala() {
        SalaUrgencias sala = new SalaUrgencias();
        sala.registrarPaciente(new Paciente("101", "Ana Gómez", 3, LocalTime.of(8, 30)));
        sala.registrarPaciente(new Paciente("102", "Bernardo Silva", 1, LocalTime.of(8, 35)));
        sala.registrarPaciente(new Paciente("103", "Camila Torres", 5, LocalTime.of(8, 40)));
        sala.registrarPaciente(new Paciente("104", "Daniel Ruiz", 1, LocalTime.of(8, 20)));
        return sala;
    }

    public static void main(String[] args) {
        Prueba.igual("atenderTodos devuelve a los 4 pacientes", 4, () -> sala().atenderTodos().size());
        Prueba.igual("el primero en pasar es el crítico que llegó más temprano", "Daniel Ruiz",
                () -> sala().atenderTodos().get(0).getNombre());
        Prueba.igual("el segundo es el otro triage 1", "Bernardo Silva",
                () -> sala().atenderTodos().get(1).getNombre());
        Prueba.igual("el tercero es el triage 3", "Ana Gómez", () -> sala().atenderTodos().get(2).getNombre());
        Prueba.igual("el último es el triage 5", "Camila Torres", () -> sala().atenderTodos().get(3).getNombre());
        Prueba.igual("la sala queda vacía", 0, () -> {
            SalaUrgencias sala = sala();
            sala.atenderTodos();
            return sala.cantidadEnEspera();
        });
        Prueba.igual("con la sala vacía devuelve una lista vacía", 0,
                () -> new SalaUrgencias().atenderTodos().size());

        Prueba.igualDecimal("el promedio de triage de 3, 1, 5 y 1 es 2.5", 2.5, () -> sala().promedioTriage());
        Prueba.igualDecimal("con la sala vacía el promedio es 0.0", 0.0,
                () -> new SalaUrgencias().promedioTriage());
        Prueba.igualDecimal("tras atender a los dos críticos el promedio sube a 4.0", 4.0, () -> {
            SalaUrgencias sala = sala();
            sala.atenderSiguiente();
            sala.atenderSiguiente();
            return sala.promedioTriage();
        });
        Prueba.resumen();
    }
}
