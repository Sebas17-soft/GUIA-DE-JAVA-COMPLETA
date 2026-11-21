import java.util.List;

String describir(Pago p, int total) {
    return switch (p) {
        case Efectivo(int r) -> "Efectivo: recibido $" + r + ", cambio $" + (r - total);
        case Tarjeta(var f, int c) when c > 1 -> "Tarjeta " + f + " en " + c + " cuotas";
        case Tarjeta(var f, int c) -> "Tarjeta " + f + " corriente";
        case Billetera(var app, int s) -> app + " (saldo $" + s + ")";
    };
}

void main() {
    IO.println("=== DEMOSTRACION SESION 03: RECIBO INMUTABLE ===");
    var l1 = new LineaRecibo("Latte", 9500, 2);
    var l2 = new LineaRecibo("Brownie", 7000, 1);
    IO.println(l1);
    IO.println(l1.producto() + " → $" + l1.subtotal());
    var otra = new LineaRecibo("Latte", 9500, 2);
    IO.println("¿Iguales según equals?: " + l1.equals(otra));

    var r = new Recibo(1001, List.of(l1, l2));
    IO.println("Recibo #" + r.numero() + " total: $" + r.total());

    // Patrón de deconstrucción de record
    if (r.lineas().getFirst() instanceof LineaRecibo(var p, var precio, var c)) {
        IO.println("Deconstruido: " + c + " × " + p + " a $" + precio);
    }

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 04: SEALED RECORDS Y PATRONES ===");
    Pago pago1 = new Efectivo(30000);
    Pago pago2 = new Tarjeta("Visa", 3);
    Pago pago3 = new Billetera("Nequi", 50000);
    int cuenta = 26000;
    IO.println(describir(pago1, cuenta));
    IO.println(describir(pago2, cuenta));
    IO.println(describir(pago3, cuenta));

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 06: CALIFICACIONES ===");
    var a = new Calificacion("Sofía", 5);
    var b = new Calificacion("Sofía", 5);
    IO.println(a.cliente() + ": " + a.estrellas());
    IO.println("¿Buena? " + a.esBuena());
    IO.println("¿Iguales? " + a.equals(b));
    IO.println(a);

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 07: MENU DEL DIA INMUTABLE ===");
    var m1 = new ItemMenu("Americano", Categoria.CALIENTE, 5000);
    var m2 = new ItemMenu("Cold Brew", Categoria.FRIA, 8000);
    var m3 = new ItemMenu("Cheesecake", Categoria.POSTRE, 11000);
    var menu = new MenuDelDia("2026-11-13", List.of(m1, m2, m3));

    IO.println("Menú " + menu.fecha() + " con " + menu.items().size() + " ítems. Promedio: $" + menu.promedioPrecio());
    var m1Ajustado = m1.conPrecio(5500);
    IO.println("Precio nuevo m1: $" + m1Ajustado.precio() + " · Original sigue en: $" + m1.precio());

    IO.println("Solo bebidas calientes:");
    for (ItemMenu item : menu.items()) {
        if (item instanceof ItemMenu(var n, Categoria cat, var precio) && cat == Categoria.CALIENTE) {
            IO.println("  " + n + " -> $" + precio);
        }
    }

    IO.println("");
    IO.println("=== DEMOSTRACION PREGUNTA 8 (S08): PROPINA ===");
    var propina = new Propina("Martín", 5000);
    IO.println("Propina registrada para " + propina.barista() + ": $" + propina.valor());
    try {
        new Propina("Martín", -1000);
    } catch (IllegalArgumentException ex) {
        IO.println("Rechazada: " + ex.getMessage());
    }
}
