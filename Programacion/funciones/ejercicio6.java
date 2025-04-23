package Programación.funciones;

import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Dime el valor del primer número:");
       int a = sc.nextInt(); 
       System.out.println("Dime el valor del segundo número");
       int b = sc.nextInt();
       sc.close();

       

       System.out.println("¿Son el mismo númeor?: " + sino(a, b));
    }

    private static boolean sino(int a, int b) {
        return (a==b);
    }
}
