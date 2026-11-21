import java.util.List;
import java.util.ArrayList;

void main() {
    IO.println("=== DEMOSTRACION SESION 03: CRUD DE INVENTARIO ===");
    Inventario inv = new Inventario();
    inv.crear("Café en grano Huila (kg)", 25);
    inv.crear("Leche entera (L)", 40);
    inv.crear("Vasos 12oz", 200);

    IO.println("Listado inicial:");
    for (Insumo i : inv.listar()) {
        IO.println("  " + i);
    }

    IO.println("Actualizar vasos a 180: " + inv.actualizar(3, 180));
    IO.println("Buscando insumo 2: " + inv.buscar(2).map(Insumo::toString).orElse("No encontrado"));
    IO.println("Buscando insumo 99: " + inv.buscar(99).map(Insumo::toString).orElse("No encontrado"));
    IO.println("Borrar insumo 1: " + inv.borrar(1));
    IO.println("¿Existe 'Leche entera (L)'? " + inv.existe("Leche entera (L)"));
    IO.println("¿Existe 'Azúcar'? " + inv.existe("Azúcar"));

    IO.println("Listado tras borrado:");
    for (Insumo i : inv.listar()) {
        IO.println("  " + i);
    }

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 06: LISTA DE ESPERA ===");
    List<String> espera = new ArrayList<>();
    espera.add("Rojas (4)");
    espera.add("Gómez (2)");
    espera.add("Pérez (3)");
    IO.println("En espera: " + espera.size());
    IO.println("Sigue: " + espera.getFirst());
    espera.set(1, "Gómez (5)");
    espera.removeIf(n -> n.startsWith("Rojas"));
    IO.println(espera);
    IO.println("¿Pérez? " + espera.contains("Pérez (3)"));

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 07: AGENDA DE RESERVAS ===");
    Agenda agenda = new Agenda();
    agenda.crear("Familia Martínez", 4, "18:30");
    agenda.crear("Carlos Duque", 2, "19:00");
    agenda.crear("Empresa ACME", 8, "18:30");

    IO.println("Reservas registradas:");
    for (Reserva r : agenda.listar()) {
        IO.println("  " + r);
    }

    IO.println("Reservas de las 18:30:");
    for (Reserva r : agenda.deLaHora("18:30")) {
        IO.println("  " + r);
    }

    agenda.cambiarHora(2, "20:00");
    IO.println("Tras cambiar hora de Carlos Duque: " + agenda.buscar(2).get());

    agenda.cancelar(1);
    IO.println("Tras cancelar reserva 1, total activas: " + agenda.listar().size());
}
