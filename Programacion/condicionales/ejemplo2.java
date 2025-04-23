package Programación.condicionales;
import java.util.Scanner;

public class ejemplo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime tu edad :");
        int edad = sc.nextInt();
        boolean resultado = edad >= 18 ? true : false;
        System.out.println(resultado);
        sc.close();
    }
    
}
