import java.util.ArrayList;
import java.util.List;

public class Turno {
    private final List<Empleado> empleados = new ArrayList<>();

    public void agregar(Empleado e) {
        empleados.add(e);
    }

    public int totalNomina() {
        int total = 0;
        for (Empleado e : empleados) {
            total += e.pago();
        }
        return total;
    }
}
