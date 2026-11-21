public enum Categoria {
    CALIENTE("Bebida caliente"),
    FRIA("Bebida fría"),
    POSTRE("Postre y repostería"),
    SNACK("Snack salado");

    private final String etiqueta;

    Categoria(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String etiqueta() {
        return etiqueta;
    }
}
