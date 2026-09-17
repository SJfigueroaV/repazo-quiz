public class Pruebas {
    public static void main(String[] args) {
        Persona[] grupo = new Persona[4];
        grupo[1] = new Persona("Ana", 20);
        grupo[2] = new Persona("Carlos", 22);

        Prueba.igual("encuentra a Carlos", "Carlos",
                () -> Buscador.buscarPorNombre(grupo, "Carlos").getNombre());
        Prueba.igual("devuelve la persona completa, no solo el nombre", 20,
                () -> Buscador.buscarPorNombre(grupo, "Ana").getEdad());
        Prueba.esNulo("devuelve null si el nombre no está en el arreglo",
                () -> Buscador.buscarPorNombre(grupo, "Zoe"));
        Prueba.esNulo("devuelve null si el arreglo está vacío",
                () -> Buscador.buscarPorNombre(new Persona[3], "Ana"));
        Prueba.igual("compara el contenido del texto, no las referencias", "Ana",
                () -> Buscador.buscarPorNombre(grupo, new String("Ana")).getNombre());
        Prueba.resumen();
    }
}
