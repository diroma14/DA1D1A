package Programación.ejercicios_repaso;
import java.util.Scanner;

public class mayormenor {
    public static void main(String[] args) {
        System.out.println("Dame una lista de números sin espacios (Ejemplo: 3529):");
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine(); //Números que mete el usuario
        sc.close();

        int longitud = entrada.length();
        int mayor = Character.getNumericValue(entrada.charAt(0));  // Inicializa al primer dígito
        int menor = Character.getNumericValue(entrada.charAt(0));

        for(int i = 0; i < longitud; i++) {
            int numeroActual = Character.getNumericValue(entrada.charAt(i));
            // System.out.println("Número actual: " + numeroActual); 

            // Compara y actualiza el mayor y menor
            if (numeroActual > mayor) {
                mayor = numeroActual;
            }
            if (numeroActual < menor) {
                menor = numeroActual;
            }
        }

        System.out.println("El número mayor es: " + mayor);
        System.out.println("El número menor es: " + menor);
    }
}
