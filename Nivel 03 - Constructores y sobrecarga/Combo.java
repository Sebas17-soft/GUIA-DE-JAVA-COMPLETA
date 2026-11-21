public class Combo {
    private final String bebida;
    private final String postre;
    private final int precio;

    public Combo(String bebida, String postre, int precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        this.bebida = bebida;
        this.postre = postre;
        this.precio = precio;
    }

    public Combo(String bebida, int precio) {
        if (bebida.isBlank()) {
            throw new IllegalArgumentException("La bebida no puede estar vacía");
        }
        this(bebida, "sin postre", precio);
    }

    public int precioFinal() {
        return precio;
    }

    public int precioFinal(int propinaPct) {
        return precioFinal() * (100 + propinaPct) / 100;
    }

    public String getDescripcion() {
        return "Combo: " + bebida + " + " + postre + " · $" + precio;
    }
}
