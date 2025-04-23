package Programación.practica1;

import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       System.out.println("Dime el primer número:");
       int numero1 = sc.nextInt();
       System.out.println("Dime el segundo número:");
       int numero2 = sc.nextInt();
       System.out.println("Dime el tercer número:");
       int numero3 = sc.nextInt();

       if (numero1 == numero2 && numero2 == numero3) {
        System.out.println("Los tres números son iguales.");
       } else {
            if (numero1 >= numero2 && numero1 >= numero3) {
            System.out.println("El número más grande es: " + numero1);
        } else if (numero2 >= numero1 && numero2 >= numero3) {
            System.out.println("El número más grande es: " + numero2);
        }else {
            System.out.println("El número meyor es: " + numero3);
        }
       }

       sc.close();
    }
}

