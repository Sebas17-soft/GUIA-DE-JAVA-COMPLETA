public class TarjetaRegalo {
    private int saldo;

    public int getSaldo() {
        return saldo;
    }

    public void recargar(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Recarga inválida: " + valor);
        }
        saldo += valor;
    }

    public boolean pagar(int valor) {
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }
}
