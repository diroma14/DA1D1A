package figuras;

public class Circulo implements Figuras,Rotable,Dibujable{
    
    private int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }
    
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public double area(){
        return Math.PI*(Math.pow(radio, 2));
    }

    public void rotar(){
        System.out.println("Rotando el círculo.");
    }

    public void dibujar(){
        System.out.println("Dibujando el círculo.");
    }

    
}
