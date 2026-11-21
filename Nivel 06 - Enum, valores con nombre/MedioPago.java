public enum MedioPago {
    EFECTIVO(0),
    TARJETA(2),
    BILLETERA(1);

    private final int comisionPct;

    MedioPago(int comisionPct) {
        this.comisionPct = comisionPct;
    }

    public int neto(int valor) {
        return valor * (100 - comisionPct) / 100;
    }

    public int getComisionPct() {
        return comisionPct;
    }
}
