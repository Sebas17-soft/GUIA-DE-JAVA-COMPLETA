public class Caja {
    private final Notificador notificador;
    private final Ticket ticket = new Ticket();
    private int saldo;

    public Caja(Notificador notificador) {
        this.notificador = notificador;
    }

    public void cobrar(int total, Descuento d) {
        int finalCobro = d.aplicar(total);
        saldo += finalCobro;
        IO.println(ticket.formatear(finalCobro));
        notificador.avisar("Cobro de $" + finalCobro);
    }

    public int getSaldo() {
        return saldo;
    }
}
