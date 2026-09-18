import java.time.LocalTime;
import java.util.List;

public class Pruebas {

    private static SalaUrgencias salaConTres() {
        SalaUrgencias sala = new SalaUrgencias();
        sala.registrarPaciente(new Paciente("101", "Ana Gómez", 3, LocalTime.of(8, 30)));
        sala.registrarPaciente(new Paciente("102", "Bernardo Silva", 1, LocalTime.of(8, 35)));
        sala.registrarPaciente(new Paciente("103", "Camila Torres", 3, LocalTime.of(8, 40)));
        return sala;
    }

    public static void main(String[] args) {
        Prueba.igual("una sala nueva está vacía", 0, () -> new SalaUrgencias().cantidadEnEspera());
        Prueba.igual("después de registrar 3 pacientes hay 3 en espera", 3, () -> salaConTres().cantidadEnEspera());
        Prueba.igual("pacientesEnEspera devuelve los 3", 3, () -> salaConTres().pacientesEnEspera().size());
        Prueba.igual("en el orden en que llegaron", "Ana Gómez",
                () -> salaConTres().pacientesEnEspera().get(0).getNombre());

        Prueba.lanza("registrar null lanza IllegalArgumentException", IllegalArgumentException.class,
                () -> new SalaUrgencias().registrarPaciente(null));
        Prueba.igual("y no deja la sala con basura adentro", 0, () -> {
            SalaUrgencias sala = new SalaUrgencias();
            try {
                sala.registrarPaciente(null);
            } catch (IllegalArgumentException e) {
                // esperado
            }
            return sala.cantidadEnEspera();
        });

        Prueba.igual("agregar a la lista devuelta NO mete un paciente a la sala", 3, () -> {
            SalaUrgencias sala = salaConTres();
            List<Paciente> vista = sala.pacientesEnEspera();
            try {
                vista.add(new Paciente("999", "Colado", 5, LocalTime.of(9, 0)));
            } catch (UnsupportedOperationException e) {
                // perfecto: es una vista de solo lectura
            }
            return sala.cantidadEnEspera();
        });
        Prueba.igual("vaciar la lista devuelta NO vacía la sala", 3, () -> {
            SalaUrgencias sala = salaConTres();
            try {
                sala.pacientesEnEspera().clear();
            } catch (UnsupportedOperationException e) {
                // también perfecto
            }
            return sala.cantidadEnEspera();
        });
        Prueba.resumen();
    }
}
