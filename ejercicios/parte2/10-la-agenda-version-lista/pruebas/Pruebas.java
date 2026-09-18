public class Pruebas {

    private static Agenda agendaConTres() {
        Agenda agenda = new Agenda();
        agenda.agregar(new Contacto("Ana", "300-111"));
        agenda.agregar(new Contacto("Beto", "300-222"));
        agenda.agregar(new Contacto("Carlos", "300-333"));
        return agenda;
    }

    public static void main(String[] args) {
        Prueba.esVerdadero("agregar devuelve true", () -> new Agenda().agregar(new Contacto("Ana", "300-111")));
        Prueba.igual("una agenda nueva tiene 0 contactos", 0, () -> new Agenda().cantidad());
        Prueba.igual("después de agregar 3 contactos la cantidad es 3", 3, () -> agendaConTres().cantidad());

        Prueba.igual("busca a Beto y devuelve su teléfono", "300-222",
                () -> agendaConTres().buscar("Beto").getTelefono());
        Prueba.esNulo("buscar un nombre que no está devuelve null", () -> agendaConTres().buscar("Zoe"));

        Prueba.igual("los contactos quedan en el orden en que se agregaron", "Ana",
                () -> agendaConTres().contactoEn(0).getNombre());
        Prueba.esNulo("contactoEn de una posición vacía devuelve null", () -> agendaConTres().contactoEn(7));
        Prueba.esNulo("contactoEn de una posición inválida devuelve null y no lanza excepción",
                () -> agendaConTres().contactoEn(-1));

        Prueba.esVerdadero("eliminar un contacto existente devuelve true", () -> agendaConTres().eliminar("Beto"));
        Prueba.esFalso("eliminar un contacto que no existe devuelve false", () -> agendaConTres().eliminar("Zoe"));
        Prueba.igual("al eliminar, la cantidad baja a 2", 2, () -> {
            Agenda agenda = agendaConTres();
            agenda.eliminar("Beto");
            return agenda.cantidad();
        });
        Prueba.igual("la lista se compacta sola: Carlos queda en la posición 1", "Carlos", () -> {
            Agenda agenda = agendaConTres();
            agenda.eliminar("Beto");
            return agenda.contactoEn(1).getNombre();
        });
        Prueba.igual("ya no hay límite de 10: caben 200 contactos", 200, () -> {
            Agenda agenda = new Agenda();
            for (int i = 1; i <= 200; i++) {
                agenda.agregar(new Contacto("Contacto " + i, "300-" + i));
            }
            return agenda.cantidad();
        });
        Prueba.igual("y se pueden buscar todos", "300-150", () -> {
            Agenda agenda = new Agenda();
            for (int i = 1; i <= 200; i++) {
                agenda.agregar(new Contacto("Contacto " + i, "300-" + i));
            }
            return agenda.buscar("Contacto 150").getTelefono();
        });
        Prueba.resumen();
    }
}
