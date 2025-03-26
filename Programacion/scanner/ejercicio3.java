package Programación.scanner;
import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dime el primer apellido:");
        String primerAp = sc.nextLine();

        System.out.println("Dime el segundo apellido:");
        String segundoAp = sc.nextLine();

        System.out.println("Dime el nombre del primer hijo:");
        String primerHi = sc.nextLine();

        System.out.println("Dime el nombre del segundo hijo:");
        String segundoHi = sc.nextLine();

        System.out.println("Dime el nombre del padre:");
        String padre = sc.nextLine();

        System.out.println("Dime el nombre de la madre:");
        String madre = sc.nextLine();

        System.out.println("El padre se llama " + padre + " " + primerAp + " " + segundoAp);

        sc.close();
    }
}
