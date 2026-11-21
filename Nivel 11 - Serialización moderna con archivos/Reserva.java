import java.io.Serializable;

public record Reserva(int id, String cliente, int personas, String hora) implements Serializable {
    public Reserva {
        if (personas < 1 || personas > 8) {
            throw new IllegalArgumentException("Personas de 1 a 8");
        }
    }
}
