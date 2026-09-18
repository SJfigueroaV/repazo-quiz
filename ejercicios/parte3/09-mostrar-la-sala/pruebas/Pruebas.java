import java.time.LocalTime;

public class Pruebas {

    private static SalaUrgencias sala() {
        SalaUrgencias sala = new SalaUrgencias();
        sala.registrarPaciente(new Paciente("101", "Ana Gómez", 3, LocalTime.of(8, 30)));
        sala.registrarPaciente(new Paciente("102", "Bernardo Silva", 1, LocalTime.of(8, 35)));
        return sala;
    }

    public static void main(String[] args) {
        Prueba.salida("imprime el encabezado y una línea por paciente",
                "# | Cédula | Nombre | Triage | Llegada\n"
                + "1 | 101 | Ana Gómez | 3 | 08:30\n"
                + "2 | 102 | Bernardo Silva | 1 | 08:35",
                () -> sala().mostrarSala());

        Prueba.salida("con la sala vacía imprime el aviso",
                "La sala de espera está vacía.",
                () -> new SalaUrgencias().mostrarSala());

        Prueba.salida("con un solo paciente lo numera con el 1",
                "# | Cédula | Nombre | Triage | Llegada\n"
                + "1 | 999 | Único Paciente | 5 | 14:05",
                () -> {
                    SalaUrgencias sala = new SalaUrgencias();
                    sala.registrarPaciente(new Paciente("999", "Único Paciente", 5, LocalTime.of(14, 5)));
                    sala.mostrarSala();
                });
        Prueba.resumen();
    }
}
