public class ReporteDiario {
    private final Formato formato;
    private final Destino destino;

    public ReporteDiario(Formato formato, Destino destino) {
        this.formato = formato;
        this.destino = destino;
    }

    public void generar(Totales totales) {
        String resultado = formato.dar(totales.getTotal(), totales.getVentas());
        destino.enviar(resultado);
    }
}
