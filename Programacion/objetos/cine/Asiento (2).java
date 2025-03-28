package objetos.cine;

public class Asiento {
    // Atributos
    private char columna;
    private int fila;
    private boolean ocupado;
    private Espectador espectador;

    // Setters y getters

    public char getColumna() {
        return this.columna;
    }

    public void setColumna(char columna) {
        this.columna = columna;
    }

    public int getFila() {
        return this.fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public boolean isOcupado() {
        return this.ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Espectador getEspectador() {
        return this.espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }
    // Constuctores

    public Asiento(char columna, int fila, boolean ocupado, Espectador espectador) {
        this.columna = columna;
        this.fila = fila;
        this.ocupado = ocupado;
        this.espectador = null;
    }
    // Métodos
}
