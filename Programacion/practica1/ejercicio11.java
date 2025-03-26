package Programación.practica1;
import java.util.Scanner;
public class ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un número decimal.");
        float numero = sc.nextFloat();
        sc.close();

        float valor = Math.abs(numero);
        System.out.println("El valor del número es : " + valor);
    }
}
