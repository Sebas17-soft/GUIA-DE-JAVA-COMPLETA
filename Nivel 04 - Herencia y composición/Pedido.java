import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final int mesa;
    private final List<LineaPedido> lineas = new ArrayList<>();

    public Pedido(int mesa) {
        this.mesa = mesa;
    }

    public void agregar(Producto p, int cantidad) {
        lineas.add(new LineaPedido(p, cantidad));
    }

    public int total() {
        int t = 0;
        for (LineaPedido l : lineas) {
            t += l.subtotal();
        }
        return t;
    }

    public void imprimir() {
        IO.println("Mesa " + mesa);
        for (LineaPedido l : lineas) {
            IO.println("  " + l.texto());
        }
        IO.println("Total: $" + total());
    }
}
