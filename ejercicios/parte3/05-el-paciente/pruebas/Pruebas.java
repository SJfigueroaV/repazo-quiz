import java.time.LocalTime;

public class Pruebas {
    public static void main(String[] args) {
        Paciente ana = new Paciente("101", "Ana Gómez", 3, LocalTime.of(8, 30));

        Prueba.igual("guarda la cédula", "101", () -> ana.getCedula());
        Prueba.igual("guarda el nombre", "Ana Gómez", () -> ana.getNombre());
        Prueba.igual("guarda el nivel de triage", 3, () -> ana.getNivelTriage());
        Prueba.igual("guarda la hora de llegada", LocalTime.of(8, 30), () -> ana.getHoraLlegada());
        Prueba.igual("el toString tiene el formato pedido", "Ana Gómez (C.C. 101) - Triage 3 - 08:30",
                () -> ana.toString());

        Prueba.igual("acepta el triage 1", 1,
                () -> new Paciente("102", "Beto", 1, LocalTime.of(9, 0)).getNivelTriage());
        Prueba.igual("acepta el triage 5", 5,
                () -> new Paciente("103", "Carlos", 5, LocalTime.of(9, 0)).getNivelTriage());

        Prueba.lanza("el triage 0 lanza IllegalArgumentException", IllegalArgumentException.class,
                () -> new Paciente("104", "Diana", 0, LocalTime.of(9, 0)));
        Prueba.lanza("el triage 6 lanza IllegalArgumentException", IllegalArgumentException.class,
                () -> new Paciente("105", "Elena", 6, LocalTime.of(9, 0)));
        Prueba.lanza("un triage negativo también", IllegalArgumentException.class,
                () -> new Paciente("106", "Felipe", -2, LocalTime.of(9, 0)));
        Prueba.resumen();
    }
}
