package figuras;

public class Cuadrado implements Figuras,Dibujable{
    private int lado;

    public Cuadrado(int lado) {
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public double area(){
        return lado*lado;
    }

    public void dibujar(){
        System.out.println("Dibujando el cuadrado.");
    }
    
    
}
