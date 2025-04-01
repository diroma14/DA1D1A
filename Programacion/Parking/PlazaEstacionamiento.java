package Parking;

public class PlazaEstacionamiento {
    private int numero;
    private boolean ocupada;

    public PlazaEstacionamiento(int numero) {
        this.numero = numero;
        this.ocupada = false;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void ocupar() {
        this.ocupada = true;
    }

    public void liberar() {
        this.ocupada = false;
    }

    @Override
    public String toString() {
        return "Plaza " + numero + " [" + (ocupada ? "Ocupada" : "Libre") + "]";
    }
}


