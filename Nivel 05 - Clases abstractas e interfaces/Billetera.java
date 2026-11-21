public class Billetera implements MedioDePago {
    private int saldo;

    public Billetera(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String nombre() {
        return "Billetera Digital";
    }

    @Override
    public boolean pagar(int valor) {
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public int getSaldo() {
        return saldo;
    }
}
