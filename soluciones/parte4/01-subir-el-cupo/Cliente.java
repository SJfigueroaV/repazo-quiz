public class Cliente {
    private String cedula;
    private String nombre;
    private double cupo;

    public Cliente(String cedula, String nombre, double cupo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.cupo = cupo;
    }

    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public double getCupo() { return cupo; }
    public void setCupo(double cupo) { this.cupo = cupo; }

    @Override
    public String toString() {
        return nombre + " (" + cedula + "): " + cupo;
    }
}
