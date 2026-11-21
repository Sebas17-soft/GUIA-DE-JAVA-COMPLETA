import java.util.List;

public record MenuDelDia(String fecha, List<ItemMenu> items) {
    public MenuDelDia {
        items = List.copyOf(items);
    }

    public int promedioPrecio() {
        if (items.isEmpty()) return 0;
        int s = 0;
        for (ItemMenu i : items) {
            s += i.precio();
        }
        return s / items.size();
    }
}
