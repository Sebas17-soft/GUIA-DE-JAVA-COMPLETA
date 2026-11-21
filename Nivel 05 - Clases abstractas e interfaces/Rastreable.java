public interface Rastreable {
    String estado();
    void avanzar();

    default boolean entregado() {
        return "entregado".equalsIgnoreCase(estado());
    }
}
