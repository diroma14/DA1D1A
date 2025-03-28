package universidad;

public class Profesor extends Persona{
    private Integer despacho;

    

    //Constructor predeterminado
    public Profesor(){
        super();
        this.despacho = 0;
    }

    //Constructor parametrizado
    public Profesor(Integer despacho, String nombre, String apellido1, String apellido2, Integer NIF, Direccion direccion){
        super(nombre, apellido1, apellido2, NIF, direccion);
        this.despacho = despacho;
    }

    //Setters y getters

    public Integer getDespacho() {
        return despacho;
    }

    public void setDespacho(Integer despacho) {
        this.despacho = despacho;
    }
    
}
