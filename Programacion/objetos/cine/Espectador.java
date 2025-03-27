package objetos.cine;

public class Espectador {
    // Atributos
    private String nombre;
    private Integer edad;
    private Double dinero;

    // Setters y getters

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getDinero() {
        return this.dinero;
    }

    public void setDinero(Double dinero) {
        this.dinero = dinero;
    }
    // Constructor

    public Espectador(String nombre, Integer edad, Double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    public void comprarEntrada(double precio) {
        if (precio > dinero) {
            System.out.println("No tiene suficiente dinero. No se ha efectuado la compra.");
        } else {
            dinero -= precio;
            System.out.println("Compra realizada con éxito.");
        }

    }

    public boolean comprobarEdad(int edadMinima) {
        if (edad < edadMinima) {
            return true;
        } else {
            return false;
        }
    }

    // Métodos

    public static void main(String[] args) {
        Espectador espectador1 = new Espectador("Pedro", 19, 20.0);

    }
}
