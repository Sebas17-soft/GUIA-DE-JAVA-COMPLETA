public interface Imprimible {
    String texto();

    default void imprimir() {
        IO.println("[Ticket Impreso]: " + texto());
    }
}
