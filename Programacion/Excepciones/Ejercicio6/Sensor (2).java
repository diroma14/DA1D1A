package Excepciones.Ejercicio6;

import java.util.Random;

public class Sensor {
    private int temperatura;

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public Sensor(int temperatura) {
        this.temperatura = temperatura;
    }

    public void Comprobar(int temperatura) throws TemperaturaMuyAltaException,TemperaturaMuyBajaException {
        if (temperatura < -10) {
            throw new TemperaturaMuyBajaException("Eror: Temperatura demasiado baja.");
        } else if (temperatura > 50) {
            throw new TemperaturaMuyAltaException("Eror: Temperatura demasiado alta.");
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int valor;
        boolean seguir = true;
        Sensor termometro1 = new Sensor(0);

        while (seguir) {
            valor = rand.nextInt(201) - 100;
            try {
                termometro1.Comprobar(valor);
            } catch (TemperaturaMuyAltaException e) {
                System.out.println("Temperatura demasiado alta.");
            } catch (TemperaturaMuyBajaException e) {
                System.out.println("Temperatura demasiado baja.");
            }finally{
                System.out.println(valor);
                System.out.println();
            }

            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                System.out.println("INterrumpido");
            }

        }

    }

}
