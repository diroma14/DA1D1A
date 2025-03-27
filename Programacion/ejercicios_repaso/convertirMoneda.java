package Programación.ejercicios_repaso;
import java.util.Scanner;

public class convertirMoneda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cantidad en euros.");
        int euros = sc.nextInt();  
        System.out.println("Introduce la moneda a la que quieres convertir el dinero.");
        System.out.println("Dólares--> 1");
        System.out.println("Yenes--> 2");
        System.out.println("Libras--> 3");
        int moneda = sc.nextInt();
        sc.close();

        
        convertirMonedas(euros, moneda);
    }

    // Método para convertir la moneda
    private static void convertirMonedas(int euros, int moneda) {
        double resultado = 0; 

        if (moneda == 1) { // Dólares
            resultado = euros * 1.09;
        } else if (moneda == 2) { // Yenes
            resultado = euros * 165.54;
        } else if (moneda == 3) { // Libras
            resultado = euros * 0.84;
        } else {
            System.out.println("Opción no válida.");
            return;
        }
        
        System.out.println("El resultado es: " + resultado);
    }
}

