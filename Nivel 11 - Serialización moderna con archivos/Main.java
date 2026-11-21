import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.ArrayList;

String aLinea(Insumo i) {
    return i.id() + ";" + i.nombre() + ";" + i.cantidad();
}

Insumo deLinea(String l) {
    var partes = l.split(";");
    return new Insumo(Integer.parseInt(partes[0]), partes[1], Integer.parseInt(partes[2]));
}

void main() throws Exception {
    IO.println("=== DEMOSTRACION SESION 03: SERIALIZACION DE BODEGA CON FILTRO ===");
    Path fSer = Path.of("bodega.ser");
    Almacen almacen = new Almacen(fSer);

    var lista = List.of(
        new Insumo(1, "Café Especial Huila (kg)", 50),
        new Insumo(2, "Leche Entera (L)", 80),
        new Insumo(3, "Vasos biodegradables 12oz", 500)
    );

    almacen.guardar(lista);
    IO.println("Bodega serializada en: " + fSer + " (" + Files.size(fSer) + " bytes)");

    List<Insumo> recuperados = almacen.cargar();
    IO.println("Insumos recuperados de bodega.ser:");
    for (Insumo i : recuperados) {
        IO.println("  " + i);
    }

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 04: PERSISTENCIA EN CSV ===");
    Path fCsv = Path.of("bodega.csv");
    List<String> lineasCsv = new ArrayList<>();
    lineasCsv.add("id;nombre;cantidad");
    for (Insumo i : lista) {
        lineasCsv.add(aLinea(i));
    }
    Files.write(fCsv, lineasCsv);
    IO.println("Archivo CSV generado en " + fCsv + ":");
    for (String linea : Files.readAllLines(fCsv)) {
        IO.println("  " + linea);
    }

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 06: TURNO Y FILTRO DE SEGURIDAD ===");
    Path fTurno = Path.of("turno.ser");
    try (var out = new ObjectOutputStream(Files.newOutputStream(fTurno))) {
        out.writeObject(new Turno("Martín", 42));
    }
    try (var in = new ObjectInputStream(Files.newInputStream(fTurno))) {
        in.setObjectInputFilter(ObjectInputFilter.Config.createFilter("Turno;!*"));
        Turno t = (Turno) in.readObject();
        IO.println(t + " · " + Files.size(fTurno) + " bytes");
    }

    IO.println("");
    IO.println("=== DEMOSTRACION SESION 07: AGENDA QUE NO OLVIDA ===");
    Path fResSer = Path.of("reservas.ser");
    Path fResCsv = Path.of("reservas.csv");
    ArchivoReservas gestor = new ArchivoReservas(fResSer, fResCsv);

    var reservas = List.of(
        new Reserva(1, "Familia Restrepo", 5, "19:30"),
        new Reserva(2, "Dra. Patricia", 2, "20:00")
    );
    gestor.guardar(reservas);
    IO.println("Reservas guardadas en disco.");
    List<Reserva> leidas = gestor.cargar();
    for (Reserva r : leidas) {
        IO.println("  Recuperada: " + r);
    }
    gestor.exportarCsv(leidas);
    IO.println("Reservas exportadas a CSV con éxito (" + Files.size(fResCsv) + " bytes).");

    IO.println("");
    IO.println("=== DEMOSTRACION RECHAZO DE FILTRO (PREGUNTA 5 S08) ===");
    try (var in = new ObjectInputStream(Files.newInputStream(fTurno))) {
        in.setObjectInputFilter(ObjectInputFilter.Config.createFilter("!*")); // rechaza todo
        in.readObject();
    } catch (InvalidClassException ice) {
        IO.println("Filtro actuó correctamente: " + ice.getMessage());
    }
}
