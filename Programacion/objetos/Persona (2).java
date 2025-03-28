package objetos;

public class Persona {

    // Atributos
    private String nombre;
    private Integer edad;

    // Constructor

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Setter y getters

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona("Manolo", 19);
        System.out.println(persona1.getNombre());
        System.out.println(persona1.getEdad());
    }
}
