public class Estudiante {
    private String nombre;
    private double notaFinal;

    public Estudiante(String nombre, double notaFinal) {
        this.nombre = nombre;
        this.notaFinal = notaFinal;
    }

    public String getNombre() { return nombre; }
    public double getNotaFinal() { return notaFinal; }

    @Override
    public String toString() {
        return nombre + ": " + notaFinal;
    }
}
