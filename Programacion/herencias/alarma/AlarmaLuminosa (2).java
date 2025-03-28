package alarma;

public class AlarmaLuminosa extends Alarma {
    private Luz luz;
    

    

    //Constructor
    public AlarmaLuminosa(Integer umbral, Timbre timbre, Sensor sensor,Luz luz){
        super(umbral, timbre, sensor);
        this.luz = luz;
    }

    //Setters y getters
    public Luz getLuz() {
        return luz;
    }

    public void setLuz(Luz luz) {
        this.luz = luz;
    }

    //Métodos
    public void comprobar(){
        if (getSensor().getValorActual() > getUmbral()) {
            getTimbre().activar();
            luz.encender();
        }else {
            getTimbre().desactivar();
            luz.apagar();
        }
    }
}
