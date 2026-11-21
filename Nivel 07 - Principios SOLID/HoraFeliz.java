public class HoraFeliz implements Descuento {
    @Override
    public int aplicar(int total) {
        if (total <= 0) return 0;
        return total * 70 / 100; // 30% menos
    }
}
