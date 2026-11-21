public class Totales {
    private int total;
    private int ventas;

    public void registrar(int monto) {
        total += monto;
        ventas++;
    }

    public int getTotal() { return total; }
    public int getVentas() { return ventas; }
}
