package figuras;

public class Triangulo implements Figuras,Dibujable{
    private int base;
    private int altura;

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double area(){
        return (base*altura)/2;
    }
    
    public void dibujar(){
        System.out.println("Estoy dibujando el triángulo");
    }
}
