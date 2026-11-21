public class Efectivo implements MedioDePago {
    @Override
    public String nombre() {
        return "Efectivo";
    }

    @Override
    public boolean pagar(int valor) {
        return true; // Efectivo siempre es aceptado en caja física
    }
}
