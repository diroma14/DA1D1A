package Programación.scanner;
import java.util.Scanner;

public class scanner {
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Dime el valor de la base del rectángulo:");
       int base = sc.nextInt(); 
       System.out.println("Dime el valor de la altura del rectángulo:");
       int altura = sc.nextInt();
       sc.close();

       int area = base*altura;

       System.out.println("El area del rectángulo es: " + area);
    }
}
