public class Pruebas {
    public static void main(String[] args) {
        Persona[] conHuecos = new Persona[4];
        conHuecos[0] = new Persona("Ana", 20);
        conHuecos[2] = new Persona("Carlos", 22);

        Persona[] alFinal = new Persona[2];
        alFinal[1] = new Persona("Beto", 31);

        Persona[] unaSola = { new Persona("Ana", 20) };

        Prueba.igual("{Ana, null, Carlos, null} devuelve \"Ana, Carlos\"", "Ana, Carlos", () -> Nombres.nombres(conHuecos));
        Prueba.igual("un arreglo con una sola persona no lleva coma", "Ana", () -> Nombres.nombres(unaSola));
        Prueba.igual("{null, Beto} devuelve \"Beto\" (sin coma al inicio)", "Beto", () -> Nombres.nombres(alFinal));
        Prueba.igual("un arreglo sin personas devuelve una cadena vacía", "", () -> Nombres.nombres(new Persona[3]));
        Prueba.resumen();
    }
}
