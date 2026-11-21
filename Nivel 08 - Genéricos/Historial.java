import java.util.ArrayList;
import java.util.List;

public class Historial<T> {
    private final List<T> items = new ArrayList<>();
    private final int capacidad;

    public Historial(int capacidad) {
        this.capacidad = capacidad;
    }

    public void agregar(T item) {
        if (items.size() == capacidad) {
            items.removeFirst(); // borra el más viejo
        }
        items.add(item);
    }

    public T masReciente() {
        return items.isEmpty() ? null : items.getLast();
    }

    public List<T> todos() {
        return List.copyOf(items);
    }
}
