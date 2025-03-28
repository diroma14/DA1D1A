package alarma;

public class Sensor {
    private Integer valorActual;

    // Constructor

    public Sensor(Integer valorActual) {
        this.valorActual = valorActual;
    }

    // Setters y getters
    public Integer getValorActual() {
        return valorActual;
    }

    public void setValorActual(Integer valorActual) {
        this.valorActual = valorActual;
    }
    
}
