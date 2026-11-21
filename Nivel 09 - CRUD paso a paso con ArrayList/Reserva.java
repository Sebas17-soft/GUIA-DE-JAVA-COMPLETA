public class Reserva {
    private final int id;
    private final String cliente;
    private final int personas;
    private String hora;

    public Reserva(int id, String cliente, int personas, String hora) {
        if (personas < 1 || personas > 8) {
            throw new IllegalArgumentException("Personas de 1 a 8");
        }
        this.id = id;
        this.cliente = cliente;
        this.personas = personas;
        this.hora = hora;
    }

    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public int getPersonas() { return personas; }
    public String getHora() { return hora; }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Reserva #" + id + " · " + cliente + " (" + personas + " pers.) a las " + hora;
    }
}
