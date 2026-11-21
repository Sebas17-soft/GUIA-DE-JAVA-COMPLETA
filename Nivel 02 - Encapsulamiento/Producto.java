public class Producto {
    private String nombre;
    private int precio;

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        if (precio < 0 || precio > 50000) {
            throw new IllegalArgumentException("Precio fuera de rango: " + precio);
        }
        this.precio = precio;
    }
}
