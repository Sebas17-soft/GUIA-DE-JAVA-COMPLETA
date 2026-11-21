public class FormatoTexto implements Formato {
    @Override
    public String dar(int total, int ventas) {
        return "CIERRE DEL DIA: " + ventas + " ventas · Total: $" + total;
    }
}
