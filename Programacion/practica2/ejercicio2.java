import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el número:");
       
        int numero = sc.nextInt();
        int i = 1;
        sc.close();

        while (i<=10) {
            System.out.println(numero + " x " + i + " = " + (numero*i));
            i++;
        }
    }
}
