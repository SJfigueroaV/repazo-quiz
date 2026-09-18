import java.util.List;

public class Factura {

    public static String linea(Facturable item) {
        return String.format("%-30s | $%,14.2f", item.getDetalle(), item.calcularImporte());
    }

    public static String liquidacion(List<Facturable> items) {
        StringBuilder sb = new StringBuilder();
        double total = 0;
        for (Facturable item : items) {
            sb.append(linea(item)).append("\n");
            total += item.calcularImporte();
        }
        sb.append("-".repeat(48)).append("\n");
        sb.append(String.format("%-30s | $%,14.2f", "TOTAL", total));
        return sb.toString();
    }
}
