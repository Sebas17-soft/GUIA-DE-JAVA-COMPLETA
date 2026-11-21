public class Domicilio {
    String direccion;
    String estado = "pendiente";

    void despachar() {
        estado = "en camino";
    }

    String consultar() {
        return "Domicilio a " + direccion + " · Estado: " + estado;
    }
}
