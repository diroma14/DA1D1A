package figuras;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Circulo micirculo = new Circulo(10); // Radio=10
        Cuadrado micuadrado = new Cuadrado(10); // Lado=10
        Triangulo mitriangulo = new Triangulo(10, 5); // Base=10, Altura=5;

        micirculo.rotar();
        micirculo.dibujar();
    }
}
