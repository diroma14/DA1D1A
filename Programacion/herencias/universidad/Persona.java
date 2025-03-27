package universidad;

public class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Integer NIF;
    private Direccion direccion;

    // Constructor

    public Persona(String nombre, String apellido1, String apellido2, Integer NIF, Direccion direccion) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.NIF = NIF;
        this.direccion = direccion;
    }

    //Constructor predeterminado
    public Persona() {
        this.nombre = "Sin nombre";
        this.apellido1 = "Sin apellido1";
        this.apellido2 = "Sin apellido2";
        this.NIF = 0;
        this.direccion = new Direccion();
    }

    //To String
    

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Integer getNIF() {
        return NIF;
    }

    public void setNIF(Integer nIF) {
        NIF = nIF;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
}

