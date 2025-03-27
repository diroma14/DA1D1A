package CentroEducativo;

public class ExamenOral extends Examen implements Aprobable {
    private String nivelSatisfaccion;

    public ExamenOral(String fecha, String nivelSatisfaccion) {
        super(fecha);
        this.nivelSatisfaccion = nivelSatisfaccion;
    }

    public String getNivelSatisfacción() {
        return nivelSatisfaccion;
    }

    public void setNivelSatisfacción(String nivelSatisfacción) {
        this.nivelSatisfaccion = nivelSatisfaccion;
    }

    @Override
    public boolean aprobo() {
        return nivelSatisfaccion.equals("Suficiente") || nivelSatisfaccion.equals("Excelente");
    }

}
