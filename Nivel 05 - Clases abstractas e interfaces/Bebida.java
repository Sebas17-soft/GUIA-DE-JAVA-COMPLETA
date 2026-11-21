public class Bebida extends Producto implements Personalizable {
    public Bebida(String nombre, int precio) {
        super(nombre, precio);
    }

    @Override
    public int minutosPreparacion() {
        return 4;
    }

    @Override
    public int extra(String opcion) {
        if ("shot extra".equalsIgnoreCase(opcion)) {
            return 2000;
        }
        if ("leche vegetal".equalsIgnoreCase(opcion)) {
            return 1500;
        }
        return 0;
    }
}
