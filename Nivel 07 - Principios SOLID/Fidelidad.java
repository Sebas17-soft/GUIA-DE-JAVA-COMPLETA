public class Fidelidad implements Descuento {
    private final int puntos;

    public Fidelidad(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public int aplicar(int total) {
        int rebaja = Math.min(total, puntos * 100);
        return total - rebaja; // Nunca negativo, respetando Liskov
    }
}
