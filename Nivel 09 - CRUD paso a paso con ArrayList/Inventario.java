import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventario {
    private final List<Insumo> insumos = new ArrayList<>();
    private int siguienteId = 1;

    // C · Crear
    public Insumo crear(String nombre, int cantidad) {
        Insumo i = new Insumo(siguienteId++, nombre, cantidad);
        insumos.add(i);
        return i;
    }

    // R · Leer todos (copia inmutable defensiva)
    public List<Insumo> listar() {
        return List.copyOf(insumos);
    }

    // R · Leer uno con Optional
    public Optional<Insumo> buscar(int id) {
        for (Insumo i : insumos) {
            if (i.getId() == id) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    // U · Actualizar
    public boolean actualizar(int id, int nuevaCantidad) {
        Optional<Insumo> opt = buscar(id);
        if (opt.isPresent()) {
            opt.get().setCantidad(nuevaCantidad);
            return true;
        }
        return false;
    }

    // D · Borrar
    public boolean borrar(int id) {
        return insumos.removeIf(i -> i.getId() == id);
    }

    // Método de la pregunta 8 (S08)
    public boolean existe(String nombre) {
        for (Insumo i : insumos) {
            if (i.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
}
