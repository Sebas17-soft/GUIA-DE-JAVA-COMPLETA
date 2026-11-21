void main() {
    IO.println("=== DEMOSTRACION SESION 03: SOLID EN LA CAJA ===");
    Notificador sms = new SmsSimulado();
    Caja caja = new Caja(sms);
    caja.cobrar(20000, new Porcentaje(10)); // 10% menos = 18000
    caja.cobrar(15000, new Fidelidad(30)); // 30 puntos * 100 = 3000 rebaja = 12000
    IO.println("Saldo en caja: $" + caja.getSaldo());

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 04: PRUEBAS CON DOBLE EN MEMORIA ===");
    NotificadorMemoria memoria = new NotificadorMemoria();
    Caja cajaTest = new Caja(memoria);
    cajaTest.cobrar(10000, new Porcentaje(20));
    IO.println("Mensajes en memoria para auditoría: " + memoria.getMensajes().size());
    for (String m : memoria.getMensajes()) {
        IO.println("  Auditado: " + m);
    }

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 06: COCINA E IMPRESORA ===");
    Cocina cocina = new Cocina(new ImpresoraConsola());
    cocina.enviarComanda("Sándwich de pollo", 4);

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 07: REPORTE DIARIO SOLID ===");
    Totales cierre = new Totales();
    cierre.registrar(18000);
    cierre.registrar(12000);
    cierre.registrar(8000);

    ReporteDiario reporteTexto = new ReporteDiario(new FormatoTexto(), new DestinoConsola());
    reporteTexto.generar(cierre);

    ReporteDiario reporteCsv = new ReporteDiario(new FormatoCsv(), new DestinoConsola());
    reporteCsv.generar(cierre);

    IO.println("");
    IO.println("=== DEMOSTRACION PREGUNTA 8 (S08): HORA FELIZ ===");
    HoraFeliz hf = new HoraFeliz();
    int cuenta = 30000;
    IO.println("Cuenta: $" + cuenta + " · Con Hora Feliz (30% menos): $" + hf.aplicar(cuenta));
}
