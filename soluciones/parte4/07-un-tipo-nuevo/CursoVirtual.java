public class CursoVirtual implements Facturable {
    private String nombre;
    private double precioHora;
    private int horas;

    public CursoVirtual(String nombre, double precioHora, int horas) {
        this.nombre = nombre;
        this.precioHora = precioHora;
        this.horas = horas;
    }

    @Override
    public String getDetalle() {
        return "Curso: " + nombre + " (" + horas + " h)";
    }

    @Override
    public double calcularImporte() {
        double bruto = precioHora * horas;
        if (horas >= 40) {
            return bruto * 0.9;
        }
        return bruto;
    }
}
