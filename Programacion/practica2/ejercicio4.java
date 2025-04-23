import java.util.Scanner;
public class ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el primer número:");
        int numero1 = sc.nextInt();


        System.out.println("Dime el segundo número:");
        int numero2 = sc.nextInt();


        int i = numero1;


        while (i<=numero2) {
            if (i%2 == 0) {
                System.out.println("El número :" + i + " es par.");
                i++;
           }else {
               i++;
           }
        }
        sc.close();
    }
}
