public abstract class Entrega {
    private final int pedidoId;

    public Entrega(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public abstract int costo();

    public String resumen() {
        return "Pedido #" + pedidoId + " · Costo entrega: $" + costo();
    }
}
