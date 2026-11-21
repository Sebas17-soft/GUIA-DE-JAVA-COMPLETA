void main() {
    IO.println("=== DEMOSTRACION SESION 03: CAJA ===");
    Caja caja = new Caja();
    caja.cobrar(19000);
    caja.cobrar(7000);
    IO.println(caja.resumen());
    try {
        caja.cobrar(-500);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    // caja.saldo = 0; // No compila: saldo tiene acceso privado en Caja
    IO.println("Saldo: $" + caja.getSaldo());

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 04: PRODUCTO ENCAPSULADO ===");
    Producto latte = new Producto();
    latte.setNombre("Latte");
    latte.setPrecio(9500);
    IO.println(latte.getNombre() + " $" + latte.getPrecio());
    try {
        latte.setPrecio(-9500);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    IO.println("Sigue en $" + latte.getPrecio());

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 06: TARJETA REGALO ===");
    TarjetaRegalo t = new TarjetaRegalo();
    t.recargar(30000);
    IO.println("¿Pagó latte? " + t.pagar(9500));
    IO.println("¿Pagó torta? " + t.pagar(25000));
    IO.println("Saldo: $" + t.getSaldo());

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 07: BOTE DE PROPINAS ===");
    BotePropinas bote = new BotePropinas();
    bote.aportar(2000);
    bote.aportar(5000);
    bote.aportar(3500);
    IO.println("Total aportado: $" + bote.getTotal() + " en " + bote.getAportes() + " aportes");
    try {
        bote.aportar(-100);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    int porPersona = bote.repartir(3);
    IO.println("Reparto entre 3 personas: $" + porPersona + " c/u · En bote queda: $" + bote.getTotal());

    IO.println("");
    IO.println("=== DEMOSTRACION PREGUNTA 8 (S08): TERMO ===");
    Termo termo = new Termo(5); // 5 litros
    IO.println("Termo con " + termo.getLitros() + "L (" + termo.getMililitrosRestantes() + " ml)");
    termo.servir(350); // servir 1 latte
    IO.println("Tras servir 350 ml quedan: " + termo.getMililitrosRestantes() + " ml");
    try {
        termo.servir(10000);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
}
