import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoReservas {
    private final Path archivoBinario;
    private final Path archivoCsv;
    private static final String PERMITIDOS = "Reserva;java.util.ArrayList;java.lang.Object;!*";

    public ArchivoReservas(Path binario, Path csv) {
        this.archivoBinario = binario;
        this.archivoCsv = csv;
    }

    public void guardar(List<Reserva> lista) throws IOException {
        try (var out = new ObjectOutputStream(Files.newOutputStream(archivoBinario))) {
            out.writeObject(new ArrayList<>(lista));
        }
    }

    @SuppressWarnings("unchecked")
    public List<Reserva> cargar() throws IOException, ClassNotFoundException {
        if (!Files.exists(archivoBinario)) {
            return new ArrayList<>();
        }
        try (var in = new ObjectInputStream(Files.newInputStream(archivoBinario))) {
            in.setObjectInputFilter(ObjectInputFilter.Config.createFilter(PERMITIDOS));
            return (List<Reserva>) in.readObject();
        }
    }

    public void exportarCsv(List<Reserva> lista) throws IOException {
        List<String> lineas = new ArrayList<>();
        lineas.add("id;cliente;personas;hora");
        for (Reserva r : lista) {
            lineas.add(r.id() + ";" + r.cliente() + ";" + r.personas() + ";" + r.hora());
        }
        Files.write(archivoCsv, lineas);
    }
}
