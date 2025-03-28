package alarma;

public class Main {
    public static void main(String[] args) {
        Sensor sensor1 = new Sensor(25);
        Timbre timbre1 = new Timbre(false);
        Luz luz1 = new Luz(false);
        Alarma alarma1 = new Alarma(20, timbre1, sensor1);
        AlarmaLuminosa alarma2 = new AlarmaLuminosa(20, timbre1, sensor1, luz1);

        alarma1.comprobar();
        alarma2.comprobar();

        sensor1.setValorActual(0);
        
        alarma1.comprobar();
        alarma2.comprobar();
    }
}
