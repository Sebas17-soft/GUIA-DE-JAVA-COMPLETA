void main() {
    IO.println("=== DEMOSTRACION SESION 03: PRODUCTO ===");
    Producto latte = new Producto();
    latte.nombre = "Latte";
    latte.precio = 9500;
    latte.stock = 3;

    Producto brownie = new Producto();
    brownie.nombre = "Brownie";
    brownie.precio = 7000;

    IO.println(latte.descripcion());
    IO.println("¿Hay brownie? " + brownie.hayStock());
    int cobro = latte.vender(2);
    IO.println("Cobrar: $" + cobro);
    IO.println(latte.descripcion());
    latte.vender(5);

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 04: CLIENTE ===");
    Cliente sofia = new Cliente();
    sofia.nombre = "Sofia";
    sofia.puntos = 41;
    sofia.sumarPuntos(12500);
    IO.println(sofia.tarjeta());
    IO.println("¿Cafe gratis? " + sofia.puedeCanjear());
    sofia.canjear();
    IO.println("Tras canjear cafe: " + sofia.tarjeta());

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 06: MESA ===");
    Mesa m4 = new Mesa();
    m4.numero = 4;
    m4.ocupar(3);
    IO.println(m4.estado());
    m4.liberar();
    IO.println(m4.estado());

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 07: BARISTA ===");
    Barista martin = new Barista();
    martin.nombre = "Martin";
    martin.turno = "mañana";
    for (int i = 0; i < 3; i++) {
        martin.preparar("Latte");
    }
    IO.println(martin.resumen());
    IO.println("¿Martin merece pausa? " + martin.merecePausa());

    Barista ana = new Barista();
    ana.nombre = "Ana";
    ana.turno = "tarde";
    for (int i = 0; i < 21; i++) {
        ana.preparar("Espresso");
    }
    IO.println(ana.resumen());
    IO.println("¿Ana merece pausa? " + ana.merecePausa());

    IO.println("");
    IO.println("=== DEMOSTRACION PREGUNTA 8 (S08): DOMICILIO ===");
    Domicilio dom = new Domicilio();
    dom.direccion = "Cra 7 # 45-10";
    IO.println(dom.consultar());
    dom.despachar();
    IO.println(dom.consultar());
}
