void main() {
    IO.println("=== DEMOSTRACION SESION 03: BEBIDA ===");
    Bebida a = new Bebida("Latte", "grande", 11000, true);
    Bebida b = new Bebida("Tinto", 3500);
    IO.println(a.descripcion());
    IO.println(b.descripcion());
    IO.println("Latte + 2 extras: $" + a.precioCon(2));
    IO.println("Con cupón: $" + a.precioCon("CAFE10"));
    try {
        new Bebida(" ", 3000);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazada: " + e.getMessage());
    }

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 04: RESERVA ===");
    Reserva r1 = new Reserva("Familia Rojas", 6, "18:30");
    Reserva r2 = new Reserva("Andrés", 2);
    IO.println(r1.aviso());
    IO.println(r2.aviso(15));
    try {
        new Reserva("Fiesta", 12);
    } catch (IllegalArgumentException e) {
        IO.println("No se pudo: " + e.getMessage());
    }

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 06: POSTRE ===");
    Postre p1 = new Postre("Brownie", 7000);
    Postre p2 = new Postre("Cheesecake", 9000, true);
    IO.println(p1.etiqueta(true));
    IO.println(p2.etiqueta(true));

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 07: COMBO ===");
    Combo c1 = new Combo("Cappuccino", "Muffin", 14000);
    Combo c2 = new Combo("Americano", 6000);
    IO.println(c1.getDescripcion() + " -> Total con 10% propina: $" + c1.precioFinal(10));
    IO.println(c2.getDescripcion() + " -> Total: $" + c2.precioFinal());
    try {
        new Combo(" ", 5000);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado combo: " + e.getMessage());
    }

    IO.println("");
    IO.println("=== DEMOSTRACION PREGUNTA 8 (S08): DOMICILIO CON SOBRECARGA ===");
    Domicilio d1 = new Domicilio("Carrera 15 # 80-20", 6000);
    Domicilio d2 = new Domicilio("Calle 45 # 13-05");
    IO.println(d1.resumen());
    IO.println(d2.resumen());
}
