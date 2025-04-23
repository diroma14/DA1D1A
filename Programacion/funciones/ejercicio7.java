package Programación.funciones;

import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Dime el valor del número:");
       int a = sc.nextInt(); 
       sc.close();


       System.out.println("¿El número es par?: " + sino(a));
    }

    private static boolean sino(int a) {
        return (a%2) == 0;
    }
}
