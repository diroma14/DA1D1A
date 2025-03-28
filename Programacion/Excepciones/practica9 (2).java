package Excepciones;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class practica9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto = "";

        boolean condicion = true;
        // Solicitar el texto.
        try {
            System.out.println("Introduce texto.");
            texto = sc.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("Error. No se ha introducido ningún elemento.");
        } catch (IllegalStateException e) {
            System.out.println("Error. El escaner está cerrado.");
        }

        // Solicitar el número
        while (condicion) {
            try {
                System.out.println(
                        "Introduce la posición del carácter a consultar (1 para el primer carácter, 0 para salir):");
                int numero = sc.nextInt();

                // Si introduce 0 sale.
                if (numero == 0) {
                    System.out.println("Programa terminado.");
                    condicion = false;
                    break;
                }

                //Obtener caracter
                
                try {
                    System.out.println("Carácter en la posición " + numero + ": " + texto.charAt(numero - 1));
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Error: La posición está fuera del rango del texto.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero válido.");
            }
        }

        sc.close();
    }
}
