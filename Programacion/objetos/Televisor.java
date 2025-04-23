package objetos;

public class Televisor {

    public static final int NUM_MAX_CANALES = 100;
    // Atributos
    private Boolean encendida;
    private double pulgadas;
    private String marca;
    private String modelo;

    // Constructor
    public Televisor(boolean encendida, double pulgadas, String marca, String modelo) {
        this.encendida = encendida;
        this.pulgadas = pulgadas;
        this.marca = marca;
        this.modelo = modelo;
    }

    // Métodos
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public static void main(String[] args) {
        Televisor televisor01 = new Televisor(true,2.3,"LG","0.2");
        System.out.println(televisor01.getMarca());
        televisor01.setMarca("Samsung");
        System.out.println(televisor01.getMarca());
        

    }
}
