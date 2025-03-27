package Programación.Bucle;
import java.util.Scanner;

public class anidadas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Dime la altura:");
        int alto = sc.nextInt(); 
        System.out.println("Dime el ancho:");
        int ancho = sc.nextInt(); 
        String s = ""; 
        sc.close();

        for (int i = 0; i < alto; i++){
            for (int j = 0; j < ancho; j++){
                s += "X";
            }
            s +="\n";
        }
        System.out.println(s);
    }
}
