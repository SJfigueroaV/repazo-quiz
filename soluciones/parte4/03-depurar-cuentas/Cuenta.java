public class Cuenta {
    private String codigo;
    private boolean activa;

    public Cuenta(String codigo, boolean activa) {
        this.codigo = codigo;
        this.activa = activa;
    }

    public String getCodigo() { return codigo; }
    public boolean isActiva() { return activa; }

    @Override
    public String toString() {
        return codigo + (activa ? "" : " (inactiva)");
    }
}
