public record Propina(String barista, int valor) {
    public Propina {
        if (valor < 0) {
            throw new IllegalArgumentException("Propina no puede ser negativa: " + valor);
        }
    }
}
