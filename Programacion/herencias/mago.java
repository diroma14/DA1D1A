public class mago extends personaje {
    private int mana;
    private int puntosMagia;

    // Constructor
    public mago(String nombre, Integer ph, Integer nivel, int mana, int puntosMagia) {
        super(nombre, ph, nivel);
        this.mana = mana;
        this.puntosMagia = puntosMagia;
    }

    // Getter y Setter 
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getPuntosMagia() {
        return puntosMagia;
    }

    public void setPuntosMagia(int puntosMagia) {
        this.puntosMagia = puntosMagia;
    }

      // Hechizos
      public void lanzarHechizo() {
        if (mana >= 10) {
            mana -= 10; // Consume 10 de maná
            int daño = puntosMagia + 15; // Daño basado en puntos de magia
            System.out.println(getNombre() + " lanza un hechizo causando " + daño + " puntos de daño. Maná restante: " + mana);
        } else {
            System.out.println(getNombre() + " no tiene suficiente maná para lanzar un hechizo.");
        }
    }
}

