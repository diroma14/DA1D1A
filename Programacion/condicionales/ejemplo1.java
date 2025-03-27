package Programación.condicionales;
import java.util.Scanner;

public class ejemplo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime la temperatura:");
        int temperatura = sc.nextInt(); 
        sc.close();

        if (temperatura > 0) {
            System.out.println("ºC Positivos");
        } else {
            System.out.println("ºC Negativos");
        }
    }
}
