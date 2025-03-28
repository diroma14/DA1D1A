package Programación.funciones;

import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Dime el valor del número grande:");
       int a = sc.nextInt(); 
       System.out.println("Dime el valor del número pequeño:");
       int b = sc.nextInt(); 
       System.out.println("Dime el valor del número:");
       int c = sc.nextInt();
       sc.close();


       System.out.println("¿El número está dentro del reango?: " + sino(a,b,c));
    }

    private static boolean sino(int a, int b, int c) {
        return c <= a && c >= b;
    }

    
}
