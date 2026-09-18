public class ServicioDigital implements Facturable {
    private String nombre;
    private double costoMensual;
    private int meses;

    public ServicioDigital(String nombre, double costoMensual, int meses) {
        this.nombre = nombre;
        this.costoMensual = costoMensual;
        this.meses = meses;
    }

    /**
     * El nombre y la duración entre corchetes: "Hosting web [6 meses]".
     * Con un solo mes va en singular: "Dominio [1 mes]".
     */
    @Override
    public String getDetalle() {
        // TODO
        return "";
    }

    /** El costo mensual por la cantidad de meses. */
    @Override
    public double calcularImporte() {
        // TODO
        return 0;
    }
}
