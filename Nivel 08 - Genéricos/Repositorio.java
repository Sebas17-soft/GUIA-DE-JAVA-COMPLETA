import java.util.ArrayList;
import java.util.List;

public class Repositorio<T extends Identificable> {
    private final List<T> items = new ArrayList<>();

    public void guardar(T item) {
        items.add(item);
    }

    public T buscar(int id) {
        for (T item : items) {
            if (item.id() == id) {
                return item;
            }
        }
        return null;
    }

    public List<T> todos() {
        return List.copyOf(items);
    }
}
