public class Pruebas {
    public static void main(String[] args) {
        Prueba.igual("el detalle lleva la descripción y el peso", "Router WiFi (0.8 kg)",
                () -> new ProductoFisico("Router WiFi", 180000.0, 0.8).getDetalle());
        Prueba.igual("con otro producto", "Impresora láser (7.5 kg)",
                () -> new ProductoFisico("Impresora láser", 650000.0, 7.5).getDetalle());
        Prueba.igualDecimal("liviano (0.8 kg): precio + 10.000 de envío", 190000.0,
                () -> new ProductoFisico("Router WiFi", 180000.0, 0.8).calcularImporte());
        Prueba.igualDecimal("pesado (7.5 kg): precio + 25.000 de envío", 675000.0,
                () -> new ProductoFisico("Impresora láser", 650000.0, 7.5).calcularImporte());
        Prueba.igualDecimal("exactamente 1 kg todavía es liviano", 60000.0,
                () -> new ProductoFisico("Libro", 50000.0, 1.0).calcularImporte());
        Prueba.igualDecimal("1.1 kg ya es pesado", 75000.0,
                () -> new ProductoFisico("Diccionario", 50000.0, 1.1).calcularImporte());
        Prueba.igualDecimal("funciona a través de una variable Facturable", 190000.0, () -> {
            Facturable f = new ProductoFisico("Router WiFi", 180000.0, 0.8);
            return f.calcularImporte();
        });
        Prueba.resumen();
    }
}
