public enum EstadoMesa {
    LIBRE("Mesa libre y disponible"),
    OCUPADA("Clientes en mesa"),
    POR_LIMPIAR("Pendiente por desinfectar"),
    RESERVADA("Apartada para reserva"),
    FUERA_DE_SERVICIO("Mantenimiento");

    private final String aviso;

    EstadoMesa(String aviso) {
        this.aviso = aviso;
    }

    public String aviso() {
        return aviso;
    }

    public EstadoMesa siguiente() {
        return switch (this) {
            case OCUPADA -> POR_LIMPIAR;
            case POR_LIMPIAR -> LIBRE;
            case RESERVADA -> OCUPADA;
            case LIBRE -> OCUPADA;
            case FUERA_DE_SERVICIO -> FUERA_DE_SERVICIO;
        };
    }

    public boolean disponible() {
        return this == LIBRE;
    }
}
