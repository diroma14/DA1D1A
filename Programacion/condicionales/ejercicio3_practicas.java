package Programación.condicionales;
import java.util.Scanner;

public class ejercicio3_practicas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu sexo (hombre|mujer) :");
        String sexo = sc.nextLine();
        boolean resultado = sexo = "mujer" ? "María" : "Mario";
        System.out.println(resultado);
        sc.close();
    }
    
}