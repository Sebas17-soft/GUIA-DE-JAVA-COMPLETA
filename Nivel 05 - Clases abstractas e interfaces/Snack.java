public abstract class Snack {
    private final String nombre;
    private final int precio;

    public Snack(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public int getPrecio() { return precio; }

    public abstract boolean listoParaComer();
}
