public class Pruebas {
    public static void main(String[] args) {
        Prueba.igual("el detalle lleva el nombre y los meses", "Hosting web [6 meses]",
                () -> new ServicioDigital("Hosting web", 45000.0, 6).getDetalle());
        Prueba.igual("con un solo mes va en singular", "Dominio [1 mes]",
                () -> new ServicioDigital("Dominio", 60000.0, 1).getDetalle());
        Prueba.igual("con 12 meses", "Licencia antivirus [12 meses]",
                () -> new ServicioDigital("Licencia antivirus", 15000.0, 12).getDetalle());
        Prueba.igualDecimal("el importe es costo mensual por meses (45.000 x 6)", 270000.0,
                () -> new ServicioDigital("Hosting web", 45000.0, 6).calcularImporte());
        Prueba.igualDecimal("con un mes, el importe es el costo mensual", 60000.0,
                () -> new ServicioDigital("Dominio", 60000.0, 1).calcularImporte());
        Prueba.igualDecimal("con 0 meses no se cobra nada", 0.0,
                () -> new ServicioDigital("Prueba gratis", 30000.0, 0).calcularImporte());
        Prueba.igualDecimal("funciona a través de una variable Facturable", 180000.0, () -> {
            Facturable f = new ServicioDigital("Licencia antivirus", 15000.0, 12);
            return f.calcularImporte();
        });
        Prueba.resumen();
    }
}
