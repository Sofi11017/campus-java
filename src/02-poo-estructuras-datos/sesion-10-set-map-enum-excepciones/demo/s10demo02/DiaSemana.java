package s10demo02;

public enum DiaSemana {
    LUNES(true, "Lunes"), MARTES(true, "Martes"), MIERCOLES(true, "Miercoles"), JUEVES(true, "Jueves"), VIERNES(false, "Viernes"), SABADO(false, "Sabado"), DOMINGO(false, "Domingo");

    private final boolean laborable;
    private final String descripcion;

    DiaSemana(boolean laborable, String descripcion) {
        this.laborable = laborable;
        this.descripcion = descripcion;
    }

    public boolean esLaborable() {
        return laborable;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
