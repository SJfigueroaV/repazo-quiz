import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pruebas {

    /** Arma una lista de cuentas: "A" activa, "a" inactiva. */
    private static List<Cuenta> cuentas(String... codigos) {
        List<Cuenta> lista = new ArrayList<>();
        for (String c : codigos) {
            lista.add(new Cuenta(c.toUpperCase(), !c.equals(c.toLowerCase())));
        }
        return lista;
    }

    private static List<String> codigos(List<Cuenta> cuentas) {
        List<String> codigos = new ArrayList<>();
        for (Cuenta c : cuentas) codigos.add(c.getCodigo());
        return codigos;
    }

    public static void main(String[] args) {
        Prueba.igual("con una inactiva en el medio, la quita",
                Arrays.asList("CTA-01", "CTA-03"), () -> {
                    List<Cuenta> lista = cuentas("CTA-01", "cta-02", "CTA-03");
                    Depuracion.depurarInactivas(lista);
                    return codigos(lista);
                });
        Prueba.igual("y devuelve su código",
                Arrays.asList("CTA-02"), () -> Depuracion.depurarInactivas(cuentas("CTA-01", "cta-02", "CTA-03")));

        Prueba.igual("dos inactivas seguidas: quita las dos",
                Arrays.asList("CTA-01", "CTA-04"), () -> {
                    List<Cuenta> lista = cuentas("CTA-01", "cta-02", "cta-03", "CTA-04");
                    Depuracion.depurarInactivas(lista);
                    return codigos(lista);
                });
        Prueba.igual("la inactiva en la penúltima posición también se va (y la última se revisa)",
                Arrays.asList("CTA-01"), () -> {
                    List<Cuenta> lista = cuentas("CTA-01", "cta-02", "cta-03");
                    Depuracion.depurarInactivas(lista);
                    return codigos(lista);
                });
        Prueba.igual("los códigos eliminados salen en el orden original",
                Arrays.asList("CTA-01", "CTA-03", "CTA-05"),
                () -> Depuracion.depurarInactivas(cuentas("cta-01", "CTA-02", "cta-03", "CTA-04", "cta-05")));

        Prueba.igual("si todas son inactivas, la lista queda vacía", 0, () -> {
            List<Cuenta> lista = cuentas("cta-01", "cta-02", "cta-03");
            Depuracion.depurarInactivas(lista);
            return lista.size();
        });

        Prueba.igual("si ninguna es inactiva, devuelve una lista vacía (no null)",
                new ArrayList<String>(), () -> Depuracion.depurarInactivas(cuentas("CTA-01", "CTA-02")));
        Prueba.igual("y la lista queda como estaba",
                Arrays.asList("CTA-01", "CTA-02"), () -> {
                    List<Cuenta> lista = cuentas("CTA-01", "CTA-02");
                    Depuracion.depurarInactivas(lista);
                    return codigos(lista);
                });
        Prueba.igual("con una lista vacía devuelve una lista vacía",
                new ArrayList<String>(), () -> Depuracion.depurarInactivas(new ArrayList<>()));
        Prueba.resumen();
    }
}
