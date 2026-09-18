public class Pruebas {
    public static void main(String[] args) {
        Prueba.igual("el detalle tiene el formato pedido", "Curso: Java básico (40 h)",
                () -> new CursoVirtual("Java básico", 20000.0, 40).getDetalle());
        Prueba.igual("con otro curso", "Curso: Excel (12 h)",
                () -> new CursoVirtual("Excel", 15000.0, 12).getDetalle());
        Prueba.igualDecimal("un curso corto no tiene descuento (15.000 x 12)", 180000.0,
                () -> new CursoVirtual("Excel", 15000.0, 12).calcularImporte());
        Prueba.igualDecimal("39 horas todavía no tiene descuento", 390000.0,
                () -> new CursoVirtual("Redes", 10000.0, 39).calcularImporte());
        Prueba.igualDecimal("con 40 horas justas se descuenta el 10%", 720000.0,
                () -> new CursoVirtual("Java básico", 20000.0, 40).calcularImporte());
        Prueba.igualDecimal("con más de 40 horas también", 900000.0,
                () -> new CursoVirtual("Bases de datos", 10000.0, 100).calcularImporte());

        Prueba.igual("el Carrito lo acepta sin cambiarle una línea", 3, () -> {
            Carrito carrito = new Carrito();
            carrito.agregar(new ServicioDigital("Hosting web", 45000.0, 6));
            carrito.agregar(new CursoVirtual("Java básico", 20000.0, 40));
            carrito.agregar(new ProductoFisico("Router WiFi", 180000.0, 0.8));
            return carrito.cantidad();
        });
        Prueba.igualDecimal("y el total mezcla las tres fórmulas", 1180000.0, () -> {
            Carrito carrito = new Carrito();
            carrito.agregar(new ServicioDigital("Hosting web", 45000.0, 6));   // 270.000
            carrito.agregar(new CursoVirtual("Java básico", 20000.0, 40));     // 720.000
            carrito.agregar(new ProductoFisico("Router WiFi", 180000.0, 0.8)); // 190.000
            return carrito.total();
        });
        Prueba.igual("masCaro también funciona con el tipo nuevo", "Curso: Java básico (40 h)", () -> {
            Carrito carrito = new Carrito();
            carrito.agregar(new ServicioDigital("Hosting web", 45000.0, 6));
            carrito.agregar(new CursoVirtual("Java básico", 20000.0, 40));
            return carrito.masCaro().getDetalle();
        });
        Prueba.resumen();
    }
}
