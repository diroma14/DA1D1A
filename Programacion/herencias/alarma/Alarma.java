package alarma;

public class Alarma {
    private Integer umbral;
    private Timbre timbre;
    private Sensor sensor;

    // Constructor
    public Alarma(Integer umbral, Timbre timbre, Sensor sensor) {
        this.umbral = umbral;
        this.timbre = timbre;
        this.sensor = sensor;
    }

    // Setters y getters
    public Integer getUmbral() {
        return umbral;
    }

    public void setUmbral(Integer umbral) {
        this.umbral = umbral;
    }

    public Timbre getTimbre() {
        return timbre;
    }

    public void setTimbre(Timbre timbre) {
        this.timbre = timbre;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    //Método comprobar
    public void comprobar(){
        if(sensor.getValorActual() > umbral){
            timbre.activar();
        }else{
            timbre.desactivar();
        }
    }
}
