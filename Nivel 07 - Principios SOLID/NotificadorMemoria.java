import java.util.ArrayList;
import java.util.List;

public class NotificadorMemoria implements Notificador {
    private final List<String> mensajes = new ArrayList<>();

    @Override
    public void avisar(String mensaje) {
        mensajes.add(mensaje);
    }

    public List<String> getMensajes() {
        return mensajes;
    }
}
