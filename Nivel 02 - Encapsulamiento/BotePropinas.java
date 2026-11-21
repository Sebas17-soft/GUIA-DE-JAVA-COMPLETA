public class BotePropinas {
    private int total;
    private int aportes;

    public void aportar(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Aporte inválido: " + valor);
        }
        total += valor;
        aportes++;
    }

    public int repartir(int personas) {
        if (personas < 1) {
            throw new IllegalArgumentException("Debe haber al menos 1 persona");
        }
        int porPersona = total / personas;
        total = total % personas; // o queda el remanente en el bote
        return porPersona;
    }

    public int getTotal() {
        return total;
    }

    public int getAportes() {
        return aportes;
    }

    public int sobrante(int personas) {
        if (personas < 1) {
            throw new IllegalArgumentException("Debe haber al menos 1 persona");
        }
        return total % personas;
    }
}
