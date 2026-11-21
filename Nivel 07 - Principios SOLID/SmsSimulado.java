public class SmsSimulado implements Notificador {
    @Override
    public void avisar(String mensaje) {
        IO.println("[SMS] " + mensaje);
    }
}
