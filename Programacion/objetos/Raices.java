package objetos;

public class Raices {
    private Integer a;
    private Integer b;
    private Integer c;

    // Constructor
    public Raices(Integer a, Integer b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Setters y getters
    public Integer getA() {
        return this.a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return this.b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return this.c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    // Métodos

    //Devuelve el valor del discriminante
    public double getDiscriminante() {
        int a = this.getA();
        int b = this.getB();
        int c = this.getC();
        double discriminante = Math.pow(b, 2) - 4 * a * c;
        return discriminante;
    }

    //devuelve un booleano indicando si tiene dos soluciones, para que esto ocurra, el discriminante debe ser mayor o igual que 0.
    public boolean tieneRaices(){
        if (getDiscriminante()>0) {
            return true;
        }else{
            return false;
        }
    }

    //devuelve un booleano indicando si tiene una única solución, para que esto ocurra, el discriminante debe ser igual que 0
    public boolean tieneRaiz(){
        if (getDiscriminante()==0) {
            return true;
        }else{
            return false;
        }
    }

    //Obtener raices

    public void obtenerRaices() {
        int b = this.getB();
        double resultadoP;
        double resultadoN;
        resultadoP = (-b+(getDiscriminante())/2);
        resultadoN = (-b-(getDiscriminante()/2));
        System.out.println("Los resultados son " + resultadoP + " y " + resultadoN );
    }

    //Obtener raiz
    
    public void obtenerRaiz() {
        int b = this.getB();
        double resulado = ()
    }
    

    

    public static void main(String[] args) {
        Raices raiz1 = new Raices(4, 4, 2);

        
    }
}

