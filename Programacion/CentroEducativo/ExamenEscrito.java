package CentroEducativo;

public class ExamenEscrito extends Examen implements Aprobable {
    private final int MIN_NOTA = 0;
    private final int MAX_NOTA = 10;
    private final int NOTA_APROBADO = 6;
    private final int MAX_DURACION = 90;
    private int duracion;
    private int nota;

    // Constructor
    public ExamenEscrito(String fecha, int duracion, int nota) {
        super(fecha);
        this.duracion = duracion;
        this.nota = nota;
    }

    // Setters y getters

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    // Métodos
    @Override
    public boolean aprobo() {
        return nota >= NOTA_APROBADO && duracion <= MAX_DURACION;
    }

}
