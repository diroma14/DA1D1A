package Excepciones;

public class Coche {
    private boolean arrancado;
    private boolean marchaAtras;
    private int velocidadMax;
    private int velocidadMaxAtras;
    private int velocidad;

    public Coche(boolean arrancado, boolean marchaAtras, int velocidadMax, int velocidadMaxAtras, int velocidad) {
        arrancado = false;
        marchaAtras = false;
        this.velocidadMax = velocidadMax;
        this.velocidadMaxAtras = velocidadMaxAtras;
        this.velocidad = 0;
    }

    // getters y setters
    public boolean isArrancado() {
        return this.arrancado;
    }

    public void setArrancado(boolean Arrancado) {
        this.arrancado = Arrancado;
    }

    public boolean isMarchaAtras() {
        return this.marchaAtras;
    }

    public void setMarchaAtras(boolean MarchaAtras) {
        this.marchaAtras = MarchaAtras;
    }

    public int getVelocidadMax() {
        return this.velocidadMax;
    }

    public void setVelocidadMax(int velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public int getVelocidadMaxAtras() {
        return this.velocidadMaxAtras;
    }

    public void setVelocidadMaxAtras(int velocidadMaxAtras) {
        this.velocidadMaxAtras = velocidadMaxAtras;
    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    // Métodos

    public void arrancar() {
        if (!arrancado) {
            System.out.println("Arrancado.");
            arrancado = true;
        } else {
            System.out.println("El coche ya está arrancado.");
            throw new IllegalStateException();
        }
    }

    public void detener() {
        if (arrancado && velocidad == 0) {
            System.out.println("Deteniendo.");
            arrancado = false;
        } else if (!arrancado) {
            System.out.println("El coche ya está detenido.");
            throw new IllegalStateException();
        } else if (velocidad != 0) {
            System.out.println("La velocidad debe ser 0.");
            throw new IllegalStateException();
        }
    }

    public void acelerar(int incremento) {
        if (arrancado) {

        }
    }

    public static void main(String[] args) {
        Coche c1 = new Coche(false, false, 200, 100, 0);
        c1.arrancar();
        c1.arrancar();
        c1.detener();
        c1.detener();
    }
}
