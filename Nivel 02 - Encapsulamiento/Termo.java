public class Termo {
    private int litros; // en mililitros para precisión interna

    public Termo(int litrosIniciales) {
        if (litrosIniciales < 0) {
            throw new IllegalArgumentException("Litros inválidos");
        }
        this.litros = litrosIniciales * 1000;
    }

    public void servir(int ml) {
        if (ml <= 0) {
            throw new IllegalArgumentException("Cantidad a servir inválida");
        }
        if (ml > litros) {
            throw new IllegalArgumentException("No hay suficiente café: quedan " + litros + " ml");
        }
        litros -= ml;
    }

    public int getLitros() {
        return litros / 1000;
    }

    public int getMililitrosRestantes() {
        return litros;
    }
}
