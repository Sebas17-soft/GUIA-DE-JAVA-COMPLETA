public class Domicilio extends Entrega implements Rastreable {
    private final int km;
    private String estadoActual = "preparando";

    public Domicilio(int pedidoId, int km) {
        super(pedidoId);
        this.km = km;
    }

    @Override
    public int costo() {
        return 2000 + 800 * km;
    }

    @Override
    public String estado() {
        return estadoActual;
    }

    @Override
    public void avanzar() {
        if ("preparando".equals(estadoActual)) {
            estadoActual = "en camino";
        } else if ("en camino".equals(estadoActual)) {
            estadoActual = "entregado";
        }
    }

    @Override
    public String resumen() {
        return super.resumen() + " (domicilio " + km + " km)";
    }
}
