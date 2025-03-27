package objetos;

public class Coche2 {
    // Atributos
    private String marca;
    private String modelo;
    private Integer anoFabricacion;
    private double precio;

    // Constructor
    public Coche2(String marca, String modelo, Integer anoFabricacion, Integer precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacion = anoFabricacion;
        this.precio = precio;
    }

    // Setter y getters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(Integer anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void aplicarDescuento(){
        if (anoFabricacion < 2010) {
            System.out.println("Se va a aplicar un descuento del 10% al coche " + getMarca() + getModelo());
            precio = precio * 0.9;
        }else {
            System.out.println("El coche " + getMarca() + getModelo() + " no es suficientemente antigüo para tener descuento.");
        }
    }

    //Main
    public static void main(String[] args) {
        Coche2 cocheNuevo = new Coche2("Seat", "Tarraco", 2020, 38960);
        Coche2 cocheViejo = new Coche2("Ford", "Focus", 2007, 30792);
        System.out.println("El " + getMarca(cocheNuevo) + getModelo(cocheNuevo) +);
        cocheNuevo.aplicarDescuento();
        
    }
}
