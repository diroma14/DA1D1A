package alarma;

public class Timbre {
    private Boolean encendido;

    // Constructor

    public Timbre(Boolean encendido) {
        this.encendido = encendido;
    }

    // Setters y getters
    public Boolean getEncendido() {
        return encendido;
    }

    public void setEncendido(Boolean encendido) {
        this.encendido = encendido;
    }

    //Métodos
    public void activar() {
        setEncendido(true);
        System.out.println("¡ PI PI PI PI PI PI PI PI PI PI PI !");
    }

    public void desactivar(){
        setEncendido(false);
        System.out.println("...");
    }
}
