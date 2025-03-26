package CentroEducativo;

public class Examen {
    private String fecha;

    //Constructor
    public Examen(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    //Setters y getters
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
