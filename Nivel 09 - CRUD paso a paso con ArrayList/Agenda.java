import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Agenda {
    private final List<Reserva> reservas = new ArrayList<>();
    private int siguienteId = 1;

    public Reserva crear(String cliente, int personas, String hora) {
        Reserva r = new Reserva(siguienteId++, cliente, personas, hora);
        reservas.add(r);
        return r;
    }

    public List<Reserva> listar() {
        return List.copyOf(reservas);
    }

    public Optional<Reserva> buscar(int id) {
        for (Reserva r : reservas) {
            if (r.getId() == id) {
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }

    public boolean cambiarHora(int id, String nuevaHora) {
        Optional<Reserva> opt = buscar(id);
        if (opt.isPresent()) {
            opt.get().setHora(nuevaHora);
            return true;
        }
        return false;
    }

    public boolean cancelar(int id) {
        return reservas.removeIf(r -> r.getId() == id);
    }

    public List<Reserva> deLaHora(String hora) {
        List<Reserva> filtradas = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getHora().equals(hora)) {
                filtradas.add(r);
            }
        }
        return filtradas;
    }
}
