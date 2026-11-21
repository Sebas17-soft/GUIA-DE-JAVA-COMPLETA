import java.util.List;

void main() {
    IO.println("=== DEMOSTRACION SESION 03: POLIMORFISMO CON PRODUCTOS ===");
    Producto latte = new Bebida("Latte", 9500, 350);
    Producto brownie = new Postre("Brownie", 7000, false);
    Producto tortaVegana = new Postre("Torta Zanahoria", 8500, true);

    List<Producto> carta = List.of(latte, brownie, tortaVegana);
    for (Producto p : carta) {
        IO.println(p.descripcion());
    }

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 04: COMPOSICION CON PEDIDO ===");
    Pedido pedido = new Pedido(4);
    pedido.agregar(latte, 2);
    pedido.agregar(brownie, 1);
    pedido.imprimir();

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 06: TEMPORADA Y COMBO ===");
    Producto ponque = new Temporada("Ponqué de calabaza", 8500, "octubre");
    Combo c = new Combo(new Bebida("Latte", 9500, 350), ponque);
    IO.println(ponque.descripcion());
    IO.println("Combo: $" + c.precio());

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 07: NOMINA DEL TURNO ===");
    Turno turno = new Turno();
    Empleado martin = new Barista("Martín", 50000, 35);
    Empleado laura = new Mesero("Laura", 45000, 18000);
    turno.agregar(martin);
    turno.agregar(laura);
    IO.println(martin + " -> Pago: $" + martin.pago());
    IO.println(laura + " -> Pago: $" + laura.pago());
    IO.println("Total nómina del turno: $" + turno.totalNomina());

    IO.println("");
    IO.println("=== DEMOSTRACION PREGUNTA 8 (S08): SUBCLASE TE ===");
    Te teVerde = new Te("Té Verde Matcha", 8000, 300, "Japón");
    IO.println(teVerde.descripcion());
}
