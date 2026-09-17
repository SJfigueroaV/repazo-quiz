public class Pruebas {

    private static Agenda agendaConTres() {
        Agenda agenda = new Agenda();
        agenda.agregar(new Contacto("Ana", "300-111"));
        agenda.agregar(new Contacto("Beto", "300-222"));
        agenda.agregar(new Contacto("Carlos", "300-333"));
        return agenda;
    }

    public static void main(String[] args) {
        Prueba.esVerdadero("agregar devuelve true cuando hay espacio",
                () -> new Agenda().agregar(new Contacto("Ana", "300-111")));
        Prueba.igual("una agenda nueva tiene 0 contactos", 0, () -> new Agenda().cantidad());
        Prueba.igual("después de agregar 3 contactos la cantidad es 3", 3, () -> agendaConTres().cantidad());

        Prueba.igual("busca a Beto y devuelve su teléfono", "300-222",
                () -> agendaConTres().buscar("Beto").getTelefono());
        Prueba.esNulo("buscar un nombre que no está devuelve null",
                () -> agendaConTres().buscar("Zoe"));

        Prueba.igual("los contactos quedan en el orden en que se agregaron", "Ana",
                () -> agendaConTres().contactoEn(0).getNombre());
        Prueba.esNulo("contactoEn de una posición todavía vacía devuelve null",
                () -> agendaConTres().contactoEn(7));
        Prueba.esNulo("contactoEn de una posición inválida devuelve null y no se cae",
                () -> agendaConTres().contactoEn(-1));

        Prueba.esVerdadero("eliminar un contacto existente devuelve true",
                () -> agendaConTres().eliminar("Beto"));
        Prueba.esFalso("eliminar un contacto que no existe devuelve false",
                () -> agendaConTres().eliminar("Zoe"));
        Prueba.igual("al eliminar, la cantidad baja a 2", 2, () -> {
            Agenda agenda = agendaConTres();
            agenda.eliminar("Beto");
            return agenda.cantidad();
        });
        Prueba.esNulo("el contacto eliminado ya no se encuentra", () -> {
            Agenda agenda = agendaConTres();
            agenda.eliminar("Beto");
            return agenda.buscar("Beto");
        });
        Prueba.igual("al eliminar el del medio, Carlos se corre a la posición 1", "Carlos", () -> {
            Agenda agenda = agendaConTres();
            agenda.eliminar("Beto");
            return agenda.contactoEn(1).getNombre();
        });
        Prueba.esNulo("después de eliminar, la última posición queda limpia", () -> {
            Agenda agenda = agendaConTres();
            agenda.eliminar("Beto");
            return agenda.contactoEn(2);
        });

        Prueba.esFalso("agregar el contacto 11 devuelve false (la agenda solo tiene 10 casillas)", () -> {
            Agenda agenda = new Agenda();
            for (int i = 1; i <= 10; i++) {
                agenda.agregar(new Contacto("Contacto " + i, "300-000"));
            }
            return agenda.agregar(new Contacto("El que no cabe", "300-999"));
        });
        Prueba.igual("con la agenda llena la cantidad sigue siendo 10", 10, () -> {
            Agenda agenda = new Agenda();
            for (int i = 1; i <= 12; i++) {
                agenda.agregar(new Contacto("Contacto " + i, "300-000"));
            }
            return agenda.cantidad();
        });
        Prueba.resumen();
    }
}
