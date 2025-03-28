package universidad;

public class Estudiante extends Persona{
    private Integer ID;

    //Constructor predeterminado
    public Estudiante(){
        super();
        this.ID = 0;
    }

    // Constructor parametrizado
    public Estudiante(Integer ID, String nombre, String apellido1, String apellido2, Integer NIF, Direccion direccion) {
        super(nombre, apellido1, apellido2, NIF, direccion);
        this.ID = ID;
    }

    //Setters y getters
    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }


    
}
