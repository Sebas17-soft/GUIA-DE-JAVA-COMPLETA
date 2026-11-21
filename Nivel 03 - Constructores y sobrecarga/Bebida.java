public class Bebida {
    private final String nombre;
    private final String tamano;
    private final int precio;
    private final boolean leche;

    // Constructor completo (4 parámetros)
    public Bebida(String nombre, String tamano, int precio, boolean leche) {
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio inválido");
        }
        this.nombre = nombre;
        this.tamano = tamano;
        this.precio = precio;
        this.leche = leche;
    }

    // Constructor corto sobrecargado (2 parámetros) con prólogo en Java 25
    public Bebida(String nombre, int precio) {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre no puede estar vacío");
        }
        this(nombre, "mediano", precio, false);
    }

    public String descripcion() {
        return nombre + " (" + tamano + ") · $" + precio + (leche ? " · con leche" : "");
    }

    // Sobrecarga de métodos
    public int precioCon(int extras) {
        return precio + extras * 1500;
    }

    public int precioCon(String cupon) {
        if ("CAFE10".equalsIgnoreCase(cupon)) {
            return precio * 90 / 100;
        }
        return precio;
    }
}
