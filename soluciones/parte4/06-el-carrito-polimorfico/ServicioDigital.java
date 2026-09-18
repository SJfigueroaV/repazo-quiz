public class ServicioDigital implements Facturable {
    private String nombre;
    private double costoMensual;
    private int meses;

    public ServicioDigital(String nombre, double costoMensual, int meses) {
        this.nombre = nombre;
        this.costoMensual = costoMensual;
        this.meses = meses;
    }

    @Override
    public String getDetalle() {
        return nombre + " [" + meses + (meses == 1 ? " mes]" : " meses]");
    }

    @Override
    public double calcularImporte() {
        return costoMensual * meses;
    }
}
