import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Pruebas {

    public static void main(String[] args) {
        // Las pruebas fijan el formato colombiano (punto de miles, coma decimal)
        // para que den lo mismo en cualquier computador. Tú no pasas ningún Locale.
        Locale.setDefault(Locale.forLanguageTag("es-CO"));

        Facturable hosting = new ServicioDigital("Hosting web", 45000.0, 6);
        Facturable router = new ProductoFisico("Router WiFi", 180000.0, 0.8);
        Facturable impresora = new ProductoFisico("Impresora láser", 650000.0, 7.5);

        Prueba.igual("línea de un servicio",
                "Hosting web [6 meses]          | $    270.000,00", () -> Factura.linea(hosting));
        Prueba.igual("línea de un producto",
                "Router WiFi (0.8 kg)           | $    190.000,00", () -> Factura.linea(router));
        Prueba.igual("los millones también llevan separador",
                "Licencia anual [12 meses]      | $  1.440.000,00",
                () -> Factura.linea(new ServicioDigital("Licencia anual", 120000.0, 12)));
        Prueba.igual("los centavos se redondean a 2 decimales",
                "Dominio [1 mes]                | $      9.999,99",
                () -> Factura.linea(new ServicioDigital("Dominio", 9999.989, 1)));
        Prueba.igual("todas las líneas miden 48 caracteres", 48, () -> Factura.linea(impresora).length());

        Prueba.igual("liquidación de dos ítems",
                "Hosting web [6 meses]          | $    270.000,00\n"
              + "Router WiFi (0.8 kg)           | $    190.000,00\n"
              + "------------------------------------------------\n"
              + "TOTAL                          | $    460.000,00",
                () -> {
                    List<Facturable> items = new ArrayList<>();
                    items.add(hosting);
                    items.add(router);
                    return Factura.liquidacion(items);
                });
        Prueba.igual("liquidación de tres ítems",
                "Hosting web [6 meses]          | $    270.000,00\n"
              + "Router WiFi (0.8 kg)           | $    190.000,00\n"
              + "Impresora láser (7.5 kg)       | $    675.000,00\n"
              + "------------------------------------------------\n"
              + "TOTAL                          | $  1.135.000,00",
                () -> Factura.liquidacion(List.of(hosting, router, impresora)));
        Prueba.igual("sin ítems: solo los guiones y el total en cero",
                "------------------------------------------------\n"
              + "TOTAL                          | $          0,00",
                () -> Factura.liquidacion(new ArrayList<>()));
        Prueba.resumen();
    }
}
