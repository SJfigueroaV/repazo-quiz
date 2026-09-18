public class Empleado {
    private String nombre;
    private boolean despedido;

    public Empleado(String nombre, boolean despedido) {
        this.nombre = nombre;
        this.despedido = despedido;
    }

    public String getNombre() { return nombre; }
    public boolean isDespedido() { return despedido; }

    @Override
    public String toString() {
        return nombre + (despedido ? " (despedido)" : "");
    }
}
