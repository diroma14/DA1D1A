package Programación.booleanos;

public class ejercicio2 {
    public static void main(String[] args) {
        /* Calcula el área de un rectángulo, recibiendo como argumentos su base y su altura. */
        int base = Integer.valueOf(args[0]);
        int altura = Integer.valueOf(args[1]);
        System.out.println("El area del rectángulo de base " + args[0] + " y altura " + args[1] + " es de " + (altura*base));
    }
}
