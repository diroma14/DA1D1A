public class guerrero extends personaje {
    private int energia;
    private int puntosAtaque;

    // Constructor
    public guerrero(String nombre, Integer ph, Integer nivel, int energia, int puntosAtaque) {
        super(nombre, ph, nivel);
        this.energia = energia;
        this.puntosAtaque = puntosAtaque;
    }

    // Métodos
    public void golpePoderoso() {
        if (energia >= 20) {
            energia -= 20; 
            int daño = puntosAtaque + 25; 
            System.out.println(getNombre() + " realiza un Golpe Poderoso causando " + daño + " puntos de daño. Energía restante: " + energia);
        } else {
            System.out.println(getNombre() + " no tiene suficiente energía para un Golpe Poderoso.");
        }
    }

    // Getter y Setter
    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    public static void main(String[] args) {
        guerrero guerrero1 = new guerrero("Erik", 20, 2, 20, 2);
        guerrero1.golpePoderoso();
        guerrero1.subirNivel();
    }
}

