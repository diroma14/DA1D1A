package objetos.cine;

public class Cine {
    //Atributos
    private String peliculaActual;
    private Double precio;
    
    //Setters y getters
    public String getPeliculaActual() {
        return peliculaActual;
    }
    public void setPeliculaActual(String peliculaActual) {
        this.peliculaActual = peliculaActual;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    //Constructor
    public Cine(String peliculaActual, Double precio) {
        this.peliculaActual = peliculaActual;
        this.precio = precio;
    }
    //Métodos
    public static void main(String[] args) {
        Cine cine1 = new Cine("Doraemon", 20.0);
    }
}
