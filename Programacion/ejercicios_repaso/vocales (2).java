package Programación.ejercicios_repaso;
import java.util.Scanner;

public class vocales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una frase:");
        String frase = sc.nextLine().toLowerCase(); //Recoge la frase y la pone en minúscula
        int longitud = frase.length();
        int vocales = 0;

        for (int i = 0; i < longitud; i++) {
            char letraActual = frase.charAt(i);
            if (letraActual == 'a' || letraActual == 'e' || letraActual == 'i' || letraActual == 'o' || letraActual == 'u') {
                vocales++;
            }
        }
        
        System.out.println("Hay un total de " + vocales + " vocales.");
        
        
        sc.close();
    }
}
