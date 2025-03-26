package Programación.practica1;

import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Dime el número:");
       
       int numero = sc.nextInt();

       int parimpar = numero % 2 ;

       if (parimpar == 0) {
        System.out.println("El número es par.");
       } else {
        System.out.println("El número es impar.");
       }
       sc.close();
    }
}
