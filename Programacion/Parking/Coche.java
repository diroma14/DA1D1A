package Parking;

public class Coche extends Vehiculo implements Aparcable{
    private int nPuertas;

    public Coche(String marca, String modelo, String matrícula, double velocidadMáxima, int nPuertas) {
        super(marca, modelo, matrícula, velocidadMáxima);
        this.nPuertas = nPuertas;
    }

    @Override
    public boolean aparco() {
        return true; // Se asume que un coche siempre puede aparcar si hay espacio
    }
}


