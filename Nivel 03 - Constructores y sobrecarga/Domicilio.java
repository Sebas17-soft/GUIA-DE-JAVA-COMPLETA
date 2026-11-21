public class Domicilio {
    private final String direccion;
    private final int valor;

    public Domicilio(String direccion, int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor de domicilio inválido");
        }
        this.direccion = direccion;
        this.valor = valor;
    }

    public Domicilio(String direccion) {
        this(direccion, 4000); // 4000 por defecto
    }

    public String resumen() {
        return "Domicilio hacia: " + direccion + " · Costo: $" + valor;
    }
}
