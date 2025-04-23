package Excepciones;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class prueba {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Introduce una opción.");
            int numero = sc.nextInt();
            System.out.println("Hola hola");
        } catch (InputMismatchException e1) {
            System.out.println("Error 1");
        } catch (NoSuchElementException e2) {
            System.out.println("Error 2");
        } catch (IllegalStateException e3) {
            System.out.println("Error 3");
        }
    }

}
