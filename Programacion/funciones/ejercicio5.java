package Programación.funciones;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Dime el valor de la base del triángulo:");
       int a = sc.nextInt(); 
       System.out.println("Dime el valor de la altura del rectángulo:");
       int b = sc.nextInt();
       sc.close();

       

       System.out.println("El area del rectángulo es: " + areaTri(a, b));
    }

    private static int areaTri(int a, int b) {
        return (a*b)/2;
    }
}
