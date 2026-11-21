public class EnMesa extends Entrega {
    private final int mesa;

    public EnMesa(int pedidoId, int mesa) {
        super(pedidoId);
        this.mesa = mesa;
    }

    @Override
    public int costo() {
        return 0;
    }

    @Override
    public String resumen() {
        return super.resumen() + " (mesa " + mesa + ")";
    }
}
