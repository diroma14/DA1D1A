package Parking;

public class Moto extends Vehiculo implements Aparcable{
    private int cilindradas;

    public Moto(String marca, String modelo, String matrícula, double velocidadMáxima, int cilindradas) {
        super(marca, modelo, matrícula, velocidadMáxima);
        this.cilindradas = cilindradas;
    }

    @Override
    public boolean aparco() {
        return true; // Se asume que una moto siempre puede aparcar si hay espacio
    }
}


