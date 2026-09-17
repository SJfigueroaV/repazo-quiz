public class Pruebas {

    private static Agenda agendaCon(int cuantos) {
        Agenda agenda = new Agenda();
        for (int i = 1; i <= cuantos; i++) {
            agenda.agregar(new Contacto("Contacto " + i, "300-" + i));
        }
        return agenda;
    }

    public static void main(String[] args) {
        Prueba.igual("una agenda nueva tiene capacidad 5", 5, () -> new Agenda().capacidad());
        Prueba.igual("con 5 contactos todavía no necesita ampliarse", 5, () -> agendaCon(5).capacidad());
        Prueba.igual("al agregar el sexto contacto la capacidad se duplica a 10", 10, () -> agendaCon(6).capacidad());
        Prueba.igual("al pasar de 10 la capacidad vuelve a duplicarse a 20", 20, () -> agendaCon(12).capacidad());

        Prueba.esVerdadero("agregar nunca devuelve false, aunque la agenda esté llena", () -> {
            Agenda agenda = agendaCon(5);
            return agenda.agregar(new Contacto("El sexto", "300-666"));
        });

        Prueba.igual("guarda los 12 contactos", 12, () -> agendaCon(12).cantidad());
        Prueba.igual("al ampliar no se pierde el primer contacto", "Contacto 1",
                () -> agendaCon(12).contactoEn(0).getNombre());
        Prueba.igual("al ampliar no se pierde el contacto del borde", "Contacto 5",
                () -> agendaCon(12).contactoEn(4).getNombre());
        Prueba.igual("el último contacto agregado también está", "Contacto 12",
                () -> agendaCon(12).contactoEn(11).getNombre());
        Prueba.igual("se puede buscar un contacto guardado después de ampliar", "300-9",
                () -> agendaCon(12).buscar("Contacto 9").getTelefono());
        Prueba.resumen();
    }
}
