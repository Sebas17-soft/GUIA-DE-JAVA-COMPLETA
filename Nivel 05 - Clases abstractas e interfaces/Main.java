import java.util.List;

void main() {
    IO.println("=== DEMOSTRACION SESION 03: CLASE ABSTRACTA E INTERFAZ ===");
    Producto latte = new Bebida("Latte", 9500);
    Producto cheesecake = new Postre("Cheesecake", 12000);
    IO.println(latte.ficha());
    IO.println(cheesecake.ficha());
    if (latte instanceof Personalizable p) {
        IO.println("Extra shot: +$" + p.extra("shot extra"));
    }

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 04: MEDIOS DE PAGO (CONTRATO) ===");
    MedioDePago efectivo = new Efectivo();
    MedioDePago billetera = new Billetera(20000);
    int cuenta = 15000;
    IO.println("Pagando $" + cuenta + " con " + efectivo.nombre() + ": " + efectivo.pagar(cuenta));
    IO.println("Pagando $" + cuenta + " con " + billetera.nombre() + ": " + billetera.pagar(cuenta));
    IO.println("Segundo intento con billetera: " + billetera.pagar(cuenta));

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 06: GALLETA DESCONTABLE ===");
    Galleta galleta = new Galleta("Galleta Avena y Miel", 4000);
    IO.println(galleta.getNombre() + " lista para comer: " + galleta.listoParaComer());
    IO.println("Precio normal: $" + galleta.getPrecio() + " · Con 20% descuento: $" + galleta.precioConDescuento(20));

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 07: ENTREGAS Y RASTREO ===");
    Entrega e1 = new EnMesa(101, 3);
    Entrega e2 = new ParaLlevar(102);
    Domicilio e3 = new Domicilio(103, 5); // 5 km

    List<Entrega> entregas = List.of(e1, e2, e3);
    for (Entrega e : entregas) {
        IO.println(e.resumen());
        if (e instanceof Rastreable r) {
            IO.println("  Estado inicial: " + r.estado() + " · ¿Entregado?: " + r.entregado());
            r.avanzar();
            IO.println("  Tras avanzar 1: " + r.estado());
            r.avanzar();
            IO.println("  Tras avanzar 2: " + r.estado() + " · ¿Entregado?: " + r.entregado());
        }
    }

    IO.println("");
    IO.println("=== DEMOSTRACION PREGUNTA 8 (S08): DEFAULT EN INTERFAZ ===");
    Imprimible demoTicket = new Imprimible() {
        public String texto() { return "Café Sintaxis · Gracias por su compra"; }
    };
    demoTicket.imprimir();
}
