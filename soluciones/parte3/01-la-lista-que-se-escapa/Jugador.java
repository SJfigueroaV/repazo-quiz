public class Jugador {
    private String nombre;
    private int goles;

    public Jugador(String nombre, int goles) {
        this.nombre = nombre;
        this.goles = goles;
    }

    public String getNombre() { return nombre; }
    public int getGoles() { return goles; }

    @Override
    public String toString() {
        return nombre + " (" + goles + ")";
    }
}
