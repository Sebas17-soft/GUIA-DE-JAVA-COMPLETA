import java.util.EnumMap;
import java.util.Map;

void main() {
    IO.println("=== DEMOSTRACION SESION 03: TAMANO Y ESTADOPEDIDO ===");
    for (Tamano t : Tamano.values()) {
        IO.println(t + ": " + t.ml() + " ml, +$" + t.recargo());
    }

    EstadoPedido e = EstadoPedido.RECIBIDO;
    while (e != EstadoPedido.ENTREGADO) {
        e = e.siguiente();
        String aviso = switch (e) {
            case EN_PREPARACION -> "En barra";
            case LISTO -> "¡Listo para recoger!";
            default -> "Entregado";
        };
        IO.println(e.ordinal() + " " + e + " → " + aviso);
    }

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 04: CATEGORIAS Y ENUMMAP ===");
    Map<Categoria, Integer> ventas = new EnumMap<>(Categoria.class);
    ventas.put(Categoria.CALIENTE, 145000);
    ventas.put(Categoria.POSTRE, 68000);
    for (Categoria c : Categoria.values()) {
        IO.println(c.etiqueta() + ": $" + ventas.getOrDefault(c, 0));
    }

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 06: LECHES VEGETALES ===");
    for (Leche l : Leche.values()) {
        if (l.vegetal()) {
            IO.println(l + " +$" + l.recargo());
        }
    }

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 07: PLANO DEL SALON (ESTADOMESA) ===");
    EstadoMesa[] mesas = {
        EstadoMesa.LIBRE, EstadoMesa.OCUPADA, EstadoMesa.RESERVADA,
        EstadoMesa.POR_LIMPIAR, EstadoMesa.LIBRE, EstadoMesa.OCUPADA,
        EstadoMesa.LIBRE, EstadoMesa.FUERA_DE_SERVICIO
    };

    Map<EstadoMesa, Integer> conteo = new EnumMap<>(EstadoMesa.class);
    for (EstadoMesa em : EstadoMesa.values()) {
        conteo.put(em, 0);
    }
    for (EstadoMesa m : mesas) {
        conteo.put(m, conteo.get(m) + 1);
    }
    IO.println("Conteo inicial:");
    for (var entry : conteo.entrySet()) {
        IO.println("  " + entry.getKey() + ": " + entry.getValue() + " (" + entry.getKey().aviso() + ")");
    }

    IO.println("");
    IO.println("=== DEMOSTRACION PREGUNTA 8 (S08): MEDIOPAGO NETO ===");
    int cuenta = 50000;
    for (MedioPago mp : MedioPago.values()) {
        IO.println(mp + " (comisión " + mp.getComisionPct() + "%): Neto a recibir = $" + mp.neto(cuenta));
    }
}
