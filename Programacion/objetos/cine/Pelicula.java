package objetos.cine;

public class Pelicula {
    // Atributos
    private String titulo;
    private Double duracion;
    private Integer edadMinima;
    private String director;

    // Setters y getters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Constructor
    public Pelicula(String titulo, Double duracion, Integer edadMinima, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.director = director;
    }
    // Métodos

    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula("Doraemon", 60.0, 5, "Nobita Nobi");
    }

}
