package alarma;

public class Luz {
    private Boolean encendida;

    // Constructor

    public Luz(Boolean encendida) {
        this.encendida = encendida;
    }

    // Setters y getters
    public Boolean getEncendida() {
        return encendida;
    }

    public void setEncendida(Boolean encendida) {
        this.encendida = encendida;
    }

    //Métodos

    public void encender(){
        setEncendida(true);
        System.out.println("Encendida.");
    }

    public void apagar(){
        setEncendida(false);
        System.out.println("Apagada.");
    }
}
