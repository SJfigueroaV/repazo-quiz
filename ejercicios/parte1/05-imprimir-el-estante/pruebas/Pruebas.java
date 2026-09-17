public class Pruebas {
    public static void main(String[] args) {
        Libro[] estante = new Libro[3];
        estante[0] = new Libro("Effective Java", "Bloch");
        estante[2] = new Libro("Clean Code", "Martin");

        Prueba.salida("imprime el título de los libros y el aviso de las casillas vacías",
                "[0] Effective Java\n[1] Casilla vacía\n[2] Clean Code",
                () -> Estante.imprimir(estante));

        Prueba.salida("un estante recién creado imprime solo casillas vacías",
                "[0] Casilla vacía\n[1] Casilla vacía",
                () -> Estante.imprimir(new Libro[2]));

        Prueba.salida("un estante de tamaño 0 no imprime nada",
                "",
                () -> Estante.imprimir(new Libro[0]));
        Prueba.resumen();
    }
}
