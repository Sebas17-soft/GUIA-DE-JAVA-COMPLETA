public record ItemMenu(String nombre, Categoria categoria, int precio) {
    public ItemMenu {
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio debe ser positivo: " + precio);
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre no puede estar vacío");
        }
    }

    public ItemMenu conPrecio(int nuevo) {
        return new ItemMenu(nombre, categoria, nuevo);
    }
}
