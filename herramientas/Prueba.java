import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Mini librería de pruebas del curso. Cada comprobación recibe el valor
 * esperado y un bloque de código que produce el valor obtenido, de modo que
 * si tu código lanza una excepción la prueba la reporta en vez de reventar.
 */
public class Prueba {
    private static final boolean COLOR = System.getenv("NO_COLOR") == null;
    private static final String ESC = "\033[";
    private static final String VERDE = COLOR ? ESC + "32m" : "";
    private static final String ROJO = COLOR ? ESC + "31m" : "";
    private static final String GRIS = COLOR ? ESC + "90m" : "";
    private static final String FIN = COLOR ? ESC + "0m" : "";

    private static int pasadas = 0;
    private static int total = 0;

    public static void igual(String descripcion, Object esperado, Supplier<?> obtenido) {
        total++;
        Object valor;
        try {
            valor = obtenido.get();
        } catch (Throwable t) {
            fallo(descripcion, texto(esperado), "lanzó " + t.getClass().getSimpleName()
                    + (t.getMessage() == null ? "" : ": " + t.getMessage()));
            return;
        }
        if (sonIguales(esperado, valor)) {
            exito(descripcion);
        } else {
            fallo(descripcion, texto(esperado), texto(valor));
        }
    }

    public static void igualDecimal(String descripcion, double esperado, Supplier<Double> obtenido) {
        total++;
        Double valor;
        try {
            valor = obtenido.get();
        } catch (Throwable t) {
            fallo(descripcion, String.valueOf(esperado), "lanzó " + t.getClass().getSimpleName());
            return;
        }
        if (valor != null && Math.abs(esperado - valor) < 0.0001) {
            exito(descripcion);
        } else {
            fallo(descripcion, String.valueOf(esperado), String.valueOf(valor));
        }
    }

    public static void esVerdadero(String descripcion, Supplier<Boolean> obtenido) {
        igual(descripcion, true, obtenido);
    }

    public static void esFalso(String descripcion, Supplier<Boolean> obtenido) {
        igual(descripcion, false, obtenido);
    }

    public static void esNulo(String descripcion, Supplier<?> obtenido) {
        igual(descripcion, null, obtenido);
    }

    /** Ejecuta la acción capturando lo que imprime y lo compara con el texto esperado. */
    public static void salida(String descripcion, String esperada, Runnable accion) {
        total++;
        PrintStream original = System.out;
        ByteArrayOutputStream capturado = new ByteArrayOutputStream();
        String impreso;
        try {
            System.setOut(new PrintStream(capturado, true, "UTF-8"));
            accion.run();
            impreso = capturado.toString("UTF-8");
        } catch (Throwable t) {
            System.setOut(original);
            fallo(descripcion, normalizar(esperada), "lanzó " + t.getClass().getSimpleName());
            return;
        } finally {
            System.setOut(original);
        }
        if (normalizar(impreso).equals(normalizar(esperada))) {
            exito(descripcion);
        } else {
            fallo(descripcion, normalizar(esperada), normalizar(impreso));
        }
    }

    /** Imprime el resultado final y termina con código de salida 0 (todo bien) o 1. */
    public static void resumen() {
        System.out.println();
        if (pasadas == total) {
            System.out.println("  " + VERDE + pasadas + "/" + total + " pruebas — ¡ejercicio resuelto!" + FIN);
            System.exit(0);
        } else {
            System.out.println("  " + ROJO + pasadas + "/" + total + " pruebas" + FIN
                    + GRIS + " — revisa los ✘ y vuelve a intentar" + FIN);
            System.exit(1);
        }
    }

    private static void exito(String descripcion) {
        pasadas++;
        System.out.println("  " + VERDE + "✔" + FIN + " " + descripcion);
    }

    private static void fallo(String descripcion, String esperado, String obtenido) {
        System.out.println("  " + ROJO + "✘" + FIN + " " + descripcion);
        System.out.println("      " + GRIS + "esperado:" + FIN + " " + esperado);
        System.out.println("      " + GRIS + "obtenido:" + FIN + " " + obtenido);
    }

    private static boolean sonIguales(Object esperado, Object obtenido) {
        if (esperado instanceof Object[] && obtenido instanceof Object[]) {
            return Arrays.deepEquals((Object[]) esperado, (Object[]) obtenido);
        }
        return Objects.equals(esperado, obtenido);
    }

    private static String texto(Object valor) {
        if (valor == null) return "null";
        if (valor instanceof String) return "\"" + valor + "\"";
        if (valor instanceof Object[]) return Arrays.deepToString((Object[]) valor);
        return String.valueOf(valor);
    }

    /** Quita espacios al final de cada línea y líneas vacías sobrantes. */
    private static String normalizar(String texto) {
        if (texto == null) return "";
        String[] lineas = texto.replace("\r\n", "\n").split("\n", -1);
        StringBuilder sb = new StringBuilder();
        for (String linea : lineas) {
            sb.append(linea.replaceAll("\\s+$", "")).append('\n');
        }
        return sb.toString().replaceAll("\n+$", "");
    }
}
