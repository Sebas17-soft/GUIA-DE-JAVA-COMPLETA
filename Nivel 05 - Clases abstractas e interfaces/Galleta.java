public class Galleta extends Snack implements Descontable {
    public Galleta(String nombre, int precio) {
        super(nombre, precio);
    }

    @Override
    public boolean listoParaComer() {
        return true;
    }

    @Override
    public int precioConDescuento(int pct) {
        return getPrecio() * (100 - pct) / 100;
    }
}
