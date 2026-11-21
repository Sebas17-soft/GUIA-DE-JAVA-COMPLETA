import java.util.List;
import java.util.ArrayList;

<T> T ultimo(List<T> lista) {
    return lista.getLast();
}

int sumarPrecios(List<? extends Producto> lista) {
    int s = 0;
    for (Producto p : lista) {
        s += p.getPrecio();
    }
    return s;
}

<T extends Comparable<T>> T maximo(List<T> lista) {
    T max = lista.getFirst();
    for (T item : lista) {
        if (item.compareTo(max) > 0) {
            max = item;
        }
    }
    return max;
}

<T> int contar(List<T> lista, T buscado) {
    int c = 0;
    for (T elem : lista) {
        if (elem.equals(buscado)) {
            c++;
        }
    }
    return c;
}

int sumar(List<? extends Number> lista) {
    int total = 0;
    for (Number n : lista) {
        total += n.intValue();
    }
    return total;
}

<T> List<T> primeros(List<T> lista, int n) {
    List<T> sub = new ArrayList<>();
    for (int i = 0; i < Math.min(n, lista.size()); i++) {
        sub.add(lista.get(i));
    }
    return sub;
}

void main() {
    IO.println("=== DEMOSTRACION SESION 03: REPOSITORIO GENERICO ACOTADO ===");
    Repositorio<Producto> repoProductos = new Repositorio<>();
    repoProductos.guardar(new Producto(1, "Latte", 9500));
    repoProductos.guardar(new Producto(2, "Brownie", 7000));
    IO.println("Producto id 1: " + repoProductos.buscar(1));
    IO.println("Suma precios: $" + sumarPrecios(repoProductos.todos()));

    Repositorio<Cliente> repoClientes = new Repositorio<>();
    repoClientes.guardar(new Cliente(101, "Sofía"));
    repoClientes.guardar(new Cliente(102, "Martín"));
    IO.println("Cliente id 102: " + repoClientes.buscar(102));

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 04: METODO GENERICO MAXIMO ===");
    List<Integer> ventas = List.of(9500, 18000, 7000, 24000, 12000);
    IO.println("Venta máxima: $" + maximo(ventas));
    List<String> nombres = List.of("Tinto", "Cappuccino", "Moka", "Americano");
    IO.println("Alfabéticamente mayor: " + maximo(nombres));

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 06: BANDEJA GENERICA ===");
    Bandeja<String> b = new Bandeja<>(2);
    b.poner("latte");
    b.poner("moka");
    IO.println("¿Cabe un tinto? " + b.poner("tinto"));
    IO.println(b.primera() + " · " + b.cantidad());

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 07: HISTORIAL DE LA BARRA ===");
    Historial<String> histPedidos = new Historial<>(3);
    histPedidos.agregar("Pedido #1: 2 Latte");
    histPedidos.agregar("Pedido #2: 1 Brownie");
    histPedidos.agregar("Pedido #3: 3 Tintos");
    histPedidos.agregar("Pedido #4: 1 Cappuccino"); // desplaza al pedido #1
    IO.println("Más reciente: " + histPedidos.masReciente());
    IO.println("Historial actual (capacidad 3): " + histPedidos.todos());

    Historial<Integer> histCobros = new Historial<>(3);
    histCobros.agregar(19000);
    histCobros.agregar(7000);
    histCobros.agregar(10500);
    IO.println("Total últimos cobros (sumar con comodín ? extends Number): $" + sumar(histCobros.todos()));
    IO.println("Conteo de 7000 en cobros: " + contar(histCobros.todos(), 7000));

    IO.println("");
    IO.println("=== DEMOSTRACION PREGUNTA 8 (S08): METODO PRIMEROS ===");
    List<String> bebidas = List.of("Latte", "Espresso", "Capuchino", "Moca", "Americano");
    List<String> top3 = primeros(bebidas, 3);
    IO.println("Primeras 3 bebidas: " + top3);
}
