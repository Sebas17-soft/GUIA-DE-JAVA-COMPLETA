public class Cliente implements Identificable {
    private final int id;
    private final String nombre;

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public int id() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return "Cliente #" + id + ": " + nombre;
    }
}
